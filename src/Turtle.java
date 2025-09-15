import java.awt.Color;
import java.awt.Polygon;
import java.util.ArrayList;

public class Turtle extends Actor {
  public Turtle(Cell inLoc, Grid gameGrid) {
    super(inLoc, gameGrid);
    color = new Color(60, 160, 80);
    display = new ArrayList<Polygon>();
    updatePolygons();
  }

  protected void updatePolygons() {
    display.clear();
    Polygon shell = new Polygon();
    shell.addPoint(loc.x + 8, loc.y + 10);
    shell.addPoint(loc.x + 26, loc.y + 10);
    shell.addPoint(loc.x + 26, loc.y + 24);
    shell.addPoint(loc.x + 8, loc.y + 24);
    Polygon head = new Polygon();
    head.addPoint(loc.x + 26, loc.y + 14);
    head.addPoint(loc.x + 32, loc.y + 16);
    head.addPoint(loc.x + 26, loc.y + 18);
    display.add(shell);
    display.add(head);
  }
}


