import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Grid {
    public void CreateGrid(Graphics g, int x, int y, int width, int height){
      for(x = 10; x < width; x += 35){
        for(y = 10; y < height; y += 35){
          Cell drawCell = new Cell();
          drawCell.drawCell(g, x, y, 35, 35);
        }
      }

      }

} 
        
