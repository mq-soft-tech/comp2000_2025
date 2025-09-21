import java.awt.Color;
import java.awt.Graphics;

public class Fish extends FoodItem {
    
    public Fish(int x, int y) {
        super("Fish", new Color(255, 180, 50), x, y, "Cat");
    }
    
    @Override
    protected void drawDetails(Graphics g) {
        g.setColor(new Color(255, 200, 100));
        int[] tailX = {x + size, x + size + 2, x + size};
        int[] tailY = {y + 2, y + size/2, y + size - 2};
        g.fillPolygon(tailX, tailY, 3);
        g.setColor(Color.BLACK);
        g.fillOval(x + 2, y + 2, 2, 2);
        g.setColor(new Color(255, 150, 0));
        g.drawLine(x + 3, y + 4, x + 3, y + size - 4);
        g.drawLine(x + 5, y + 3, x + 5, y + size - 3);
    }
}
