import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Cell extends java.awt.Rectangle implements Passable {
  static int size = 35;
  char col;
  int row;

  public boolean isWater(){
    return false;
  }

  public boolean isLava(){
    return false;
  }

  public boolean isFloor(){
    return false;
  }

 

  public Cell(char inCol, int inRow, int x, int y) {
    super(x, y, size, size);
    col = inCol;
    row = inRow;
  }

  public void paint(Graphics g, Point mousePos) {
    if(contains(mousePos)) {
      g.setColor(Color.BLACK);
    } else {
      g.setColor(Color.WHITE);
    }
    g.fillRect(x, y, size, size);
    g.setColor(Color.BLACK);
    g.drawRect(x, y, size, size);
  }

  public boolean contains(Point p) {
    if(p != null) {
      return super.contains(p);
    } else {
      return false;
    }
  }
}
