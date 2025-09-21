import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Cell extends Rectangle {
  static int size = 35;
  char col;
  int row;
  CellType cellType;

  public Cell(char inCol, int inRow, int x, int y, CellType cellType) {
    super(x, y, size, size);
    col = inCol;
    row = inRow;
    this.cellType = cellType;
  }

  public void paint(Graphics g, Point mousePos) {
    boolean isHighlighted = contains(mousePos);
    cellType.paint(g, x, y, size, isHighlighted);
  }

  public boolean contains(Point p) {
    if(p != null) {
      return super.contains(p);
    } else {
      return false;
    }
  }
  
  public CellType getCellType() {
    return cellType;
  }
  
  public int getMovementCost() {
    return cellType.getMovementCost();
  }
  
  public boolean canSupportLife() {
    return cellType.canSupportLife();
  }
}
