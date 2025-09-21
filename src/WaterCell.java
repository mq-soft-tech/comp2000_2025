import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class WaterCell extends Cell implements Terrain {
  public WaterCell(char inCol, int inRow, int x, int y) {
    super(inCol, inRow, x, y);
  }

  @Override public int moveCost() { return 3; }

  @Override
  public void paint(Graphics g, Point mousePos) {
    if (contains(mousePos)) g.setColor(Color.GRAY);
    else g.setColor(new Color(135, 206, 235)); // light blue
    g.fillRect(x, y, size, size);
    g.setColor(Color.BLACK);
    g.drawRect(x, y, size, size);
  }
}
