import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.List;

/**
 * Abstract base class for all actors in the ecosystem.
 * Implements Movable and Feeder interfaces to demonstrate interface usage.
 */
public abstract class Actor implements Movable, Feeder {
  Color color;
  Cell loc;
  List<Polygon> display;
  protected int hungerLevel;
  protected int maxHunger;
  protected String actorType;

  public Actor(Cell location, String actorType, int maxHunger) {
    this.loc = location;
    this.actorType = actorType;
    this.maxHunger = maxHunger;
    this.hungerLevel = maxHunger;
  }

  public void paint(Graphics g) {
    for(Polygon p: display) {
      g.setColor(color);
      g.fillPolygon(p);
      g.setColor(Color.GRAY);
      g.drawPolygon(p);
    }
    
    // Draw hunger indicator
    if (isHungry()) {
      g.setColor(Color.RED);
      g.fillOval(loc.x + 25, loc.y + 5, 6, 6);
    }
  }
  
  @Override
  public void moveTo(Point newLocation) {
    // This would be implemented by subclasses based on their movement patterns
    // For now, we'll just update the location
    if (loc != null) {
      loc.x = newLocation.x;
      loc.y = newLocation.y;
    }
  }
  
  @Override
  public Point getCurrentLocation() {
    return loc != null ? new Point(loc.x, loc.y) : null;
  }
  
  @Override
  public boolean canMoveTo(Point location) {
    // Basic implementation - can be overridden by subclasses
    return true;
  }
  
  @Override
  public boolean consumeItem(Consumable item) {
    if (item.canBeConsumedBy(actorType)) {
      hungerLevel = Math.min(maxHunger, hungerLevel + item.consume());
      return true;
    }
    return false;
  }
  
  @Override
  public int getHungerLevel() {
    return hungerLevel;
  }
  
  @Override
  public int getMaxHunger() {
    return maxHunger;
  }
  
  @Override
  public boolean isHungry() {
    return hungerLevel < maxHunger * 0.7; // Hungry when below 70%
  }
  
  public String getActorType() {
    return actorType;
  }
  
  public Cell getLocation() {
    return loc;
  }
}
