import java.awt.Color;
import java.awt.Graphics;

public class Coin implements Item {
  private Cell cell;

  public Coin(Cell c) {
    cell = c;
  }

  public String getName() { return "Coin"; }
  public Cell getCell() { return cell; }

  public void paint(Graphics g) {
    g.setColor(new Color(250, 210, 70));
    g.fillOval(cell.x + 12, cell.y + 12, 12, 12);
    g.setColor(Color.GRAY);
    g.drawOval(cell.x + 12, cell.y + 12, 12, 12);
  }
}


