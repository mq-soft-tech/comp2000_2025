import java.awt.Color;
import java.awt.Graphics;
public abstract class CellType {
    protected Color color;
    protected String name;
    
    public CellType(Color color, String name) {
        this.color = color;
        this.name = name;
    }
    
    public void paint(Graphics g, int x, int y, int size, boolean isHighlighted) {
        if (isHighlighted) {
            g.setColor(new Color(200, 200, 200));
        } else {
            g.setColor(color);
        }
        g.fillRect(x, y, size, size);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, size, size);
        drawPattern(g, x, y, size);
    }
    
    protected void drawPattern(Graphics g, int x, int y, int size) {

    }
    
    public String getName() {
        return name;
    }
}
