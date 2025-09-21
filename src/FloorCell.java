import java.awt.Color;

public class FloorCell extends Cell {
    public FloorCell(char col, int row, int x, int y){
        super(col, row, x, y);
        this.color = new Color (70, 160, 90);
    }
}
