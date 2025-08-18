import java.awt.Color;
import java.awt.Graphics;

public class Cat extends Actor {
    Color colour;
    Cell location;

    public Cat(){
        super();
        colour = Color.BLUE;
        location = new Cell(60, 20);
    }

    public void paint(Graphics g){
        super.paint(g, colour, location);
    }
}
