import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.List;
public abstract class Actor {
  Color color;
  Cell loc;
  List<Polygon> display;
  protected String actorType;

  public Actor(Cell location, String actorType) {
    this.loc = location;
    this.actorType = actorType;
  }

  public void paint(Graphics g) {
    for(Polygon p: display) {
      g.setColor(new Color(0, 0, 0, 30));
      g.translate(2, 2);
      g.fillPolygon(p);
      g.translate(-2, -2);
    }
    for(Polygon p: display) {
      g.setColor(color);
      g.fillPolygon(p);
      g.setColor(Color.BLACK);
      g.drawPolygon(p);
    }
    drawDetails(g);
  }
  
  protected void drawDetails(Graphics g) {

  }
  
  public String getActorType() {
    return actorType;
  }
  
  public Cell getLocation() {
    return loc;
  }
}
