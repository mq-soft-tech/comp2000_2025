import java.awt.Color;

public class Water extends Cell {
    public Water(char col, int row, int x, int y){
        super(col, row, x, y);
        this.color = new Color ( 0, 255, 0);
    }
}
