import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Optional;

public class Stage {
  Grid grid;
  Group<Actor> actors;

  public Stage() {
    grid = new Grid();
    actors = new Group<>();
    actors.add(new Cat(grid.cellAtColRow(0, 0).get()));
    actors.add(new Dog(grid.cellAtColRow(0, 15).get()));
    actors.add(new Bird(grid.cellAtColRow(12, 9).get()));
  }

  public void paint(Graphics g, Point mouseLoc) {
    grid.paint(g, mouseLoc);

    // use custom generic group
    actors.paintAll(g);

    Optional<Cell> underMouse = grid.cellAtPoint(mouseLoc);
    if (underMouse.isPresent()) {
      Cell hoverCell = underMouse.get();
      g.setColor(Color.DARK_GRAY);
      g.drawString(String.valueOf(hoverCell.col) + String.valueOf(hoverCell.row), 740, 30);

      if (hoverCell instanceof Terrain t) {
        g.drawString(hoverCell.getClass().getSimpleName() + " cost=" + t.moveCost(), 740, 50);
      } else {
        g.drawString("Cell", 740, 50);
      }
    }
  }
}
