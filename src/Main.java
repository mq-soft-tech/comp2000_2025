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
      public Canvas() {
        setPreferredSize(new Dimension(720, 720));
      }

      @Override
      public void paint(Graphics g) {
	    g.setColor(java.awt.Color.BLACK);
	    g.drawRect(10, 10, 700, 700);
      for (int x = 1; x < 20; x++)
      {
        g.drawLine(10, 10 + x * 35, 710, 10 + x * 35);
      }
      for (int y = 1; y < 20; y++)
      {
        g.drawLine(10 + y * 35, 10, 10 + y * 35, 710);
      }
    }
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
