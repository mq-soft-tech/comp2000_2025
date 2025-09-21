import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Cell extends Rectangle implements Passable {
  static int size = 35;
  char col;
  int row;
  protected Color color =  Color.LIGHT_GRAY;

  public Cell(char inCol, int inRow, int x, int y){
    super(x, y, size, size);
    col = inCol;
    row = inRow;
  }

  public void paint(Graphics g, Point mousePos) {
    g.setColor(color);
    g.fillRect(x, y, size, size);

    if(contains(mousePos)){
      g.setColor(Color.WHITE);
    }else {
      g.setColor(Color.BLACK);
    }
    g.drawRect(x, y, size -1, size-1);
    g.setColor(Color.BLACK);
    g.drawRect(x +1 , y +1, size -2, size -2);
  
  }

@Override
  public boolean contains(Point p){
    if(p != null){
      return super.contains(p);
    }else{
      return false;
    }
  }
}
