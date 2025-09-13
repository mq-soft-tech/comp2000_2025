import java.awt.*;
import java.util.*;

public class Stage {
  Grid grid;
  Actor cat;
  Actor dog;
  Actor bird;
  Actor TRex;

  public Stage() {
    grid = new Grid();
    cat = new Cat(grid.cellAtColRow(5, 10).get());
    dog = new Dog(grid.cellAtColRow(19, 17).get());
    bird = new Bird(grid.cellAtColRow(15, 13).get());
    TRex = new TRex(grid.cellAtColRow(2, 7).get());
  }

  public void paint(Graphics g, Point mouseLoc) {
    grid.paint(g, mouseLoc);
    ArrayList<Actor> actors = new ArrayList<Actor>();
    actors.add(0, cat);
    actors.add(1, dog);
    actors.add(2, bird);
    actors.add(3, TRex);
  for (int i=0; i<actors.size(); i++){
    actors.get(i).paint(g);
  }
  Optional<Cell> underMouse = grid.cellAtPoint(mouseLoc);
    if(underMouse.isPresent()) {
      Cell hoverCell = underMouse.get();
      g.setColor(Color.DARK_GRAY);
      g.drawString(String.valueOf(hoverCell.col) + String.valueOf(hoverCell.row), 740, 30);
    }
  } 

}
