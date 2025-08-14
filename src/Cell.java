import java.awt.Color;
import java.awt.Graphics;

public class Cell {
    int xAxis, yAxis;
    static int length = 35;

    //constructor
    public Cell(int xAxis, int yAxis) 
    {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }
    //paint
    public void paint(Graphics g)
    {
        g.setColor(Color.RED);
        g.fillRect(xAxis, yAxis, length, length);
        g.setColor(Color.BLACK);
        g.drawRect(xAxis,yAxis,length,length);
    }

    //constrains
}
