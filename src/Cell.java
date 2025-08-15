import java.awt.Color;
import java.awt.Graphics;

public class Cell {
    int xAxis, yAxis;
    boolean mouseHovered = false;
    static int length = 35;

    //constructor
    public Cell(int x, int y) 
    {
        this.xAxis = x;
        this.yAxis = y;
    }
    //paint
    public void paint(Graphics g)
    {
        if (mouseHovered)
        {
            g.setColor(Color.GRAY);
            g.fillRect(xAxis, yAxis, length, length);
        }
        else {
            g.setColor(Color.YELLOW);
            g.fillRect(xAxis, yAxis, length, length);
            g.setColor(Color.BLACK);
            g.drawRect(xAxis,yAxis,length,length);            
        }
    }

    //constrains
    public boolean detectMousePosition (int mouseX, int mouseY)
    {
        mouseHovered = false;
        if ((mouseX <= xAxis + 35 && mouseX >= xAxis) && (mouseY <= yAxis + 35 && mouseY >= yAxis)) 
        {
            mouseHovered = true;
        }
        return mouseHovered;
    }

}
