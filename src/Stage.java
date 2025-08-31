import java.awt.Graphics;
import java.awt.Point;
import java.util.*;

public class Stage {
  Grid grid;
  static Actor cat;
  static Actor dog;
  static Actor bird;
 

  public Stage() {
    grid = new Grid();
    cat = new Cat(grid.cellAtColRow(0, 0));
    dog = new Dog(grid.cellAtColRow(0, 15));
    bird = new Bird(grid.cellAtColRow(12, 9));
    
  }

  public void paint(Graphics g, Point mouseLoc) {
    grid.paint(g, mouseLoc);
    ArrayList<Actor> actors = new ArrayList<Actor>();
    actors.add(cat);
    actors.add(dog);
    actors.add(bird);
  for (int i=0; i<=actors.size(); i++){
    actors.get(i).paint(g);
  }
  } 

}
