import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main extends JFrame {

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(Main::new);
    }

    // --- grid constants
    private static final int OFFSET = 10;     // margin from panel edge
    private static final int SIZE   = 700;    // grid square size
    private static final int CELL   = 35;     // cell size
    private static final int N      = SIZE / CELL; // number of rows/cols

    class Canvas extends JPanel {
        // hovered cell (-1 means none)
        private int hoverRow = -1, hoverCol = -1;

        public Canvas() {
            setPreferredSize(new Dimension(SIZE + 2 * OFFSET, SIZE + 2 * OFFSET));
            setBackground(Color.WHITE);

            // Track mouse movement and update hovered cell
            addMouseMotionListener(new MouseMotionAdapter() {
                @Override public void mouseMoved(MouseEvent e)   { updateHover(e.getPoint()); }
                @Override public void mouseDragged(MouseEvent e) { updateHover(e.getPoint()); }
            });
        }

        private void updateHover(Point p) {
            if (p == null) { // mouse might be outside during some events
                if (hoverRow != -1 || hoverCol != -1) {
                    hoverRow = hoverCol = -1;
                    repaint();
                }
                return;
            }
            int x = p.x - OFFSET;
            int y = p.y - OFFSET;

            int c = (x >= 0 && x < SIZE) ? x / CELL : -1;
            int r = (y >= 0 && y < SIZE) ? y / CELL : -1;

            if (r != hoverRow || c != hoverCol) {
                hoverRow = r;
                hoverCol = c;
                repaint();
            }
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);

            // border
            g.setColor(Color.BLACK);
            g.drawRect(OFFSET, OFFSET, SIZE, SIZE);

            // highlight hovered cell
            if (hoverRow >= 0 && hoverRow < N && hoverCol >= 0 && hoverCol < N) {
                int x = OFFSET + hoverCol * CELL;
                int y = OFFSET + hoverRow * CELL;
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(x + 1, y + 1, CELL - 1, CELL - 1);
            }

            // grid lines
            g.setColor(Color.BLACK);
            for (int i = 0; i <= N; i++) {
                int pos = OFFSET + i * CELL;
                g.drawLine(OFFSET, pos, OFFSET + SIZE, pos);       // horizontal
                g.drawLine(pos, OFFSET, pos, OFFSET + SIZE);       // vertical
            }
        }
    }

    public Main() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(new Canvas());
        this.pack();
        this.setVisible(true);
    }
}
