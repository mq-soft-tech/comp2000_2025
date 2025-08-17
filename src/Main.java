import java.awt.*;
import javax.swing.*;

public class Main extends JFrame {
    public static void main(String[] args) throws Exception {
// for(int x=0; x<width; x+=width/36){
//    for(int y=0; y<height; y+=height/36){
// drawRect(x,y,width/36,height/36);
//    }
// }
Main window = new Main();
}
class Canvas extends JPanel{
public Canvas(){
    setPreferredSize(new Dimension(720,720));
}

public void paint(Graphics g){
    for (int i=10; i<710; i+=35){
        for(int j=10; j<710; j+=35){
          g.drawRect(i,j,35,35);  

        }
    }
    
}
}
private Main (){
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Canvas canvas = new Canvas();
    this.setContentPane(canvas);
    this.pack();
    this.setVisible(true);
}
    }

