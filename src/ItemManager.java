import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class ItemManager<T extends Item> {
    private List<T> items;
    
    public ItemManager() {
        this.items = new ArrayList<>();
    }
    
    public void addItem(T item) {
        items.add(item);
    }
    
    public List<T> getItemsAt(Point location) {
        List<T> itemsAtLocation = new ArrayList<>();
        for (T item : items) {
            if (item.contains(location)) {
                itemsAtLocation.add(item);
            }
        }
        return itemsAtLocation;
    }
    
    public void paintAll(Graphics g) {
        for (T item : items) {
            item.paint(g);
        }
    }
    
    public int getItemCount() {
        return items.size();
    }
}
