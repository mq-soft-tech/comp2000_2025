import java.awt.Color;
import java.awt.Graphics;

/**
 * Rock cell - gray cell with rock texture.
 * Demonstrates basic inheritance.
 */
public class RockCell extends CellType {
    
    public RockCell() {
        super(new Color(120, 120, 120), "Rock");
    }
    
    @Override
    protected void drawPattern(Graphics g, int x, int y, int size) {
        // Draw rock cracks
        g.setColor(new Color(80, 80, 80));
        g.drawLine(x + 5, y + 5, x + size - 5, y + size - 5);
        g.drawLine(x + size - 5, y + 5, x + 5, y + size - 5);
        
        // Draw rock highlights
        g.setColor(new Color(160, 160, 160));
        g.drawLine(x + 3, y + 3, x + 8, y + 8);
        g.drawLine(x + size - 8, y + 3, x + size - 3, y + 8);
    }
}
