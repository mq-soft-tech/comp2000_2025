import java.awt.Color;
import java.awt.Graphics;

/**
 * Rock cell type - very difficult to traverse, no life support, highest movement cost.
 * Demonstrates inheritance by extending CellType with rock-specific behavior.
 */
public class RockCell extends CellType {
    
    public RockCell() {
        super(new Color(105, 105, 105), new Color(169, 169, 169), "Rock");
    }
    
    @Override
    public void paint(Graphics g, int x, int y, int size, boolean isHighlighted) {
        Color color = isHighlighted ? highlightColor : baseColor;
        g.setColor(color);
        g.fillRect(x, y, size, size);
        
        // Draw rock texture
        g.setColor(new Color(80, 80, 80));
        g.fillOval(x + 5, y + 5, size - 10, size - 10);
        g.setColor(new Color(120, 120, 120));
        g.fillOval(x + 8, y + 8, size - 16, size - 16);
        
        g.setColor(Color.BLACK);
        g.drawRect(x, y, size, size);
    }
    
    @Override
    public int getMovementCost() {
        return 4; // Very difficult to move through
    }
    
    @Override
    public boolean canSupportLife() {
        return false; // Rock doesn't support plant life
    }
}
