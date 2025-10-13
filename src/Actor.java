import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.List;
import java.util.Random;

public abstract class Actor implements Pulse {
  Color baseColor, color;
  Cell loc;
  List<Polygon> display;
  boolean bot;
  int moves;
  int turns;
  MoveStrategy mover;

  protected Actor(Cell inLoc, Color inColor, boolean isBot, int inMoves) {
    loc = inLoc;
    baseColor = inColor;
    color = inColor;
    bot = isBot;
    moves = inMoves;
    turns = 1;
    setPoly();
  }

  public void paint(Graphics g) {
    for(Polygon p: display) {
      g.setColor(color);
      g.fillPolygon(p);
      g.setColor(Color.GRAY);
      g.drawPolygon(p);
    }
  }

  protected abstract void setPoly();

  public boolean isBot() {
    return bot;
  }

  public void setLocation(Cell inLoc) {
    loc = inLoc;
    if(loc.row % 2 == 0) {
      //mover = new MoveRandomly(); remove the subclass
      mover = (List<Cell> possibleLocs) -> {
        int i = (new Random()).nextInt(possibleLocs.size());
        return possibleLocs.get(i);
      };
      
    } else {
      //mover = new MoveLeft(); // lambda expression
      mover = (List<Cell> possibleLocs) ->{
        Cell currLM = possibleLocs.get(0);
        for(Cell c: possibleLocs) {
          if(c.leftOfComparison(currLM) < 0) {
          currLM = c;
          }
        }
      return currLM;
      };
    }
    setPoly();
  }

  public void pulsate(char phase, int percentage) {
    // Adjust color saturation according to the beat
    float[] hsbValues = new float[3];
    Color.RGBtoHSB(baseColor.getRed(), baseColor.getGreen(), baseColor.getBlue(), hsbValues);
    hsbValues[1] = ((float) percentage) / 100.0f;
    color = Color.getHSBColor(hsbValues[0], hsbValues[1], hsbValues[2]);
  }
}
