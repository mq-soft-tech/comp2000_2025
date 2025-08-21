import java.awt.Graphics;
import java.util.ArrayList;


public class Grid {

    int mouseX, mouseY;
    ArrayList<Cell> cells = new ArrayList<Cell>();

    //setup 20 x 20 grid
    public Grid()
    {
        for (int x = 0; x < 20; x++)
        {
            for (int y = 0; y < 20; y++)
            {
                cells.add(new Cell(10 + x * 35, 10 + y * 35 )); //store all the cells inside the grid into a list
            }
        }
    }

    public void paint(Graphics g) 
    {
        //access the list and display each cells within the list
        g.setColor(java.awt.Color.BLACK);
        g.drawRect(10, 10, 700, 700);
        for (int i = 0; i < cells.size(); i++)
        {
            cells.get(i).paint(g);;
        }
    }

    //access the list and detect the mouse position within each cell.
    public void highlighted()
    {
        for (int i = 0; i < cells.size(); i++)
        {
            cells.get(i).detectMousePosition(mouseX, mouseY);
        }
    }
}
