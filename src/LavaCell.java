import java.awt.Color;

public class LavaCell extends Cell {
    public LavaCell(char col, int row, int x, int y){
        super(col, row, x, y);
        this.color = new Color(210, 80, 30);
    }
}