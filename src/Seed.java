import java.awt.Color;
import java.awt.Graphics;

/**
 * Seed item - can be consumed by birds.
 * Demonstrates inheritance by extending FoodItem with seed-specific behavior.
 */
public class Seed extends FoodItem {
    
    public Seed(int x, int y) {
        super("Seed", new Color(139, 69, 19), x, y, 4, new String[]{"Bird"});
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, size, size);
        g.setColor(Color.BLACK);
        g.drawOval(x, y, size, size);
        
        // Draw seed texture
        g.setColor(new Color(101, 67, 33));
        g.drawLine(x + 2, y + 2, x + size - 2, y + size - 2);
        g.drawLine(x + size - 2, y + 2, x + 2, y + size - 2);
    }
}
