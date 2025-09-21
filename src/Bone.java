import java.awt.Color;
import java.awt.Graphics;

/**
 * Bone item - can be consumed by dogs.
 * Demonstrates inheritance by extending FoodItem with bone-specific behavior.
 */
public class Bone extends FoodItem {
    
    public Bone(int x, int y) {
        super("Bone", new Color(245, 245, 220), x, y, 8, new String[]{"Dog"});
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRoundRect(x, y, size, size/2, 2, 2);
        g.setColor(Color.BLACK);
        g.drawRoundRect(x, y, size, size/2, 2, 2);
        
        // Draw bone details
        g.setColor(new Color(200, 200, 200));
        g.fillOval(x + 1, y + 1, 2, 2);
        g.fillOval(x + 5, y + 1, 2, 2);
    }
}
