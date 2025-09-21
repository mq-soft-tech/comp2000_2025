import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public abstract class Item {
    protected String name;
    protected Color color;
    protected int x, y;
    protected int size = 10;
    
    public Item(String name, Color color, int x, int y) {
        this.name = name;
        this.color = color;
        this.x = x;
        this.y = y;
    }
    
    public void paint(Graphics g) {
        g.setColor(new Color(0, 0, 0, 50));
        g.fillOval(x + 1, y + 1, size, size);
        g.setColor(color);
        g.fillOval(x, y, size, size);
        g.setColor(Color.BLACK);
        g.drawOval(x, y, size, size);
        drawDetails(g);
    }
    
    protected void drawDetails(Graphics g) {

    }
    
    public boolean contains(Point p) {
        if (p == null) return false;
        return p.x >= x && p.x <= x + size && p.y >= y && p.y <= y + size;
    }
    
    public String getName() {
        return name;
    }
}
