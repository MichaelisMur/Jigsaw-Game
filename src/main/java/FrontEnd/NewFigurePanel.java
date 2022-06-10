package FrontEnd;

import BackEnd.Figure;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/*
 * NewFigurePanel
 * Panel representing a field where new figures are generated in.
 */
class NewFigurePanel extends JPanel {

    Random random = new Random();
    Figure figure;

    /**
     * Generate new figure.
     */
    void updateFigure() {
        int randomFigureNumber = random.nextInt(31);
        figure = new Figure(randomFigureNumber);
    }

    /**
     * Draws the field with generated figure in it.
     * @param g Graphics object
     */
    void doDrawing(Graphics g) {
        int x = 0, y = 0;
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(new Color(50, 50, 255));
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        Point xy;
        for (int i = 0; i < figure.getWhereToGo().length(); i++) {
            xy = GameMenu.drawFigure(figure, g2d, i, x, y);
            x = xy.x;
            y = xy.y;
            g2d.setPaint(Color.lightGray);
            g2d.drawLine(x, y, x + 50, y);
            g2d.drawLine(x + 50, y, x + 50, y + 50);
            g2d.drawLine(x + 50, y + 50, x, y + 50);
            g2d.drawLine(x, y + 50, x, y);
            g2d.setPaint(new Color(50, 50, 255));
        }
    }

    /**
     * Draws the field and a generated figure in it.
     * @param g Graphics object.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}
