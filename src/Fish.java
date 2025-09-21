import java.awt.Color;
import java.awt.Graphics;

/**
 * Fish - can be eaten by cats.
 * Demonstrates basic inheritance.
 */
public class Fish extends FoodItem {
    
    public Fish(int x, int y) {
        super("Fish", new Color(255, 180, 50), x, y, "Cat");
    }
    
    @Override
    protected void drawDetails(Graphics g) {
        // Draw fish tail
        g.setColor(new Color(255, 200, 100));
        int[] tailX = {x + size, x + size + 2, x + size};
        int[] tailY = {y + 2, y + size/2, y + size - 2};
        g.fillPolygon(tailX, tailY, 3);
        
        // Draw fish eye
        g.setColor(Color.BLACK);
        g.fillOval(x + 2, y + 2, 2, 2);
        
        // Draw fish stripes
        g.setColor(new Color(255, 150, 0));
        g.drawLine(x + 3, y + 4, x + 3, y + size - 4);
        g.drawLine(x + 5, y + 3, x + 5, y + size - 3);
    }
}
