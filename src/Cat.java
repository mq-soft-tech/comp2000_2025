import java.awt.Color;
import java.awt.Graphics;

public class Cat extends Actor {
    Color colour;
    Cell location;

    public Cat(){
        super();
        colour = Color.BLUE;
        location = new Cell(80, 30);
    }

    public void paint(Graphics g){
        g.setColor(colour);
        g.drawOval(location.x, location.y, 10, 10);
    }
}
