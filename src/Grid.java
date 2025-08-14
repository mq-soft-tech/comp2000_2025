import java.awt.Graphics;

public class Grid {

    public Grid()
    {
               

    }

    public void paint(Graphics g) 
    {
        g.setColor(java.awt.Color.BLACK);
        g.drawRect(10, 10, 700, 700);
        for (int x = 0; x < 20; x++)
        {
            for (int y = 0; y < 20; y++)
            {
                Cell c = new Cell(10 + x * 35, 10 + y * 35 );
                c.paint(g);
            }
        }
    }
}
