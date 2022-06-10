package BackEnd;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import static org.junit.jupiter.api.Assertions.*;

class FigureTest {

    @Test
    void setXOffSet() throws NoSuchFieldException, IllegalAccessException {
        final Figure figure = new Figure(0);
        figure.setXOffSet(2);

        final Field field = figure.getClass().getDeclaredField("xOffSet");
        field.setAccessible(true);
        assertEquals(field.get(figure), 2, "Fields didn't match");
    }

    @Test
    void setYOffSet() throws NoSuchFieldException, IllegalAccessException {
        final Figure figure = new Figure(0);
        figure.setYOffSet(1);

        final Field field = figure.getClass().getDeclaredField("yOffSet");
        field.setAccessible(true);
        assertEquals(field.get(figure), 1, "Fields didn't match");
    }

    @Test
    void getWhereToGo() throws NoSuchFieldException, IllegalAccessException {
        final Figure figure = new Figure(0);
        final Field field = figure.getClass().getDeclaredField("whereToGo");
        field.setAccessible(true);
        field.set(figure, "drawing directions");

        final String result = figure.getWhereToGo();

        assertEquals("drawing directions", result,
                "Field whereToGo wasn't retrieved properly");
    }

    @Test
    void getXOffSet() throws NoSuchFieldException, IllegalAccessException {
        final Figure figure = new Figure(0);
        final Field field = figure.getClass().getDeclaredField("xOffSet");
        field.setAccessible(true);
        field.set(figure, 0);

        final int result = figure.getXOffSet();

        assertEquals(0, result, "Field xOffSet wasn't retrieved properly");
    }

    @Test
    void getYOffSet() throws NoSuchFieldException, IllegalAccessException {
        final Figure figure = new Figure(0);
        final Field field = figure.getClass().getDeclaredField("yOffSet");
        field.setAccessible(true);
        field.set(figure, 2);

        final int result = figure.getYOffSet();

        assertEquals(2, result, "Field yOffSet wasn't retrieved properly");
    }
}