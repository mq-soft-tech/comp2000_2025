public interface Passable {
    default boolean isPassableBy(Actor actor){
        return true;
    }
}
