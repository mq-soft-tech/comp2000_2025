@FunctionalInterface

public interface CellGen< T extends Cell{
    T create(char col, int row, int x, int y);
    
}
