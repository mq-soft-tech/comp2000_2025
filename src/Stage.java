import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
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
      for(int s=0; s<steps; s++) {
        int colIndex = a.loc.col - 'A';
        int rowIndex = a.loc.row;
        List<Direction> allowed = allowedDirections(a, colIndex, rowIndex);
        if(allowed.isEmpty()) break;
        Direction dir = allowed.get((int)(Math.random() * allowed.size()));
        int[] next = applyDirection(colIndex, rowIndex, dir);
        Optional<Cell> target = grid.cellAtColRow(next[0], next[1]);
        if(target.isPresent()) {
          a.setLocation(target.get());
        }
      }
    }
  }

  private List<Direction> allowedDirections(Actor a, int col, int row) {
    List<Direction> dirs = new ArrayList<Direction>(Arrays.asList(Direction.UP, Direction.DOWN, Direction.LEFT, Direction.RIGHT));
    List<Direction> allowed = new ArrayList<Direction>();
    for(Direction d : dirs) {
      int[] next = applyDirection(col, row, d);
      int nc = next[0];
      int nr = next[1];
      if(nc < 0 || nc > 19 || nr < 0 || nr > 19) continue;
      if(!belongsToTerritory(a, nc, nr)) continue;
      allowed.add(d);
    }
    return allowed;
  }

  private int[] applyDirection(int col, int row, Direction d) {
    int nc = col;
    int nr = row;
    switch(d) {
      case LEFT: nc--; break;
      case RIGHT: nc++; break;
      case UP: nr--; break;
      case DOWN: nr++; break;
    }
    return new int[] { nc, nr };
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
