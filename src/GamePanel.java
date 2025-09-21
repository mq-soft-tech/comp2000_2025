import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements KeyListener, MouseMotionListener {
    Grid<Cell> grid;
    Player player;
    Point mousePos = new Point(0, 0);
    boolean won = false;

    public GamePanel(Grid<Cell> g, Player p) {
        grid = g;
        player = p;

        setPreferredSize(new Dimension(grid.cols() * Cell.size, grid.rows() * Cell.size));
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        addKeyListener(this);
        addMouseMotionListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // draw all cells
        for (int r = 0; r < grid.rows(); r++) {
            for (int c = 0; c < grid.cols(); c++) {
                grid.get(r, c).paint(g, mousePos);
            }
        }

        // highlight GOAL (bottom-right) with a gold outline
        int gr = grid.rows() - 1, gc = grid.cols() - 1;
        int gx = gc * Cell.size, gy = gr * Cell.size;
        g.setColor(Color.YELLOW);
        g.drawRect(gx + 2, gy + 2, Cell.size - 4, Cell.size - 4);
        g.drawRect(gx + 4, gy + 4, Cell.size - 8, Cell.size - 8);

        // draw PLAYER
        int px = player.c * Cell.size, py = player.r * Cell.size;
        int pad = 6;
        g.setColor(Color.RED);
        g.fillOval(px + pad, py + pad, Cell.size - 2 * pad, Cell.size - 2 * pad);
        g.setColor(Color.BLACK);
        g.drawOval(px + pad, py + pad, Cell.size - 2 * pad, Cell.size - 2 * pad);

        // HUD text
        g.setFont(new Font("SansSerif", Font.BOLD, 14));
        g.setColor(Color.BLACK);
        g.drawString("Goal: reach the yellow square (W/A/S/D)", 8, 16);

        if (won) {
            g.setFont(new Font("SansSerif", Font.BOLD, 24));
            g.setColor(new Color(0, 150, 0));
            g.drawString("You Win!", 20, 50);
        }
    }

    public void keyPressed(KeyEvent e) {
        if (won) return;

        char ch = Character.toUpperCase(e.getKeyChar());
        int dr = 0, dc = 0;
        if (ch == 'W') dr = -1;
        else if (ch == 'S') dr = 1;
        else if (ch == 'A') dc = -1;
        else if (ch == 'D') dc = 1;
        else return;

        int nr = player.r + dr, nc = player.c + dc;
        if (!grid.inBounds(nr, nc)) return;

        Cell target = grid.get(nr, nc);
        if (player.tryMoveTo(target)) {
            player.r = nr;
            player.c = nc;
            repaint();

            // win condition: bottom-right cell
            if (player.r == grid.rows() - 1 && player.c == grid.cols() - 1) {
                won = true;
                repaint();
                JOptionPane.showMessageDialog(this, "You reached the goal!");
            }
        } else {
            Toolkit.getDefaultToolkit().beep(); // blocked (e.g., water)
        }
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
    public void mouseMoved(MouseEvent e) { mousePos = e.getPoint(); repaint(); }
    public void mouseDragged(MouseEvent e) { mouseMoved(e); }
}
