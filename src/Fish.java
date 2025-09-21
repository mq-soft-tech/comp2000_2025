import java.awt.Color;
import java.awt.Graphics;

/**
 * Fish item - can be consumed by cats.
 * Demonstrates inheritance by extending FoodItem with fish-specific behavior.
 */
public class Fish extends FoodItem {
    
    public Fish(int x, int y) {
        super("Fish", new Color(255, 165, 0), x, y, 6, new String[]{"Cat"});
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, size, size/2);
        g.setColor(Color.BLACK);
        g.drawOval(x, y, size, size/2);
        
        // Draw fish tail
        g.setColor(color);
        int[] xPoints = {x + size, x + size + 3, x + size};
        int[] yPoints = {y + size/4, y + size/2, y + 3*size/4};
        g.fillPolygon(xPoints, yPoints, 3);
        
        // Draw fish eye
        g.setColor(Color.BLACK);
        g.fillOval(x + 2, y + 1, 2, 2);
    }
}
