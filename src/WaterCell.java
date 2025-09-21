import java.awt.*;

public class WaterCell extends Cell implements Swimmable {
    public WaterCell(char col, int row, int x, int y) { super(col, row, x, y); }

    public int swimCost() { return 1; }

    public void paint(Graphics g, Point mousePos) {
        
        g.setColor(new Color(90, 150, 220));
        g.fillRect(x, y, size, size);
       
        g.setColor(new Color(70, 130, 200));
        g.drawArc(x + 6, y + 8, size - 12, size - 18, 0, 180);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, size, size);
    }
}
