public class Player {
    public int r, c; 

    public Player(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public boolean tryMoveTo(Cell target) {
        if (target instanceof Walkable) {
            return true;
        } else {
            return false;
        }
    }
}
