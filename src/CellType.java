import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * Abstract base class for different types of cells in the ecosystem.
 * Demonstrates inheritance by providing common functionality while allowing
 * specialized behavior for different terrain types.
 */
public abstract class CellType {
    protected Color baseColor;
    protected Color highlightColor;
    protected String typeName;
    
    public CellType(Color baseColor, Color highlightColor, String typeName) {
        this.baseColor = baseColor;
        this.highlightColor = highlightColor;
        this.typeName = typeName;
    }
    
    /**
     * Paint the cell with its specific appearance
     */
    public abstract void paint(Graphics g, int x, int y, int size, boolean isHighlighted);
    
    /**
     * Get the movement cost for actors moving through this cell type
     */
    public abstract int getMovementCost();
    
    /**
     * Check if this cell type can support plant life (for food generation)
     */
    public abstract boolean canSupportLife();
    
    /**
     * Get the type name for display purposes
     */
    public String getTypeName() {
        return typeName;
    }
    
    /**
     * Get the base color of this cell type
     */
    public Color getBaseColor() {
        return baseColor;
    }
}
