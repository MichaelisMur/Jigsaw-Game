package BackEnd;

import java.awt.Point;

/*
 * Field
 * Class describing a field's data.
 */
public class Field {

    /**
     * A two-dimensional array of Cell objects.
     */
    public static Cell[][] field;

    /**
     * Initializes an empty field.
     */
    public static void initialize() {
        field = new Cell[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                field[j][i] = new Cell();
            }
        }
    }

    /**
     * Adds figure to a field. Occupies needed cells.
     * @param x x coordinate to add a figure
     * @param y y coordinate to add a figure
     * @param figure a figure to add
     */
    public static void addFigure(int x, int y, Figure figure) {
        // Offset from the top-left corner where dragging started.
        x -= figure.getXOffSet();
        y -= figure.getYOffSet();

        var steps = figure.whereToGo;
        java.awt.Point xy;
        for (int i = 0; i < steps.length(); i++) {
            xy = makeStep(steps, i, x, y);
            x = xy.x;
            y = xy.y;
            field[y][x].setCellOccupied(true);
        }
    }

    /**
     * Check whether the figure can be added to the field at the provided position.
     * @param x x coordinate to add a figure
     * @param y y coordinate to add a figure
     * @param figure a figure to add
     * @return true if figure can be added and false otherwise
     */
    public static boolean checkFigure(int x, int y, Figure figure) {
        // Offset from the top-left corner where dragging started.
        x -= figure.getXOffSet();
        y -= figure.getYOffSet();
        var steps = figure.whereToGo;
        java.awt.Point xy;
        for (int i = 0; i < steps.length(); i++) {
            xy = makeStep(steps, i, x, y);
            x = xy.x;
            y = xy.y;
            try{
                if (field[y][x].isCellOccupied())
                    return false;
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param steps String with directions to draw.
     * @param i char index
     * @param x x coordinate to add a figure
     * @param y y coordinate to add a figure
     * @return Point object with updated x and y coordinates
     */
    public static Point makeStep(String steps, int i, int x, int y) {
        switch (steps.charAt(i)) {
            case 's':
                break;
            case 'r':
                ++x;
                break;
            case 'l':
                --x;
                break;
            case 'd':
                ++y;
                break;
            case 'u':
                --y;
                break;
            case 'b':
                y += 2;
                break;
        }
        return new Point(x, y);
    }
}
