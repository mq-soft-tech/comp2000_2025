import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * Abstract base class for all items in the ecosystem.
 * Demonstrates inheritance by providing common functionality for all items
 * while allowing specialized behavior for different item types.
 */
public abstract class Item {
    protected String name;
    protected Color color;
    protected int x, y;
    protected int size = 8;
    
    public Item(String name, Color color, int x, int y) {
        this.name = name;
        this.color = color;
        this.x = x;
        this.y = y;
    }
    
    /**
     * Paint the item on the graphics context
     */
    public abstract void paint(Graphics g);
    
    /**
     * Check if this item can be consumed by a specific actor type
     */
    public abstract boolean canBeConsumedBy(String actorType);
    
    /**
     * Get the nutritional value of this item
     */
    public abstract int getNutritionalValue();
    
    /**
     * Check if this item contains the given point
     */
    public boolean contains(Point p) {
        if (p == null) return false;
        return p.x >= x && p.x <= x + size && p.y >= y && p.y <= y + size;
    }
    
    public String getName() {
        return name;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
