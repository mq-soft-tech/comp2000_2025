import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Grid {
    public void paint(Graphics g) {
  //grid code
  for(int i=0; i<=720; i+=35){
  g.drawLine(10, i+10, 710, i+10);
    g.drawLine(i+10, 10, i+10, 710);
    //
  }
      }
}
