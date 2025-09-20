import java.awt.Graphics;
import java.awt.Point;
import java.util.Optional;



public class Grid {

Cell[][] cells = new Cell[20][20];


public Grid() {
  for(int i = 0; i<cells.length; i++) {
    for(int j = 0; j<cells[i].length; j++) {
      cells[i][j] = new Cell(colToLabel(i), j, 10+Cell.size*i, 10+Cell.size*j);
    }
  }
}

private char colToLabel(int col) {
  return (char) (col + 'A');
}

private int labelToCol(char col) {
  return (int) (col - 'A');
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

public void buildGroundFromToken(String[][]map){
  int rows = Math.min(cells[0].length, map.length);
  int cols = Math.min(cells.length, map[0].length);

  for(int r = 0; r < rows; r++){
    for(int c = 0; c < cols; c++){
      String token = map[r][c];
      setAs(c, r, factoryFor(token));
    }
  }
  makeFloor(0, 0);
  if(rows > 15) makeFloor (0, 15);
  if(cols > 12 && rows > 9) makeFloor(12, 9);
  if(rows > 8) makeFloor(0, 8);
 }

private CellFactory<? extends Cell> factoryFor(String token){
  switch (token){
    case "g": return FloorCell::new;
    case "r": return LavaCell::new;
    case "b": return WallCell::new;
    case "bl": return WaterCell::new;
    default: return FloorCell::new;
  }
}

private void setAs(int c, int r, CellFactory<? extends Cell> f){
  Cell cur = cells[c][r];
  cells[c][r] = f.create(cur.col, cur.row, cur.x, cur.y);
}

private void makeFloor(int c, int r){
  if(c >= 0 && c < cells.length && r >= 0 && r < cells[c].length){
    Cell cur = cells[c][r];
  cells[c][r] = new FloorCell(cur.col, cur.row, cur.x, cur.y);
  }
}
public java.util.Optional<Cell> randomFloor(){
  java.util.Random rng = new java.util.Random();
  for(int tries = 0; tries < 500; tries++){
    int c = rng.nextInt(cells.length);
    int r = rng.nextInt(cells[0].length);
    Cell cell = cells[c][r];
    if (cell instanceof FloorCell) return Optional.of(cell);
  }
  return Optional.empty();
}


  
}
