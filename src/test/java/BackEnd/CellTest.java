package BackEnd;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    @Test
    void isCellOccupied() throws NoSuchFieldException, IllegalAccessException {
        final Cell cell = new Cell();
        final Field field = cell.getClass().getDeclaredField("cellOccupied");
        field.setAccessible(true);
        field.set(cell, true);

        final boolean result = cell.isCellOccupied();

        assertTrue(result);
    }

    @Test
    void setCellOccupied() throws NoSuchFieldException, IllegalAccessException {
        final Cell cell = new Cell();
        cell.setCellOccupied(true);

        final Field field = cell.getClass().getDeclaredField("cellOccupied");
        field.setAccessible(true);
        assertEquals(field.get(cell), true);
    }
}