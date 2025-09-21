import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int rows = 10, cols = 10;
        Grid<Cell> grid = new Grid<Cell>(rows, cols);
        Random rnd = new Random();

        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int x = c * Cell.size;
                int y = r * Cell.size;
                int roll = rnd.nextInt(100); 

                if (roll < 15) {
                    grid.set(r, c, new WaterCell((char) ('A' + c), r, x, y));
                } else if (roll < 35) {
                    grid.set(r, c, new SandCell((char) ('A' + c), r, x, y));
                } else {
                    grid.set(r, c, new GrassCell((char) ('A' + c), r, x, y));
                }
            }
        }

        
        grid.set(0, 0, new GrassCell('A', 0, 0, 0));
        grid.set(rows - 1, cols - 1,
                new GrassCell((char) ('A' + (cols - 1)), rows - 1,
                        (cols - 1) * Cell.size, (rows - 1) * Cell.size));

        Player player = new Player(0, 0);

      
        JFrame f = new JFrame("Grid Game - Reach the Goal!");
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setResizable(false);

        GamePanel panel = new GamePanel(grid, player);
        f.add(panel, BorderLayout.CENTER);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);

        
        panel.setFocusable(true);
        panel.setFocusTraversalKeysEnabled(false);
        panel.requestFocusInWindow();
        panel.requestFocus();
    }
}

