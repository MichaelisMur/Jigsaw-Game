package FrontEnd;

import BackEnd.Field;
import BackEnd.Figure;

import javax.swing.*;
import java.awt.*;

/*
 * FieldPanel
 * Panel representing a field to put generated figures in it.
 */
class FieldPanel extends JPanel {
    public Figure shadow = null;        // data of the ready to be placed in the field figure

    /**
     * Draws all the field with content in it.
     * @param g Graphics object.
     */
    void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(2));

        g2d.setPaint(new Color(50, 50, 255));
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        // Draws every cell in the field.
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (Field.field[i][j].isCellOccupied()) {
                    g2d.fillRect(j * 50, i * 50, 50, 50);
                    g2d.setPaint(Color.lightGray);
                    g2d.drawLine(j * 50, i * 50, j * 50 + 50, i * 50);
                    g2d.drawLine(j * 50 + 50, i * 50, j * 50 + 50, i * 50 + 50);
                    g2d.drawLine(j * 50 + 50, i * 50 + 50, j * 50, i * 50 + 50);
                    g2d.drawLine(j * 50, i * 50 + 50, j * 50, i * 50);
                    g2d.setPaint(new Color(50, 50, 255));
                }
            }
        }

        // If there's no figure to be added currently.
        if (shadow == null) {
            return;
        }
        int x = GameMenu.location.x - GameMenu.location.x % 50 - shadow.getXOffSet()*50;
        int y = GameMenu.location.y - GameMenu.location.y % 50 - shadow.getYOffSet()*50;
        g2d.setPaint(Color.lightGray);
        Point xy;
        for (int i = 0; i < shadow.getWhereToGo().length(); i++) {
            xy = GameMenu.drawFigure(shadow, g2d, i, x, y);
            x = xy.x;
            y = xy.y;
        }
    }

    /**
     * Draws field's content.
     * @param g Graphics object.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
}