public class Grid<T extends Cell> {
    private int rows, cols;
    private Cell[][] cells;

    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.cells = new Cell[rows][cols];
    }

    public int rows() { return rows; }
    public int cols() { return cols; }

    public T get(int r, int c) {
        return (T) cells[r][c];
    }

    public void set(int r, int c, T cell) {
        cells[r][c] = cell;
    }

    public boolean inBounds(int r, int c) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }
}
