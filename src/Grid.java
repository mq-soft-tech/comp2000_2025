import java.awt.Graphics;
import java.awt.Point;
import java.util.Optional;

public class Grid {
  Cell[][] cells = new Cell[20][20];
  
  public Grid() {
  for (int i = 0; i < cells.length; i++) {
    for (int j = 0; j < cells[i].length; j++) {
      int x = 10 + Cell.size * i;
      int y = 10 + Cell.size * j;

      // default cell (white)
      cells[i][j] = new Cell(colToLabel(i), j, x, y);

      // grass patch (cols 4..9, rows 4..7)
      if (i >= 4 && i <= 9 && j >= 4 && j <= 7) {
        cells[i][j] = new GrassCell(colToLabel(i), j, x, y);
      }

      // sand strip (row 10, cols 2..15)
      if (j == 10 && i >= 2 && i <= 15) {
        cells[i][j] = new SandCell(colToLabel(i), j, x, y);
      }

      // water river (col 12, all rows)
      if (i == 12) {
        cells[i][j] = new WaterCell(colToLabel(i), j, x, y);
      }
    }
  }
}


  private char colToLabel(int col) {
    return (char) (col + Character.valueOf('A'));
  }

  private int labelToCol(char col) {
    return (int) (col - Character.valueOf('A'));
  }

  public void paint(Graphics g, Point mousePos) {
    for(int i=0; i<cells.length; i++) {
      for(int j=0; j<cells[i].length; j++) {
        cells[i][j].paint(g, mousePos);
      }
    }
  }

  public Optional<Cell> cellAtColRow(int c, int r) {
    if(c >= 0 && c < cells.length && r >=0 && r < cells[c].length) {
      return Optional.of(cells[c][r]);
    } else {
      return Optional.empty();
    }
  }

  public Optional<Cell> cellAtColRow(char c, int r) {
    return cellAtColRow(labelToCol(c), r);
  }

  public Optional<Cell> cellAtPoint(Point p) {
    for(int i=0; i < cells.length; i++) {
      for(int j=0; j < cells[i].length; j++) {
        if(cells[i][j].contains(p)) {
          return Optional.of(cells[i][j]);
        }
      }
    }
    return Optional.empty();
  }
}
