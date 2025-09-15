import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.List;
import java.util.Optional;

public abstract class Actor implements Movement {
  Color color;
  Cell loc;
  List<Polygon> display;
  Grid grid;

  public Actor(Cell location, Grid gameGrid) {
    loc = location;
    grid = gameGrid;
  }

  public void paint(Graphics g) {
    for(Polygon p: display) {
      g.setColor(color);
      g.fillPolygon(p);
      g.setColor(Color.GRAY);
      g.drawPolygon(p);
    }
  }

  public boolean canMove(Direction direction) {
    int newCol = loc.col - 'A';
    int newRow = loc.row;
    
    switch(direction) {
      case UP: newRow--; break;
      case DOWN: newRow++; break;
      case LEFT: newCol--; break;
      case RIGHT: newCol++; break;
    }
    
    return newCol >= 0 && newCol < 20 && newRow >= 0 && newRow < 20;
  }

  public void move(Direction direction) {
    if(canMove(direction)) {
      int newCol = loc.col - 'A';
      int newRow = loc.row;
      
      switch(direction) {
        case UP: newRow--; break;
        case DOWN: newRow++; break;
        case LEFT: newCol--; break;
        case RIGHT: newCol++; break;
      }
      
      Optional<Cell> newCell = grid.cellAtColRow(newCol, newRow);
      if(newCell.isPresent()) {
        loc = newCell.get();
        updatePolygons();
      }
    }
  }

  protected abstract void updatePolygons();

  protected void setLocation(Cell newLocation) {
    loc = newLocation;
    updatePolygons();
  }
}
