import java.awt.Color;
import java.awt.Graphics;

/**
 * Grass cell - green cell with grass pattern.
 * Demonstrates basic inheritance.
 */
public class GrassCell extends CellType {
    
    public GrassCell() {
        super(new Color(50, 150, 50), "Grass");
    }
    
    @Override
    protected void drawPattern(Graphics g, int x, int y, int size) {
        // Draw grass blades
        g.setColor(new Color(30, 120, 30));
        for (int i = 0; i < 4; i++) {
            int bladeX = x + 5 + i * 7;
            g.drawLine(bladeX, y + size - 3, bladeX, y + size - 8);
            g.drawLine(bladeX + 1, y + size - 3, bladeX + 1, y + size - 6);
        }
    }
}
