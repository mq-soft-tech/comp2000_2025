import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;

public class Cat extends Actor {
  public Cat(Cell inLoc) {
    super(inLoc, "Cat");
    color = new Color(100, 150, 255);
    display = new ArrayList<Polygon>();
    Polygon ear1 = new Polygon();
    ear1.addPoint(loc.x + 11, loc.y + 5);
    ear1.addPoint(loc.x + 15, loc.y + 15);
    ear1.addPoint(loc.x + 7, loc.y + 15);
    Polygon ear2 = new Polygon();
    ear2.addPoint(loc.x + 22, loc.y + 5);
    ear2.addPoint(loc.x + 26, loc.y + 15);
    ear2.addPoint(loc.x + 18, loc.y + 15);
    Polygon face = new Polygon();
    face.addPoint(loc.x + 5, loc.y + 15);
    face.addPoint(loc.x + 29, loc.y + 15);
    face.addPoint(loc.x + 17, loc.y + 30);
    display.add(face);
    display.add(ear1);
    display.add(ear2);
  }
  
  @Override
  protected void drawDetails(Graphics g) {
    // Draw cat eyes
    g.setColor(Color.BLACK);
    g.fillOval(loc.x + 12, loc.y + 18, 3, 3);
    g.fillOval(loc.x + 20, loc.y + 18, 3, 3);
    
    // Draw cat nose
    g.setColor(Color.PINK);
    g.fillOval(loc.x + 16, loc.y + 22, 2, 2);
    
    // Draw cat whiskers
    g.setColor(Color.BLACK);
    g.drawLine(loc.x + 8, loc.y + 20, loc.x + 12, loc.y + 22);
    g.drawLine(loc.x + 8, loc.y + 24, loc.x + 12, loc.y + 24);
    g.drawLine(loc.x + 22, loc.y + 22, loc.x + 26, loc.y + 20);
    g.drawLine(loc.x + 22, loc.y + 24, loc.x + 26, loc.y + 24);
  }
}
