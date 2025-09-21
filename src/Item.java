import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * Simple base class for items.
 * Demonstrates basic inheritance.
 */
public abstract class Item {
    protected String name;
    protected Color color;
    protected int x, y;
    protected int size = 10;
    
    public Item(String name, Color color, int x, int y) {
        this.name = name;
        this.color = color;
        this.x = x;
        this.y = y;
    }
    
    public void paint(Graphics g) {
        // Draw shadow
        g.setColor(new Color(0, 0, 0, 50));
        g.fillOval(x + 1, y + 1, size, size);
        
        // Draw main item
        g.setColor(color);
        g.fillOval(x, y, size, size);
        
        // Draw border
        g.setColor(Color.BLACK);
        g.drawOval(x, y, size, size);
        
        // Draw item details (overridden by subclasses)
        drawDetails(g);
    }
    
    protected void drawDetails(Graphics g) {
        // Default: no details
    }
    
    public boolean contains(Point p) {
        if (p == null) return false;
        return p.x >= x && p.x <= x + size && p.y >= y && p.y <= y + size;
    }
    
    public String getName() {
        return name;
    }
}
