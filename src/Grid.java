import java.awt.Graphics;
public class Grid {
    // DATA
    int xPos;
    int yPos;
    int rowNum; // Number of rows
    int colNum; // Number of columns
    int squareSize;
    Cell[][] squares;
    java.awt.Color BLACK; 

    // CONSTRUCTORS
    public Grid(int r, int c, int x, int y){
        rowNum = r;
        colNum = c;
        squares = new Cell[rowNum][colNum];
        for (int i = 0+xPos; i < rowNum * squareSize; i+=squareSize){
            for (int j = 0+yPos; j < colNum * squareSize; j+=squareSize){
                squares[i][j] = new Cell(i, j, squareSize); //PROBLEM
            }
        }
    }

    // METHODS
    public void paint(Graphics g) {
	    g.setColor(BLACK);
        for (int i =0; i< squares.length; i++){
            for (int j=0; j<squares[i].length; j++){
                squares[i][j].paint(g);
            }
        }    
    }
}
