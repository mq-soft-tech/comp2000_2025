import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main extends JFrame {
    public static void main(String[] args) throws Exception {
      Main window = new Main();
      window.run(); 
    }

    Grid grid = new Grid();
    class Canvas extends JPanel {
      public Canvas() {
        setPreferredSize(new Dimension(720, 720));
        addMouseMotionListener(new MouseAdapter() {

          @Override
          public void mouseMoved(MouseEvent e) 
          {
            Point mouseLocation = e.getPoint();
            grid.mouseX = mouseLocation.x;
            grid.mouseY = mouseLocation.y;
            grid.highlighted();
          }
        }); 
      }

      @Override
      public void paint(Graphics g) 
      {
        super.paint(g);
       /*/ for (int x = 1; x < 20; x++)
        {
          g.drawLine(10, 10 + x * 35, 710, 10 + x * 35);
        }
        for (int y = 1; y < 20; y++)
        {
          g.drawLine(10 + y * 35, 10, 10 + y * 35, 710);
        }
      }*/
        grid.paint(g);
      }
    }
    private Main() {
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Canvas canvas = new Canvas();
      this.setContentPane(canvas);
      this.pack();
      setLocationRelativeTo(null);
      this.setVisible(true);
    }

    public void run() {
      while(true) {
        repaint();
      }
    }

}
