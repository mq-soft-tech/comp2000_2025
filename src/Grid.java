import java.awt.Graphics;
import java.awt.Point;
import java.util.Optional;
import java.util.Random;

public class Grid {
  Cell[][] cells = new Cell[20][20];
  private Random random = new Random(42); // Fixed seed for reproducible terrain
  
  public Grid() {
    for(int i=0; i<cells.length; i++) {
      for(int j=0; j<cells[i].length; j++) {
        CellType cellType = generateCellType(i, j);
        cells[i][j] = new Cell(colToLabel(i), j, 10+Cell.size*i, 10+Cell.size*j, cellType);
      }
    }
  }
  
  private CellType generateCellType(int col, int row) {
    // Create a varied terrain pattern
    double distanceFromCenter = Math.sqrt(Math.pow(col - 10, 2) + Math.pow(row - 10, 2));
    double noise = random.nextDouble();
    
    if (distanceFromCenter < 3) {
      return new RockCell(); // Center is rocky
    } else if (distanceFromCenter < 8) {
      if (noise < 0.3) {
        return new WaterCell();
      } else if (noise < 0.6) {
        return new SandCell();
      } else {
        return new GrassCell();
      }
    } else {
      if (noise < 0.2) {
        return new WaterCell();
      } else if (noise < 0.4) {
        return new SandCell();
      } else {
        return new GrassCell();
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
