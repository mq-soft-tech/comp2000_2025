import java.awt.*;

public class SandCell extends Cell implements Walkable {
    public SandCell(char col, int row, int x, int y) { super(col, row, x, y); }

    public int moveCost() { return 2; }

    public void paint(Graphics g, Point mousePos) {
        
        g.setColor(new Color(230, 210, 140));
        g.fillRect(x, y, size, size);
        g.setColor(new Color(210, 190, 120));
        g.drawLine(x, y + size - 1, x + size - 1, y + size - 1); // tiny shadow line
        g.setColor(Color.BLACK);
        g.drawRect(x, y, size, size);
    }
}
