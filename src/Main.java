import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Main extends JFrame {
    public static void main(String[] args) throws Exception {
      SwingUtilities.invokeLater(new Runnable() { // Code runs on Swing thread
        public void run() {
          new Main().run();
        }
      });
    }

    Canvas canvas;
    Timer timer;

    class Canvas extends JPanel {
      Stage stage = new Stage();
      Point mousePos = null; // Track mouse position

      public Canvas() {
        setPreferredSize(new Dimension(1024, 720));
        setBackground(java.awt.Color.WHITE);
        setDoubleBuffered(true); // Reduces flickering

        addMouseMotionListener(new MouseMotionAdapter() {
          @Override
          public void mouseMoved(MouseEvent e){
            mousePos = e.getPoint();
            repaint(); // Request to repaint when the mouse moves
          }
          
          @Override
          public void mouseDragged(MouseEvent e) {
            mousePos = e.getPoint();
            repaint(); // Request to repaint when the mouse drags
          }
        });

        addMouseListener(new MouseAdapter() {
          @Override
          public void mouseExited(MouseEvent e){
            mousePos = null;
            repaint(); // Request to repaint when the mouse exits
          }
        });
      }

      @Override
      public void paintComponent(Graphics g) {
        super.paintComponent(g); // Clears the background correctly
        stage.paint(g, mousePos); // Forward mouse position to stage
      }
    }

    private Main() {
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Canvas canvas = new Canvas();
      this.setContentPane(canvas);
      this.pack();
      this.setLocationRelativeTo(null);
      this.setVisible(true);

      timer = new Timer(33, e -> canvas.repaint()); // Swing Timer to repaint at 30fps
      timer.start();

    }
    private void run() { // 
    }
}
