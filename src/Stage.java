import java.awt.Graphics;
import java.awt.Point;
import java.util.*;

public class Stage {
  Grid grid;
  Actor cat;
  Actor dog;
  Actor bird;
  Actor TRex;

  public Stage() {
    grid = new Grid();
    cat = new Cat(grid.cellAtColRow(5, 10));
    dog = new Dog(grid.cellAtColRow(19, 17));
    bird = new Bird(grid.cellAtColRow(15, 13));
    TRex = new TRex(grid.cellAtColRow(2, 7));
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
  } 

}
