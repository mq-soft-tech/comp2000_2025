import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class TerrainCell extends Cell{
    private final Terrain terrain;
    private final Bag<Item> loot = new Bag<>();
    public TerrainCell(char col, int row, int x, int y, Terrain t){ super(col,row,x,y); this.terrain=t; }
    public Terrain getTerrain(){ return terrain; }
    public boolean isPassableBy(Actor a){
        switch (terrain){
            case WATER:    return (a instanceof Flier);
            case MOUNTAIN: return (a instanceof Flier);
            default:       return true;
        }
    }
    public void addItem(Item item) { loot.add(item); }
    public void pickupAll(Actor actor) {
        if (!loot.isEmpty()) {
            for (Item it : loot.view()) {
                it.apply(actor);        // áp dụng hiệu ứng
                actor.bagAdd(it);       // cất vào túi của Actor (nhớ có bagAdd trong Actor)
                System.out.println(actor.getName() + " picked " + it.name());
            }
            loot.clear();
        }
    }
    public int moveCost(Actor a){
        switch (terrain){
            case SAND: return 1;
            default:   return 0;
        }
    }

    @Override
    public void paint(Graphics g, Point mousePos) {
        Color base;
        switch (terrain) {
            case WATER:    base = new Color(120, 170, 255); break;
            case SAND:     base = new Color(240, 220, 140); break;
            case MOUNTAIN: base = new Color(170, 170, 170); break;
            case GRASS:
            default:       base = new Color(170, 220, 170); break;
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