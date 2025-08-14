import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {
    Grid grid;
    public static void main(String[] args) throws Exception {
      Main window = new Main();
      window.run();
      
    }

    class Canvas extends JPanel {
      public Canvas() {
        setPreferredSize(new Dimension(720, 720));
        
      }
    }
    
    @Override
    public void paint(Graphics g) {
      g.setColor(java.awt.Color.BLACK);
      g.drawRect(10, 20, 700, 700);
      //g.setColor(java.awt.Color.WHITE);
      //g.fillRect(10, 10, 700, 700);
      grid.paint(g); 

    }
    
 

    private Main() {
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Canvas canvas = new Canvas();
      this.setContentPane(canvas);
      this.pack();

      grid = new Grid(20, 20, 10, 10); //PROBLEM
      this.setVisible(true);
    }

    public void run() {
      while(true) {
        repaint();
      }
    }
}
