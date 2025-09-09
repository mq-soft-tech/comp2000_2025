import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Stage {
  Grid grid;
  List<Actor> actors;

  public Stage() {
    grid = new Grid();
    actors = new ArrayList<Actor>();
    actors.add(new Cat(grid.cellAtColRow(0, 0).get(), grid));
    actors.add(new Dog(grid.cellAtColRow(0, 15).get(), grid));
    actors.add(new Bird(grid.cellAtColRow(12, 9).get(), grid));
  }

  public void paint(Graphics g, Point mouseLoc) {
    grid.paint(g, mouseLoc);
    for(Actor a: actors) {
      a.paint(g);
    }
    Optional<Cell> underMouse = grid.cellAtPoint(mouseLoc);
    if(underMouse.isPresent()) {
      Cell hoverCell = underMouse.get();
      g.setColor(Color.DARK_GRAY);
      g.drawString(String.valueOf(hoverCell.col) + String.valueOf(hoverCell.row), 740, 30);
    }
  }

  public void movePlayer(Direction direction) {
    for(Actor a : actors) {
      if(a instanceof Dog) {
        a.move(direction);
        moveEnemiesRandomly();
        break;
      }
    }
  }

  private void moveEnemiesRandomly() {
    for(Actor a : actors) {
      if(a instanceof Dog) continue;
      int steps = 1 + (int)(Math.random() * 3);
      Direction dir = randomDirection();
      for(int s=0; s<steps; s++) {
        int colIndex = a.loc.col - 'A';
        int rowIndex = a.loc.row;
        int nextCol = colIndex;
        int nextRow = rowIndex;
        switch(dir) {
          case LEFT: nextCol--; break;
          case RIGHT: nextCol++; break;
          case UP: nextRow--; break;
          case DOWN: nextRow++; break;
        }
        if(nextCol < 0 || nextCol > 19 || nextRow < 0 || nextRow > 19) {
          break;
        }
        if(!belongsToTerritory(a, nextCol, nextRow)) {
          break;
        }
        Optional<Cell> target = grid.cellAtColRow(nextCol, nextRow);
        if(target.isPresent()) {
          a.setLocation(target.get());
        }
      }
    }
  }

  private Direction randomDirection() {
    int r = (int)(Math.random() * 4);
    switch(r) {
      case 0: return Direction.UP;
      case 1: return Direction.DOWN;
      case 2: return Direction.LEFT;
      default: return Direction.RIGHT;
    }
  }

  private boolean belongsToTerritory(Actor a, int col, int row) {
    if(a instanceof Cat) {
      return row >= 0 && row <= 6;
    }
    if(a instanceof Bird) {
      return row >= 7 && row <= 13;
    }
    return true;
  }
}
