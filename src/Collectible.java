public interface Collectible {
    void collect(Warrior w); 
    void paint(java.awt.Graphics g); 
    int getCol();
    int getRow();
}