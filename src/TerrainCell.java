import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class TerrainCell extends Cell{
    private final Terrain terrain;

    public TerrainCell (char inCol, int inRow, int x, int y, Terrain terrain) {
        super(inCol, inRow, x, y);
        this.terrain = terrain;
    }
    public Terrain getTerrian() {
        return terrain;
    }
    public boolean isPassableBy(Actor actor) {
        switch(terrain) {
            case WATER:
            return (actor instanceof Swimmer) || (actor instanceof Flier);
            case MOUNTAIN:
            return (actor instanceof Flier);
            case GRASS:
            case SAND:
            default:
            return true;  
        }
    }
    @Override
    public void paint (Graphics g, Point mousePos) {
        Color base;
        switch(terrain) {
            case WATER: base = new Color(120, 170, 255); break;
            case SAND: base = new Color(240, 220, 140); break;
            case MOUNTAIN: base = new Color(170, 170, 170); break;
            case GRASS:
            default: base = new Color(170, 220, 170); break;
        }
        g.setColor(base);
        g.fillRect(x, y, size, size);

        g.setColor(Color.BLACK);
        g.drawRect(x, y, size, size);

        if (mousePos != null && contains(mousePos)) {
            g.setColor(Color.DARK_GRAY);
            g.drawRect(x + 1, y + 1, size - 2, size - 2);
        }
    }

        

}
