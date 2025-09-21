import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class GrassCell extends Cell implements Terrain {
  public GrassCell(char inCol, int inRow, int x, int y) {
    super(inCol, inRow, x, y);
  }

  @Override public int moveCost() { return 1; }

  @Override
  public void paint(Graphics g, Point mousePos) {
    if (contains(mousePos)) g.setColor(Color.GRAY);
    else g.setColor(new Color(144, 238, 144)); // light green
    g.fillRect(x, y, size, size);
    g.setColor(Color.BLACK);
    g.drawRect(x, y, size, size);
  }
}
