import java.awt.Color;
import java.awt.Polygon;
import java.util.ArrayList;

public class Warrior extends Actor {
  public Warrior(Cell inLoc) {
    loc = inLoc;
    color = Color.RED;
    display = new ArrayList<Polygon>();

    Polygon head = new Polygon();
    head.addPoint(loc.x + 16, loc.y + 5);
    head.addPoint(loc.x + 19, loc.y + 5);
    head.addPoint(loc.x + 19, loc.y + 12);
    head.addPoint(loc.x + 16, loc.y + 12);
    
    Polygon body = new Polygon();
    body.addPoint(loc.x + 15, loc.y + 12);
    body.addPoint(loc.x + 20, loc.y + 12);
    body.addPoint(loc.x + 20, loc.y + 25);
    body.addPoint(loc.x + 15, loc.y + 25);
    
    Polygon sword = new Polygon();
    sword.addPoint(loc.x + 21, loc.y + 10);
    sword.addPoint(loc.x + 23, loc.y + 10);
    sword.addPoint(loc.x + 23, loc.y + 24);
    sword.addPoint(loc.x + 21, loc.y + 24);

    display.add(head);
    display.add(body);
    display.add(sword);
  }
}
