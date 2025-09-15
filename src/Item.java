import java.awt.Graphics;

public interface Item {
  String getName();
  void paint(Graphics g);
  Cell getCell();
}


