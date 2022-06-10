package BackEnd;

/*
 * Cell
 * Class describing a cell inside a field with figures.
 */
public class Cell {
    boolean cellOccupied = false;

    /**
     * @return true if cell is occupied by any figure
     */
    public boolean isCellOccupied() {
        return cellOccupied;
    }

    /**
     * Sets cell's condition.
     * @param cellOccupied true/false to occupy
     */
    public void setCellOccupied(boolean cellOccupied) {
        this.cellOccupied = cellOccupied;
    }
}
