import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Cell {

    public Point getMousePosition(int x, int y, int width, int height) {
        Point mousePosition = java.awt.MouseInfo.getPointerInfo().getLocation();
        if (mousePosition.x >= x && mousePosition.x <= x + width  &&
                mousePosition.y >= y && mousePosition.y <= y + height) {
            return mousePosition;
        }
        return null;
    }

    public void drawCell(Graphics g, int x, int y, int width, int height) {
        g.drawRect(x, y, width, height);
        if (getMousePosition(x, y, width, height) != null) {
            g.fillRect(x, y, width, height);
        }
    }

}
