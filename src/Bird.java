import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;

public class Bird extends Actor {
  public Bird(Cell inLoc) {
    super(inLoc, "Bird");
    color = new Color(100, 200, 100);
    display = new ArrayList<Polygon>();
    Polygon wing1 = new Polygon();
    wing1.addPoint(loc.x + 5, loc.y + 5);
    wing1.addPoint(loc.x + 15, loc.y + 17);
    wing1.addPoint(loc.x + 5, loc.y + 17);
    Polygon wing2 = new Polygon();
    wing2.addPoint(loc.x + 30, loc.y + 5);
    wing2.addPoint(loc.x + 20, loc.y + 17);
    wing2.addPoint(loc.x + 30, loc.y + 17);
    Polygon body = new Polygon();
    body.addPoint(loc.x + 15, loc.y + 10);
    body.addPoint(loc.x + 20, loc.y + 10);
    body.addPoint(loc.x + 20, loc.y + 25);
    body.addPoint(loc.x + 15, loc.y + 25);
    display.add(body);
    display.add(wing1);
    display.add(wing2);
  }
  
  @Override
  protected void drawDetails(Graphics g) {
    // Draw bird eye
    g.setColor(Color.BLACK);
    g.fillOval(loc.x + 16, loc.y + 12, 2, 2);
    
    // Draw bird beak
    g.setColor(new Color(255, 200, 100));
    g.fillPolygon(new int[]{loc.x + 17, loc.x + 19, loc.x + 17}, 
                  new int[]{loc.y + 15, loc.y + 16, loc.y + 17}, 3);
    
    // Draw wing patterns
    g.setColor(new Color(80, 160, 80));
    g.drawLine(loc.x + 8, loc.y + 8, loc.x + 12, loc.y + 12);
    g.drawLine(loc.x + 22, loc.y + 8, loc.x + 26, loc.y + 12);
  }
}
