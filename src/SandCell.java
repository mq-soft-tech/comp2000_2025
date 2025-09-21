import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class SandCell extends Cell implements Terrain {
  public SandCell(char inCol, int inRow, int x, int y) {
    super(inCol, inRow, x, y);
  }

  @Override public int moveCost() { return 2; }

  @Override
  public void paint(Graphics g, Point mousePos) {
    if (contains(mousePos)) g.setColor(Color.GRAY);
    else g.setColor(new Color(237, 201, 175)); // sand-ish
    g.fillRect(x, y, size, size);
    g.setColor(Color.BLACK);
    g.drawRect(x, y, size, size);
  }
}
