import java.awt.Color;
import java.awt.Graphics;

public class Bird extends Actor {
    Color colour;
    Cell location;

    public Bird(){
        super();
        colour = Color.GREEN;
        location = new Cell(20, 50);
    }

    public void paint(Graphics g){
        g.setColor(colour);
        g.drawOval(location.x, location.y, 10, 10);
    }
}
