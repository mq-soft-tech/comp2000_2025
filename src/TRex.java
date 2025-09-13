import java.awt.*;
import java.util.*;

public class TRex extends Actor {
  public TRex(Cell inLoc) {
    loc = inLoc;
    color = Color.MAGENTA;
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
    face.addPoint(loc.x + 5, loc.y + 10);
    face.addPoint(loc.x + 35, loc.y + 10);
    face.addPoint(loc.x + 35, loc.y + 30);
    face.addPoint(loc.x + 5, loc.y + 30);
    display.add(face);
    display.add(ear1);
    display.add(ear2);
  }
}
