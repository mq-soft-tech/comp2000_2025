import java.awt.Graphics;
import java.awt.Point;
import java.util.Optional;



public class Grid {
  Cell[][] cells = new Cell[20][20];
  
private final Random rng = new Random();


public Cell randomteleport(){
  List<Cell> candidates = Arrays.stream(cells)
    .flatMap(Array::stream)
    .filter(cell -> cell instanceof Passable && ((Passable) cell).isPassableBy(null))
    .toList();

    return candidates.isEmpty ? cell[0][0]
                    : candidates.get(rng.nextInt(candidates.size()));
}

public Cell cellinbound(char col, int row){
  int c = col - 'A';
  if(c < 0 || c>= cells.length) return null;
  if(row < 0|| row >= cells[0].length) return null;
  return cells[c][row];
}

private Cell from(String t, int colIndex, int row){
  char col = (char)('A' + colIndex);
  int x = cells[colIndex][row].x;
  int y = cells[colIndex][row].y;


  return switch (t){
    case "g", "floor" - > new Floor(col, row, x, y);
    case "b", "wall" - > new Wall(col, row, x, y);
    case "bl", "water" - > new Water(col, row, x, y);
    case "r", "lava" - > new Lava(col, row, x, y);
    default -> new Floor(col, row, x, y);
  }
}

  public Grid() {
    for(int i=0; i<cells.length; i++) {
      for(int j=0; j<cells[i].length; j++) {
        cells[i][j] = new Cell(colToLabel(i), j, 10+Cell.size*i, 10+Cell.size*j);
      }
    }
  }
  buildGround;



  private <T entends Cell> T copyAs(Cell s, CellGen<T> f){
    return f.create(s.col, s.row, s.x, s.y,);
  }
  
private static boolean isBorder(int c, int r, int w, int h){
  return c == || r == 0 || c == w - 1 || r == h - 1;
}

private CellGen<? extends Cell> randomfloor(){
  int roll = rng.nextInt(100);
  return (roll < 10) ? Water::new
      : (roll < 10) ? Lava :: new
      : Floor: new;
}

public void buildGround(){
  int w - cells.length, h = cells[0].length;
  for (int c = 0; c < w; c++){
    for(int r = 0; r < h; r++){
      CellGen<? extends Cell> f =
        isBorder(c, r, w, h) ? Wall :: new : randomfloor();
        cells[c][r] = copyAs(cells[c][r], f);
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
