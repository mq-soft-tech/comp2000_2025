import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class Main extends JFrame {
    public static void main(String[] args)  {
     Main window = new Main();
     window.run();
    }

    class Canvas extends JPanel {
      Stage stage = new Stage();
      public Canvas() {
        setPreferredSize(new Dimension(1024, 720));
     
        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("UP"), "mvUp");
        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("DOWN"), "mvDown");
        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"), "mvLeft");
        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"), "mvRight");

        getActionMap().put("mvUp",    new AbstractAction(){ public void actionPerformed(ActionEvent e){ stage.moveWarrior(0, -1); repaint(); }});
        getActionMap().put("mvDown",  new AbstractAction(){ public void actionPerformed(ActionEvent e){ stage.moveWarrior(0,  1); repaint(); }});
        getActionMap().put("mvLeft",  new AbstractAction(){ public void actionPerformed(ActionEvent e){ stage.moveWarrior(-1, 0); repaint(); }});
        getActionMap().put("mvRight", new AbstractAction(){ public void actionPerformed(ActionEvent e){ stage.moveWarrior( 1, 0); repaint(); }});
      
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
