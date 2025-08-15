import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {
    public static void main(String[] args) throws Exception {
      Main window = new Main();
      window.run();
    }

    class Canvas extends JPanel {
      final static int CELL_LEN = 35;
      final static int NUM_ROWS = 20;
      final static int NUM_COLS = 20;
      final static int OFFSET = 10;

      public Canvas() {
        setPreferredSize(new Dimension(720, 720));
      }

      @Override
      public void paint(Graphics g) {
        for (int row = 0; row < NUM_ROWS; row++) {
          for (int col = 0; col < NUM_COLS; col++) {
            int x = col * CELL_LEN + OFFSET;
            int y = row * CELL_LEN + OFFSET;
            g.setColor(java.awt.Color.BLACK);
            g.drawRect(x, y, CELL_LEN, CELL_LEN);
            g.setColor(java.awt.Color.WHITE);
            g.fillRect(x, y, CELL_LEN, CELL_LEN);
          }
        }
	g.setColor(java.awt.Color.BLACK);
	g.drawRect(10, 10, 700, 700);
      }
    }

  class Grid extends JPanel{

  }

  class Cell extends JPanel{
    
  }

    private Main() {
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Canvas canvas = new Canvas();
      this.setContentPane(canvas);
      this.pack();
      this.setVisible(true);
    }

    public void run() {
      while(true) {
        repaint();
      }
    }
}
