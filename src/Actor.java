import java.awt.Graphics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;

public class Actor {
    public Actor(){}

    public void paint(Graphics g, Color colour, Cell cell){
        g.setColor(colour);
        g.drawOval(cell.x, cell.y, 10, 10);
    }
}
