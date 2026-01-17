import java.awt.Graphics;
import java.awt.Point;
import java.util.Optional;

public class Grid {
  Cell[][] cells = new Cell[20][20];
  
  public Grid() {
    for(int i=0; i<cells.length; i++) {
      for(int j=0; j<cells[i].length; j++) {
        TerrainCell tc = new TerrainCell(colToLabel(i), j, 10 + Cell.size * i, 10 + Cell.size * j, randomTerrain());
        
        double p = Math.random();
        if (tc.getTerrain() == Terrain.WATER && p < 0.05) tc.addItem(new Fish());
        else if (tc.getTerrain() == Terrain.GRASS && p < 0.05) tc.addItem(new Bone());
        else if (tc.getTerrain() == Terrain.SAND  && p < 0.05) tc.addItem(new Seed());

        cells[i][j] = tc; 
      }
    }
  }

  private char colToLabel(int col) { return (char) ('A' + col); }
  private int labelToCol(char col) { return col - 'A'; }

  public void paint(Graphics g, Point mousePos) {
    for (int i = 0; i < cells.length; i++) {
      for (int j = 0; j < cells[i].length; j++) {
        cells[i][j].paint(g, mousePos);
      }
    }
  }

  public Optional<Cell> cellAtColRow(int c, int r) {
    if (c >= 0 && c < cells.length && r >= 0 && r < cells[c].length) {
      return Optional.of(cells[c][r]);
    }
    return Optional.empty();
  }

  public Optional<Cell> cellAtColRow(char c, int r) {
    return cellAtColRow(labelToCol(c), r);
  }

  public Optional<Cell> cellAtPoint(Point p) {
    for (int i = 0; i < cells.length; i++) {
      for (int j = 0; j < cells[i].length; j++) {
        if (cells[i][j].contains(p)) return Optional.of(cells[i][j]);
      }
    }
    return Optional.empty();
  }

  private Terrain randomTerrain() {
    double r = Math.random();
    if (r < 0.10) return Terrain.WATER;
    if (r < 0.20) return Terrain.MOUNTAIN;
    if (r < 0.40) return Terrain.SAND;
    return Terrain.GRASS;
  }
}