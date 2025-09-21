import java.awt.Color;
import java.awt.Graphics;

/**
 * Seed - can be eaten by birds.
 * Demonstrates basic inheritance.
 */
public class Seed extends FoodItem {
    
    public Seed(int x, int y) {
        super("Seed", new Color(160, 100, 60), x, y, "Bird");
    }
    
    @Override
    protected void drawDetails(Graphics g) {
        // Draw seed texture
        g.setColor(new Color(120, 80, 40));
        g.drawLine(x + 2, y + 2, x + size - 2, y + size - 2);
        g.drawLine(x + size - 2, y + 2, x + 2, y + size - 2);
        
        // Draw seed highlight
        g.setColor(new Color(200, 150, 100));
        g.fillOval(x + 3, y + 3, 2, 2);
    }
}
