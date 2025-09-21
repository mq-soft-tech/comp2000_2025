import java.awt.Color;
import java.awt.Graphics;

/**
 * Simple base class for different cell types.
 * Demonstrates basic inheritance.
 */
public abstract class CellType {
    protected Color color;
    protected String name;
    
    public CellType(Color color, String name) {
        this.color = color;
        this.name = name;
    }
    
    public void paint(Graphics g, int x, int y, int size, boolean isHighlighted) {
        // Draw cell background
        if (isHighlighted) {
            g.setColor(new Color(200, 200, 200));
        } else {
            g.setColor(color);
        }
        g.fillRect(x, y, size, size);
        
        // Draw cell border
        g.setColor(Color.BLACK);
        g.drawRect(x, y, size, size);
        
        // Draw cell pattern (overridden by subclasses)
        drawPattern(g, x, y, size);
    }
    
    protected void drawPattern(Graphics g, int x, int y, int size) {
        // Default: no pattern
    }
    
    public String getName() {
        return name;
    }
}
