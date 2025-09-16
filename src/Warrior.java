import java.awt.Color;
import java.awt.Polygon;
import java.util.ArrayList;

public class Warrior extends Actor {

  private final Grid grid;   

  public Warrior(Grid grid, Cell inLoc) {
    this.grid  = grid;
    this.loc   = inLoc;      
    this.color = Color.RED;  
    rebuildDisplay();        
  }

  
  public void moveBy(int mc, int mr) {
    int currC = loc.col - 'A';  
    int currR = loc.row;       
    int newC  = currC + mc;
    int newR  = currR + mr;

    grid.cellAtColRow(newC, newR).ifPresent(cell -> {
      this.loc = cell;        
      rebuildDisplay();         
    });
  }

 
  private void rebuildDisplay() {
    display = new ArrayList<>();

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
