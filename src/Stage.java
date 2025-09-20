import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



public class Stage {
  Grid grid;
  List<Actor> actors;
  private Warrior warrior;

  private List<Collectible> collectibles = new ArrayList<>();


private static final String[][] layout = {
/*1*/  {"b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b"},
/*2*/  {"b","b","b","bl","bl","b","g","g","g","b","b","g","g","g","b","bl","bl","b","b","b"},
/*3*/  {"b","b","g","g","g","g","g","b","g","g","g","g","b","g","g","g","g","g","b","b"},
/*4*/  {"b","g","g","b","b","b","g","b","g","b","r","b","b","g","b","b","b","g","g","b"},
/*5*/  {"b","g","b","b","r","r","g","g","g","b","r","b","g","g","g","r","r","b","b","b"},
/*6*/  {"b","g","b","r","g","g","g","b","g","g","r","g","g","b","g","g","g","r","b","b"},
/*7*/  {"b","g","g","r","g","bl","bl","b","bl","g","r","g","bl","b","bl","bl","g","r","g","b"},
/*8*/  {"b","b","g","r","r","g","g","g","g","g","r","g","g","g","g","g","r","r","g","b"},
/*9*/  {"b","bl","g","g","g","g","b","r","r","r","r","r","r","r","b","g","g","g","g","b"},
/*10*/ {"g","g","g","b","b","g","b","r","g","g","g","g","g","r","b","g","b","b","bl","b"},
/*11*/ {"b","bl","g","g","g","g","g","r","g","b","bl","b","g","r","b","g","g","g","g","b"},
/*12*/ {"b","b","g","b","r","r","g","r","g","b","g","b","g","r","g","r","r","b","g","b"},
/*13*/ {"b","g","g","b","r","g","g","r","r","b","g","b","r","r","g","g","r","b","g","b"},
/*14*/ {"b","g","bl","g","r","g","b","g","g","g","g","g","g","g","b","g","r","g","g","b"},
/*15*/ {"b","g","bl","g","r","g","b","g","bl","bl","bl","bl","bl","g","b","g","r","g","g","b"},
/*16*/ {"b","b","g","g","r","g","g","g","g","b","g","b","g","g","g","g","r","g","g","b"},
/*17*/ {"b","bl","g","b","r","r","r","r","g","b","g","b","g","r","r","r","r","b","g","b"},
/*18*/ {"b","g","g","b","g","g","g","g","g","g","g","g","g","g","g","g","g","b","g","g"},
/*19*/ {"b","b","b","b","b","b","g","g","g","g","g","g","g","g","g","b","b","b","b","b"},
/*20*/ {"b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b","b"}
};

  public Stage() {
    grid = new Grid();
    grid.buildGroundFromToken(layout);
    actors = new ArrayList<Actor>();
    warrior = new Warrior(grid, grid.cellAtColRow(0,8).get());
    actors.add(warrior); 
    collectibles.add(new Coin(16, 5));
    collectibles.add(new Coin(3, 2));
    collectibles.add(new Coin(12, 13));
    collectibles.add(new Coin(9, 17));
    collectibles.add(new Coin(1, 14));

  }

  public void moveWarrior(int dc, int dr) {
    warrior.moveBy(dc, dr);

    for (int i = 0; i < collectibles.size(); i++) {
      Collectible c = collectibles.get(i);
      if (c.getCol() == warrior.getCol() && c.getRow() == warrior.getRow()) {
        c.collect(warrior);
        collectibles.remove(i);
        break;
      }
    }
  }

  public void paint(Graphics g, Point mouseLoc) {
    grid.paint(g, mouseLoc);
    for (Collectible c : collectibles) {
      c.paint(g);
    }
    for(Actor a: actors) {
      a.paint(g);
    }

    Cell exitCell = grid.cellAtColRow(19, 17).get();
    g.setColor(Color.BLACK);
    int size = Cell.size;
    int cx = exitCell.x;
    int cy = exitCell.y;
    g.drawLine(cx, cy, cx + size, cy + size);
    g.drawLine(cx + size, cy, cx, cy + size);

    int coins = warrior.getCoins();
    g.setColor(Color.ORANGE);
    g.drawString("Coins: " + coins, 20, 40);

    Optional<Cell> underMouse = grid.cellAtPoint(mouseLoc);
    if(underMouse.isPresent()) {
      Cell hoverCell = underMouse.get();
      g.setColor(Color.BLACK);
      g.drawString(String.valueOf(hoverCell.col) + String.valueOf(hoverCell.row), 740, 30);
    }
  }
}
