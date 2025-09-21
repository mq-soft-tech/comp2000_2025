import java.awt.Color;
import java.awt.Graphics;

/**
 * Sand cell type - moderate traversal, limited life support, medium movement cost.
 * Demonstrates inheritance by extending CellType with sand-specific behavior.
 */
public class SandCell extends CellType {
    
    public SandCell() {
        super(new Color(238, 203, 173), new Color(255, 228, 196), "Sand");
    }
    
    @Override
    public void paint(Graphics g, int x, int y, int size, boolean isHighlighted) {
        Color color = isHighlighted ? highlightColor : baseColor;
        g.setColor(color);
        g.fillRect(x, y, size, size);
        
        // Draw sand texture
        g.setColor(new Color(160, 120, 80));
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                g.fillOval(x + 3 + i * 7, y + 3 + j * 7, 2, 2);
            }
        }
        
        g.setColor(Color.BLACK);
        g.drawRect(x, y, size, size);
    }
    
    @Override
    public int getMovementCost() {
        return 2; // Moderate difficulty to move through
    }
    
    @Override
    public boolean canSupportLife() {
        return true; // Sand can support some plant life
    }
}
