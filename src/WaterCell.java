import java.awt.Color;
import java.awt.Graphics;

/**
 * Water cell - blue cell with wave pattern.
 * Demonstrates basic inheritance.
 */
public class WaterCell extends CellType {
    
    public WaterCell() {
        super(new Color(70, 130, 200), "Water");
    }
    
    @Override
    protected void drawPattern(Graphics g, int x, int y, int size) {
        // Draw water waves
        g.setColor(new Color(100, 150, 255));
        g.drawArc(x + 2, y + 2, size - 4, size - 4, 0, 180);
        g.drawArc(x + 5, y + 5, size - 10, size - 10, 0, 180);
    }
}
