package FrontEnd;
import BackEnd.Field;
import BackEnd.Figure;

import javax.swing.*;
import java.awt.*;
import java.awt.dnd.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/*
 * GameMenu
 * Class providing a frame for the game's main panel.
 * Describes logic of interaction between panels.
 */
public class GameMenu extends JPanel implements DragGestureListener {

    public static Point location;
    static GridBagConstraints gbc;

    static FieldPanel fieldPanel;
    static NewFigurePanel newFigurePanel;
    static JLabel stopwatchLabel;
    static JFrame mainFrame;
    static Timer timer;

    static int sec = 1;
    static int turns = 0;

    /**
     * Creates and describes objects to be added on in the main screen's frame.
     */
    public GameMenu() {
        Field.initialize();

        setLayout(new GridBagLayout());
        setBackground(new Color(245, 245, 245));

        fieldPanel = new FieldPanel();
        fieldPanel.setPreferredSize(new Dimension(450, 450));
        fieldPanel.setBackground(new Color(230,230,230));
        fieldPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray, 2));
        add(fieldPanel, gbc);

        new DropTargetListener(fieldPanel);

        stopwatchLabel = new JLabel("00:00:00", JLabel.CENTER);
        stopwatchLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        stopwatchLabel.setPreferredSize(new Dimension(100, 30));
        stopwatchLabel.setMaximumSize(stopwatchLabel.getPreferredSize());

        newFigurePanel = new NewFigurePanel();
        newFigurePanel.setPreferredSize(new Dimension(150, 150));
        newFigurePanel.setMaximumSize(newFigurePanel.getPreferredSize());
        newFigurePanel.setBackground(new Color(230,230,230));
        newFigurePanel.setBorder(BorderFactory.createLineBorder(Color.lightGray, 2));
        newFigurePanel.updateFigure();

        var ds = new DragSource();
        ds.createDefaultDragGestureRecognizer(newFigurePanel, DnDConstants.ACTION_MOVE, this);

        // Mouse dragging event listener inside the panel with generated figure
        newFigurePanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent me) {
                me.translatePoint(me.getComponent().getLocation().x, me.getComponent().getLocation().y);
                if ((me.getX() > 0) && (me.getY() > 0) && (me.getX() <= 150) && (me.getY() <= 150)) {
                    newFigurePanel.figure.setXOffSet(me.getX() / 50);
                    newFigurePanel.figure.setYOffSet(me.getY() / 50);
                }
            }
        });

        Button updateButton = new Button("Update figure");
        updateButton.setPreferredSize(new Dimension(100, 30));
        updateButton.setMaximumSize(updateButton.getPreferredSize());
        updateButton.setFocusable(false);
        updateButton.addActionListener(e -> {
            newFigurePanel.updateFigure();
            newFigurePanel.repaint();
        });

        Button endGameButton = new Button("End game");
        endGameButton.setPreferredSize(new Dimension(100, 30));
        endGameButton.setMaximumSize(endGameButton.getPreferredSize());
        endGameButton.setFocusable(false);
        endGameButton.addActionListener(e -> EndGame.init(sec - 1, turns));

        var longPanel = new JPanel();
        longPanel.setLayout(new BoxLayout(longPanel, BoxLayout.Y_AXIS));
        longPanel.setPreferredSize(new Dimension(150, 450));
        longPanel.setBackground(new Color(245, 245, 245));
        longPanel.add(newFigurePanel);
        longPanel.add(Box.createVerticalStrut(5));
        longPanel.add(stopwatchLabel);
        longPanel.add(Box.createVerticalStrut(5));
        longPanel.add(updateButton);
        longPanel.add(Box.createVerticalStrut(10));
        longPanel.add(endGameButton);
        add(longPanel, gbc);
    }

    public static void main(String[] args) {
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        createAndShowUI();

        ActionListener taskPerformer = evt -> {
            var hours = sec / 3600;
            var minutes = (sec % 3600) / 60;
            var seconds = sec % 60;
            stopwatchLabel.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
            ++sec;
        };
        timer = new Timer(1000, taskPerformer);
        timer.start();
    }

    /**
     * Creates main frame to put panels with game's logic in it.
     */
    static void createAndShowUI() {
        mainFrame = new JFrame("Jigsaw Falling into Place");
        mainFrame.setResizable(false);
        mainFrame.getContentPane().add(new GameMenu());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    /**
     * @param dge event of a dragging starting.
     */
    @Override
    public void dragGestureRecognized(DragGestureEvent dge) {
        var cursor = Cursor.getDefaultCursor();
        var component = dge.getComponent();
        location = component.getLocation(location);

        if (dge.getDragAction() == DnDConstants.ACTION_MOVE) {
            cursor = DragSource.DefaultMoveDrop;
        }
        dge.startDrag(cursor, new TransferablePanel(newFigurePanel));
    }

    /**
     * @param figure a figure to draw
     * @param g2d Graphics2D object
     * @param i char index
     * @param x x coordinate
     * @param y y coordinate
     * @return Point object with new x and y.
     */
    public static Point drawFigure(Figure figure, Graphics2D g2d, int i, int x, int y) {
        switch (figure.getWhereToGo().charAt(i)) {
            case 's' -> g2d.fillRect(x, y, 50, 50);
            case 'r' -> {
                x += 50;
                g2d.fillRect(x, y, 50, 50);
            }
            case 'l' -> {
                x -= 50;
                g2d.fillRect(x, y, 50, 50);
            }
            case 'u' -> {
                y -= 50;
                g2d.fillRect(x, y, 50, 50);
            }
            case 'd' -> {
                y += 50;
                g2d.fillRect(x, y, 50, 50);
            }
            case 'b' -> {
                y += 100;
                g2d.fillRect(x, y, 50, 50);
            }
        }
        return new Point(x, y);
    }
}
