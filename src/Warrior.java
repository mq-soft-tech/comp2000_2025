import java.awt.Color;
import java.awt.Polygon;
import java.util.ArrayList;


public class Warrior extends Actor {
  private final Grid grid;
  private final Cell spawn;

  private int coins = 0;

  public Warrior(Grid grid, Cell inLoc){
    this.grid = grid;
    this.loc = inLoc;
    this.spawn = inLoc;
    this.color = Color.MAGENTA;
    buildPolygons();
  }
  
  public void moveBy(int mc, int mr){
    int currC = loc.col - 'A';
    int currR = loc.row;
    int newC = currC + mc;
    int newR = currR + mr;

    grid.cellAtColRow(newC, newR)
    .filter(cell -> ((Passable) cell).isPassableBy(this))
    .ifPresent(cell -> {
      this.loc = cell;
      buildPolygons();

      if (cell instanceof LavaCell) {
        this.loc = spawn;
        buildPolygons();
        return;
      }
      if (cell instanceof WaterCell) {
        grid.randomFloor().ifPresent(rand -> {
          this.loc = rand;
          buildPolygons();
        });
      }
    });
  }       

  public void addCoins(int n){
    coins+= n;
  }
  public int getCoins(){
    return coins;
  }
  public int getCol(){ 
    return loc.col - 'A'; 
  }
  public int getRow(){ 
    return loc.row; 
  }

 
  private void buildPolygons(){
    display = new ArrayList<>();

    Polygon head = new Polygon();
    head.addPoint(loc.x + 8, loc.y + 2);
    head.addPoint(loc.x + 16, loc.y + 2);
    head.addPoint(loc.x + 16, loc.y + 8);
    head.addPoint(loc.x + 8, loc.y + 8);

    Polygon body = new Polygon();
    body.addPoint(loc.x + 6, loc.y + 8);
    body.addPoint(loc.x + 18, loc.y + 8);
    body.addPoint(loc.x + 18, loc.y + 18);
    body.addPoint(loc.x + 6, loc.y + 18);

    Polygon sword = new Polygon();
    sword.addPoint(loc.x + 21, loc.y + 10);
    sword.addPoint(loc.x + 23, loc.y + 10);
    sword.addPoint(loc.x + 23, loc.y + 24);
    sword.addPoint(loc.x + 21, loc.y + 24);

    Polygon leftArm = new Polygon();
    leftArm.addPoint(loc.x + 4, loc.y + 9);
    leftArm.addPoint(loc.x + 6, loc.y + 9);
    leftArm.addPoint(loc.x + 6, loc.y + 12);
    leftArm.addPoint(loc.x + 4, loc.y + 12);

    Polygon rightArm = new Polygon();
    rightArm.addPoint(loc.x + 18, loc.y + 9);
    rightArm.addPoint(loc.x + 20, loc.y + 9);
    rightArm.addPoint(loc.x + 20, loc.y + 12);
    rightArm.addPoint(loc.x + 18, loc.y + 12);

    Polygon leftLeg = new Polygon();
    leftLeg.addPoint(loc.x + 8, loc.y + 18);
    leftLeg.addPoint(loc.x + 11, loc.y + 18);
    leftLeg.addPoint(loc.x + 11, loc.y + 24);
    leftLeg.addPoint(loc.x + 8, loc.y + 24);
    
    Polygon rightLeg = new Polygon();
    rightLeg.addPoint(loc.x + 13, loc.y + 18);
    rightLeg.addPoint(loc.x + 16, loc.y + 18);
    rightLeg.addPoint(loc.x + 16, loc.y + 24);
    rightLeg.addPoint(loc.x + 13, loc.y + 24);

    display.add(head);
    display.add(body);
    display.add(sword);
    display.add(leftArm);
    display.add(rightArm);
    display.add(leftLeg);
    display.add(rightLeg);
  }
}
