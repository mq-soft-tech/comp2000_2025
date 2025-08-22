import java.awt.Color;
import java.awt.Graphics;

public class Bird extends Actor {
  Cell loc;

  public Bird(Cell inLoc) {
    loc = inLoc;
  }

  public void paint(Graphics g) {
    g.setColor(Color.GREEN);
    g.fillRect(loc.x + 5, loc.y + 5, loc.width - 10, loc.height - 10);
    g.setColor(Color.GRAY);
    g.drawRect(loc.x + 5, loc.y + 5, loc.width - 10, loc.height - 10);
  }
}
