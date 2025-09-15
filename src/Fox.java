import java.awt.Color;
import java.awt.Polygon;
import java.util.ArrayList;

public class Fox extends Actor {
  public Fox(Cell inLoc, Grid gameGrid) {
    super(inLoc, gameGrid);
    color = new Color(230, 120, 40);
    display = new ArrayList<Polygon>();
    updatePolygons();
  }

  protected void updatePolygons() {
    display.clear();
    Polygon ear1 = new Polygon();
    ear1.addPoint(loc.x + 8, loc.y + 6);
    ear1.addPoint(loc.x + 13, loc.y + 16);
    ear1.addPoint(loc.x + 5, loc.y + 16);
    Polygon ear2 = new Polygon();
    ear2.addPoint(loc.x + 24, loc.y + 6);
    ear2.addPoint(loc.x + 29, loc.y + 16);
    ear2.addPoint(loc.x + 21, loc.y + 16);
    Polygon face = new Polygon();
    face.addPoint(loc.x + 6, loc.y + 16);
    face.addPoint(loc.x + 28, loc.y + 16);
    face.addPoint(loc.x + 17, loc.y + 30);
    display.add(face);
    display.add(ear1);
    display.add(ear2);
  }
}


