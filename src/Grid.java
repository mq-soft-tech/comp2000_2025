import java.awt.*;

public class Grid {
    Cell[][] cells = new Cell[20][20];
    public Grid(){
        for (int i=0; i<cells.length; i++){
        for(int j=0; j<cells[i].length; j++){
            cells[i][j] = new Cell(10+35*i,10+35*j);
        }
    }
    }

    public void paint(Graphics g){
for (int i=0; i<cells.length; i++){
        for(int j=0; j<cells[i].length; j++){
            cells[i][j].paint(g);
        }
    }
    }
}
