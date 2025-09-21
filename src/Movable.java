import java.awt.Point;

/**
 * Interface for objects that can move around the grid.
 * Demonstrates interface usage by defining movement behavior.
 */
public interface Movable {
    /**
     * Move to a new location
     */
    void moveTo(Point newLocation);
    
    /**
     * Get the current location
     */
    Point getCurrentLocation();
    
    /**
     * Check if this object can move to the specified location
     */
    boolean canMoveTo(Point location);
}
