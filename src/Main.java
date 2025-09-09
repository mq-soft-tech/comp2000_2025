import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
        setPreferredSize(new Dimension(1024, 720));
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(new KeyAdapter() {
          @Override
          public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()) {
              case KeyEvent.VK_UP:
                stage.movePlayer(Direction.UP);
                break;
              case KeyEvent.VK_DOWN:
                stage.movePlayer(Direction.DOWN);
                break;
              case KeyEvent.VK_LEFT:
                stage.movePlayer(Direction.LEFT);
                break;
              case KeyEvent.VK_RIGHT:
                stage.movePlayer(Direction.RIGHT);
                break;
            }
          }
        });
      }

      @Override
      public void paint(Graphics g) {
        stage.paint(g, getMousePosition());
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
