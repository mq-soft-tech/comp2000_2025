import java.awt.Color;

public class Wall extends Cell {
    public Wall(char col, int row, int x, int y){
        super(col, row, x, y);
        this.color = new Color(60, 60, 60);
    }
}
