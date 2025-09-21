import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;

public class Dog extends Actor {
  public Dog(Cell inLoc) {
    super(inLoc, "Dog");
    color = new Color(255, 200, 100);
    display = new ArrayList<Polygon>();
    Polygon ear1 = new Polygon();
    ear1.addPoint(loc.x + 5, loc.y + 5);
    ear1.addPoint(loc.x + 15, loc.y + 5);
    ear1.addPoint(loc.x + 5, loc.y + 15);
    Polygon ear2 = new Polygon();
    ear2.addPoint(loc.x + 20, loc.y + 5);
    ear2.addPoint(loc.x + 30, loc.y + 5);
    ear2.addPoint(loc.x + 30, loc.y + 15);
    Polygon face = new Polygon();
    face.addPoint(loc.x + 8, loc.y + 7);
    face.addPoint(loc.x + 27, loc.y + 7);
    face.addPoint(loc.x + 27, loc.y + 25);
    face.addPoint(loc.x + 8, loc.y + 25);
    display.add(face);
    display.add(ear1);
    display.add(ear2);
  }
  
  @Override
  protected void drawDetails(Graphics g) {
    g.setColor(Color.BLACK);
    g.fillOval(loc.x + 12, loc.y + 12, 3, 3);
    g.fillOval(loc.x + 20, loc.y + 12, 3, 3);
    g.setColor(Color.BLACK);
    g.fillOval(loc.x + 16, loc.y + 18, 2, 2);
    g.setColor(Color.BLACK);
    g.drawLine(loc.x + 16, loc.y + 20, loc.x + 16, loc.y + 22);
    g.drawLine(loc.x + 16, loc.y + 22, loc.x + 14, loc.y + 24);
    g.drawLine(loc.x + 16, loc.y + 22, loc.x + 18, loc.y + 24);
  }
}
