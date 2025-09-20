import java.awt.Color;

public class WaterCell extends Cell {
    public WaterCell(char col, int row, int x, int y){
        super(col, row, x, y);
        this.color = new Color ( 0, 255, 0);
    }
}
