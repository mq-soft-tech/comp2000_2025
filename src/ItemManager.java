import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Generic item management system that can handle any type of item.
 * Demonstrates generics by providing type-safe item management.
 * @param <T> The type of items this manager handles
 */
public class ItemManager<T extends Item> {
    private List<T> items;
    private String itemType;
    
    public ItemManager(String itemType) {
        this.items = new ArrayList<>();
        this.itemType = itemType;
    }
    
    /**
     * Add an item to the manager
     */
    public void addItem(T item) {
        items.add(item);
    }
    
    /**
     * Remove an item from the manager
     */
    public boolean removeItem(T item) {
        return items.remove(item);
    }
    
    /**
     * Get all items at a specific location
     */
    public List<T> getItemsAt(Point location) {
        List<T> itemsAtLocation = new ArrayList<>();
        for (T item : items) {
            if (item.contains(location)) {
                itemsAtLocation.add(item);
            }
        }
        return itemsAtLocation;
    }
    
    /**
     * Get the first item at a specific location
     */
    public T getFirstItemAt(Point location) {
        for (T item : items) {
            if (item.contains(location)) {
                return item;
            }
        }
        return null;
    }
    
    /**
     * Paint all items managed by this manager
     */
    public void paintAll(Graphics g) {
        for (T item : items) {
            item.paint(g);
        }
    }
    
    /**
     * Get all items
     */
    public List<T> getAllItems() {
        return new ArrayList<>(items);
    }
    
    /**
     * Get the number of items
     */
    public int getItemCount() {
        return items.size();
    }
    
    /**
     * Clear all items
     */
    public void clear() {
        items.clear();
    }
    
    /**
     * Get iterator for all items
     */
    public Iterator<T> iterator() {
        return items.iterator();
    }
    
    /**
     * Get the type of items this manager handles
     */
    public String getItemType() {
        return itemType;
    }
}
