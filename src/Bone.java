import java.awt.Color;
import java.awt.Graphics;

/**
 * Bone - can be eaten by dogs.
 * Demonstrates basic inheritance.
 */
public class Bone extends FoodItem {
    
    public Bone(int x, int y) {
        super("Bone", new Color(250, 240, 200), x, y, "Dog");
    }
    
    @Override
    protected void drawDetails(Graphics g) {
        // Draw bone shape
        g.setColor(new Color(220, 220, 200));
        g.fillRoundRect(x + 2, y + 3, size - 4, size - 6, 2, 2);
        
        // Draw bone ends
        g.setColor(new Color(200, 200, 180));
        g.fillOval(x + 1, y + 2, 3, 3);
        g.fillOval(x + size - 4, y + 2, 3, 3);
        g.fillOval(x + 1, y + size - 5, 3, 3);
        g.fillOval(x + size - 4, y + size - 5, 3, 3);
    }
}
