import java.awt.Color;
import java.awt.Graphics;

public class Coin implements Collectible {
    private int col, row;
    public Coin(int col, int row) {
        this.col = col;
        this.row = row;
    }

    @Override
    public void collect(Warrior w) {
        w.addCoins(1);   
    }

    @Override
    public void paint(Graphics g) {
        int size = Cell.size;
        int x = col * size;
        int y = row * size;
        g.setColor(Color.YELLOW);
        g.fillOval(x + size/4, y + size/4, size/2, size/2);
    }

    @Override 
    public int getCol(){ 
        return col; 
    }
    @Override 
    public int getRow(){ 
        return row; 
    }
}
