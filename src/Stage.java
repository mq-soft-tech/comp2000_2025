import java.awt.Graphics;
import java.awt.Point;
import java.util.*;

public class Stage {
  Grid grid;
  // Actor cat;
  // Actor dog;
  // Actor bird;
  List <Actor> list = new ArrayList <>();

  public Stage() {
    grid = new Grid();

    list.add(new Cat(grid.cellAtColRow(0, 0)));
    list.add(new Dog(grid.cellAtColRow(0, 15)));
    list.add(new Bird(grid.cellAtColRow(12, 9)));
    
  }

  public void paint(Graphics g, Point mouseLoc) {
    grid.paint(g, mouseLoc);

    for (Actor list : list){
     //list.draw(g);
     list.paint(g);
    }
  }
}
