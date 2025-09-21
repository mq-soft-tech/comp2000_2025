import java.awt.*;

public class GrassCell extends Cell implements Walkable {
    public GrassCell(char col, int row, int x, int y){
        super(col, row, x, y);
    }

    public int moveCost() {
        return 1;
    }

    public void paint(Graphics g, Point mousePos) {
        if (contains(mousePos)) {
            g.setColor(new Color(180, 220, 180)); 
        } else {
            g.setColor(new Color(160, 200, 160)); 
        }
        g.fillRect(x, y, size, size); 

        g.setColor(Color.BLACK);
        g.drawRect(x, y, size, size); 
    }
}
