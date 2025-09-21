import java.awt.Color;
import java.awt.Graphics;

/**
 * Water cell type - difficult to traverse, doesn't support land life, high movement cost.
 * Demonstrates inheritance by extending CellType with water-specific behavior.
 */
public class WaterCell extends CellType {
    
    public WaterCell() {
        super(new Color(0, 100, 200), new Color(0, 150, 255), "Water");
    }
    
    @Override
    public void paint(Graphics g, int x, int y, int size, boolean isHighlighted) {
        Color color = isHighlighted ? highlightColor : baseColor;
        g.setColor(color);
        g.fillRect(x, y, size, size);
        
        // Draw water ripples
        g.setColor(new Color(100, 150, 255));
        g.drawOval(x + 5, y + 5, size - 10, size - 10);
        g.drawOval(x + 8, y + 8, size - 16, size - 16);
        
        g.setColor(Color.BLACK);
        g.drawRect(x, y, size, size);
    }
    
    @Override
    public int getMovementCost() {
        return 3; // Difficult to move through (swimming)
    }
    
    @Override
    public boolean canSupportLife() {
        return false; // Water doesn't support land-based plant life
    }
}
