
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;

public abstract class Actor {
  Color color;
  Cell loc;
  ArrayList<Polygon> display = new ArrayList<Polygon>();

  public void paint(Graphics g) {
   for(Polygon p: display) {
      g.setColor(color);
      g.fillPolygon(p);
      g.setColor(Color.GRAY);
      g.drawPolygon(p);
    }
  }
}
