import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

public abstract class Actor {
  protected Cell loc;
  private int energy = 5;
  private final Bag<Item> bag = new Bag<>();

  public String getName(){ return getClass().getSimpleName(); }
  public void boostEnergy(int d){ energy += d; }
  public int getEnergy(){ return energy; }
  public void bagAdd(Item it){ bag.add(it); }
  protected Color color = Color.BLACK;
  protected List<Polygon> display = new ArrayList<>();

  public void paint(Graphics g) {
    g.setColor(color);
    for (Polygon p : display) {
      g.fillPolygon(p);
    }
  }

  public boolean tryMoveBy(int dc, int dr, Grid grid){
    int c = loc.colIndex(), r = loc.rowIndex();
    int nc = c + dc, nr = r + dr;

    var destOpt = grid.cellAtColRow(nc, nr); 
    if (destOpt.isEmpty()) return false;

    Cell dest = destOpt.get();

    if (dest instanceof TerrainCell){
      TerrainCell tc = (TerrainCell) dest;
      if (!tc.isPassableBy(this)){
        System.out.println(getName()+": blocked by "+tc.getTerrain());
        return false;
      }
      int cost = tc.moveCost(this);
      if (cost > 0){ energy -= cost; }
        moveTo(dest);
        tc.pickupAll(this);
            
    } else {
        moveTo(dest);
      }
    System.out.println(getName()+" at "+nc+","+nr+" energy="+energy);
      return true;
  }

  protected void moveTo(Cell newLoc){ this.loc = newLoc;}

}