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
      Stage stage = new Stage();
      public Canvas() {
        setPreferredSize(new Dimension(720, 720));
      }

      public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGrid(g);
      }

      public void drawGrid(Graphics g) {
        g.setColor(java.awt.Color.LIGHT_GRAY);
        for (int i = 0; i < 720; i += 20) {
          g.drawLine(i, 0, i, 720);
          g.drawLine(0, i, 720, i);
        }
      }

      @Override
      public void paint(Graphics g) {
	g.setColor(java.awt.Color.BLACK);
	g.drawRect(10, 10, 700, 700);
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
