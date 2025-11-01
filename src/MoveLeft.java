import java.util.List;

public class MoveLeft implements MoveStrategy {
  @Override
  public Cell chooseNextLoc(List<Cell> possibleLocs, Actor currActor, List<Actor> otherActors) {
    Cell currLM = possibleLocs.get(0);
    for(Cell c: possibleLocs) {
      if(c.leftOfComparison(currLM) < 0) {
        currLM = c;
      }
    }
    return currLM;
  }

  public String toString() {
    return "left-most movement";
  }
}
