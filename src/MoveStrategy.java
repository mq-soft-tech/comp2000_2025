import java.util.List;

public interface MoveStrategy {
  public Cell chooseNextLoc(List<Cell> possibleLocs, Actor currActor, List<Actor> otherActors);
}
