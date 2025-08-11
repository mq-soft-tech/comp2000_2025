import java.awt.Color;
import java.awt.Graphics;

public class Cell {
    private int row;
    private int col;
    private int cellSize;
    private int offset; // margin from the panel’s top-left

    public Cell(int row, int col, int cellSize, int offset) {
        this.row = row;
        this.col = col;
        this.cellSize = cellSize;
        this.offset = offset;
    }

    public void paint(Graphics g, boolean highlighted) {
        int x = offset + col * cellSize;
        int y = offset + row * cellSize;

        // fill: light gray if highlighted, white otherwise
        g.setColor(highlighted ? Color.LIGHT_GRAY : Color.WHITE);
        g.fillRect(x + 1, y + 1, cellSize - 1, cellSize - 1);

        // draw the cell outline
        g.setColor(Color.BLACK);
        g.drawRect(x, y, cellSize, cellSize);
    }
}
