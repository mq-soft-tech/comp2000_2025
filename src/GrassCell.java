import java.awt.Color;
import java.awt.Graphics;

/**
 * Grass cell type - easy to traverse, supports life, low movement cost.
 * Demonstrates inheritance by extending CellType with grass-specific behavior.
 */
public class GrassCell extends CellType {
    
    public GrassCell() {
        super(new Color(34, 139, 34), new Color(50, 205, 50), "Grass");
    }
    
    @Override
    public void paint(Graphics g, int x, int y, int size, boolean isHighlighted) {
        Color color = isHighlighted ? highlightColor : baseColor;
        g.setColor(color);
        g.fillRect(x, y, size, size);
        
        // Draw grass texture
        g.setColor(new Color(0, 100, 0));
        for (int i = 0; i < 3; i++) {
            g.drawLine(x + 5 + i * 8, y + size - 5, x + 5 + i * 8, y + size - 2);
        }
        
        g.setColor(Color.BLACK);
        g.drawRect(x, y, size, size);
    }
    
    @Override
    public int getMovementCost() {
        return 1; // Easy to move through
    }
    
    @Override
    public boolean canSupportLife() {
        return true; // Grass supports plant life
    }
}
