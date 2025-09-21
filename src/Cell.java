import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public abstract class Cell extends Rectangle {
    public static int size = 35;
    char col;
    int row;

    public Cell(char inCol, int inRow, int x, int y) {
        super(x, y, size, size);
        col = inCol;
        row = inRow;
    }

    
    public abstract void paint(Graphics g, Point mousePos);
}
