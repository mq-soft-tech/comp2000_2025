import java.awt.Color;
import java.awt.Polygon;
import java.util.ArrayList;

public class Rabbit extends Actor {
  public Rabbit(Cell inLoc, Grid gameGrid) {
    super(inLoc, gameGrid);
    color = new Color(200, 200, 200);
    display = new ArrayList<Polygon>();
    updatePolygons();
  }

  protected void updatePolygons() {
    display.clear();
    Polygon ear1 = new Polygon();
    ear1.addPoint(loc.x + 10, loc.y + 4);
    ear1.addPoint(loc.x + 12, loc.y + 16);
    ear1.addPoint(loc.x + 8, loc.y + 16);
    Polygon ear2 = new Polygon();
    ear2.addPoint(loc.x + 22, loc.y + 4);
    ear2.addPoint(loc.x + 24, loc.y + 16);
    ear2.addPoint(loc.x + 20, loc.y + 16);
    Polygon face = new Polygon();
    face.addPoint(loc.x + 8, loc.y + 16);
    face.addPoint(loc.x + 26, loc.y + 16);
    face.addPoint(loc.x + 17, loc.y + 28);
    display.add(face);
    display.add(ear1);
    display.add(ear2);
  }
}


