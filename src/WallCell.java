import java.awt.Color;

public class WallCell extends Cell {
    public WallCell(char col, int row, int x, int y){
        super(col, row, x, y);
        this.color = new Color(60, 60, 60);
    }
    @Override public boolean isPassableBy(Actor actor){ 
        return false; 
    }
}
