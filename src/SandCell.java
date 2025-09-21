import java.awt.Color;
import java.awt.Graphics;

/**
 * Sand cell - beige cell with sand dots.
 * Demonstrates basic inheritance.
 */
public class SandCell extends CellType {
    
    public SandCell() {
        super(new Color(240, 210, 180), "Sand");
    }
    
    @Override
    protected void drawPattern(Graphics g, int x, int y, int size) {
        // Draw sand grains
        g.setColor(new Color(200, 170, 140));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int dotX = x + 8 + i * 6;
                int dotY = y + 8 + j * 6;
                g.fillOval(dotX, dotY, 2, 2);
            }
        }
    }
}
