import java.awt.Color;
import java.awt.Graphics;

public class Dog extends Actor {
    Color colour;
    Cell location;

    public Dog(){
        super();
        colour = Color.YELLOW;
        location = new Cell(100, 100);
    }

    public void paint(Graphics g){
        super.paint(g, colour, location);
    }
}
