import java.awt.Graphics;
import java.util.List;
import java.util.Random;

public class BotMoving implements GameState {
  @Override
  public void mouseClick(int x, int y, Stage s) {
    // no mouseClick activity for this GameState
  }

  @Override
  public void paint(Graphics g, Stage s) {
    for(Actor player: s.listOfPlayers) {
      if(player.isBot()) {
        List<Cell> possibleLocs = s.getClearRadius(player.loc, player.moves);
        int moveBotChooses = (new Random()).nextInt(possibleLocs.size());
        player.setLocation(possibleLocs.get(moveBotChooses));
      }
    }
    s.currentState = new ChoosingActor();
    for(Actor player: s.listOfPlayers) {
      player.turns = 1;
    }
  }  

  public String toString() {
    return getClass().getSimpleName();
  }
}
