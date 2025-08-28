import java.awt.Graphics;
public class Cell {


    // DATA
    int squareSize;
    int row;
    int col;
    java.awt.Color BLACK; 
    java.awt.Color RED;


    // CONSTRUCTORS
    public Cell(int r, int c, int s){
        row = r;
        col = c;
        squareSize = s;
    }



    // METHODS
    // paint
    public void paint(Graphics c) {
        c.setColor(BLACK);
        c.drawRect(row, col, squareSize, squareSize);
        c.setColor(RED);
        c.fillRect(row, col, squareSize, squareSize);
    }

}
