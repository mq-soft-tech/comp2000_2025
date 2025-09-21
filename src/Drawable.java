import java.awt.Graphics;

/**
 * Interface for objects that can be drawn on the screen.
 * Demonstrates interface usage by defining a contract for drawable behavior.
 */
public interface Drawable {
    /**
     * Paint this object on the given graphics context
     */
    void paint(Graphics g);
}
