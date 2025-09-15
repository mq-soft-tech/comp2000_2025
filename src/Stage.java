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
  GameState state = GameState.RUNNING;
  List<Item> items = new ArrayList<Item>();
  int score = 0;

  public Stage() {
    grid = new Grid();
    actors = new ArrayList<Actor>();
    actors.add(new Cat(grid.cellAtColRow(0, 0).get(), grid));
    actors.add(new Dog(grid.cellAtColRow(10, 19).get(), grid));
    actors.add(new Bird(grid.cellAtColRow(12, 9).get(), grid));
    actors.add(new Fox(grid.cellAtColRow(5, 3).get(), grid));
    actors.add(new Turtle(grid.cellAtColRow(8, 12).get(), grid));
    actors.add(new Rabbit(grid.cellAtColRow(16, 8).get(), grid));
    for(int i=0; i<3; i++) {
      spawnRandomCoin();
    }
  }

  public void paint(Graphics g, Point mouseLoc) {
    grid.paint(g, mouseLoc);
    for(Item it : items) {
      it.paint(g);
    }
    for(Actor a: actors) {
      a.paint(g);
    }
    Optional<Cell> underMouse = grid.cellAtPoint(mouseLoc);
    if(underMouse.isPresent()) {
      Cell hoverCell = underMouse.get();
      g.setColor(Color.DARK_GRAY);
      g.drawString(String.valueOf(hoverCell.col) + String.valueOf(hoverCell.row), 740, 30);
    }
    g.setColor(Color.BLACK);
    if(state == GameState.WON) {
      g.drawString("You Win!", 740, 60);
    } else if(state == GameState.LOST) {
      g.drawString("You Lose!", 740, 60);
    }
    int y = 100;
    g.drawString("Actors:", 740, y);
    y += 20;
    for(Actor a : actors) {
      String name = a.getClass().getSimpleName();
      String locStr = String.valueOf(a.loc.col) + String.valueOf(a.loc.row);
      g.drawString(name + ": " + locStr, 740, y);
      y += 18;
    }
    y += 10;
    g.drawString("Score: " + score, 740, y);
  }

  public void movePlayer(Direction direction) {
    if(state != GameState.RUNNING) return;
    for(Actor a : actors) {
      if(a instanceof Dog) {
        a.move(direction);
        moveEnemiesRandomly();
        evaluateGameState();
        collectItemsAt(a.loc);
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
          if(checkCollisionWithDog()) {
            state = GameState.LOST;
            return;
          }
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

  private void evaluateGameState() {
    Optional<Cell> dogCell = Optional.empty();
    for(Actor a : actors) {
      if(a instanceof Dog) {
        dogCell = Optional.of(a.loc);
      }
    }
    if(dogCell.isPresent()) {
      if(dogCell.get().row == 0) {
        state = GameState.WON;
        return;
      }
      if(checkCollisionWithDog()) {
        state = GameState.LOST;
        return;
      }
    }
  }

  private boolean checkCollisionWithDog() {
    Cell dogCell = null;
    for(Actor a : actors) {
      if(a instanceof Dog) {
        dogCell = a.loc;
        break;
      }
    }
    if(dogCell == null) return false;
    for(Actor a : actors) {
      if(!(a instanceof Dog)) {
        if(a.loc == dogCell) {
          return true;
        }
      }
    }
    return false;
  }

  private void collectItemsAt(Cell cell) {
    List<Item> remaining = new ArrayList<Item>();
    int collected = 0;
    for(Item it : items) {
      if(it.getCell() == cell) {
        score += 10;
        collected++;
      } else {
        remaining.add(it);
      }
    }
    items = remaining;
    for(int i=0; i<collected; i++) {
      spawnRandomCoin();
    }
  }

  private void spawnRandomCoin() {
    for(int attempts=0; attempts<100; attempts++) {
      int col = (int)(Math.random() * 20);
      int row = (int)(Math.random() * 20);
      if(row == 0) continue;
      Optional<Cell> cellOpt = grid.cellAtColRow(col, row);
      if(!cellOpt.isPresent()) continue;
      Cell target = cellOpt.get();
      boolean occupiedByItem = false;
      for(Item it : items) {
        if(it.getCell() == target) { occupiedByItem = true; break; }
      }
      if(occupiedByItem) continue;
      boolean occupiedByActor = false;
      for(Actor a : actors) {
        if(a.loc == target) { occupiedByActor = true; break; }
      }
      if(occupiedByActor) continue;
      items.add(new Coin(target));
      return;
    }
  }
}
