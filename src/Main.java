import java.awt.*;
import javax.swing.*;

public class Main extends JFrame {
    
class App extends JPanel{
    Grid grid;
public App(){
    setPreferredSize(new Dimension(720,720));
    grid = new Grid();
}

public void paint(Graphics g){
    grid.paint(g);
    
    
}
}
public static void main(String[] args) throws Exception {

Main window = new Main();
window.run();
}
private Main (){
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    App canvas = new App();
    this.setContentPane(canvas);
    this.pack();
    this.setVisible(true);
}
public void run(){
    while (true){
        this.repaint();
    }
}
    }

