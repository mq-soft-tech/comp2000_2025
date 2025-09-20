@FunctionalInterface
public interface CellFactory< T extends Cell> {
    T create(char col, int row, int x, int y);
}
