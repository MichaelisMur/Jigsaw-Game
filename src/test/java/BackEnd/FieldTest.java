package BackEnd;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {
    static Figure figure;
    static Cell[][] array;

    @BeforeAll
    static void setUp() {

        /*
            Figure 0:
            ■ ■ .
            ■ . .
            ■ . .  */
        figure = new Figure(0);

        array = new Cell[9][9];
    }

    @Test
    void initialize() {
        Field.initialize();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                array[j][i] = new Cell();
            }
        }

        // An empty array should have been initialized.
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                assertEquals(array[i][j].cellOccupied, Field.field[i][j].cellOccupied);
            }
        }
    }

    @Test
    void addFigure() {
        Field.initialize();
        Field.addFigure(1, 2, figure);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                array[j][i] = new Cell();
            }
        }

        // Manually occupying right cells.
        array[2][1].setCellOccupied(true);
        array[3][1].setCellOccupied(true);
        array[4][1].setCellOccupied(true);
        array[2][2].setCellOccupied(true);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                assertEquals(Field.field[j][i].cellOccupied, array[j][i].cellOccupied);
            }
        }
    }

    @Test
    void checkFigure() {
        Field.initialize();
        Field.addFigure(1, 2, figure);

        Cell cell;

        // Creating fully occupied field.
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                cell = new Cell();
                cell.setCellOccupied(true);
                array[j][i] = cell;
            }
        }

        // Making right cells unoccupied.
        Field.field[2][1].setCellOccupied(false);
        Field.field[3][1].setCellOccupied(false);
        Field.field[4][1].setCellOccupied(false);
        Field.field[2][2].setCellOccupied(false);

        assertTrue(Field.checkFigure(1, 2, figure));
    }

    @Test
    void makeStep() {
        Field.initialize();
        Point point = Field.makeStep("d", 0, 1, 1);
        assertEquals(point.x, 1);
        assertEquals(point.y, 2);
    }
}