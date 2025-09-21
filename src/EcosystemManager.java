import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

/**
 * Generic ecosystem manager that can handle multiple types of items.
 * Demonstrates advanced generics usage by managing different item types
 * in a type-safe manner.
 */
public class EcosystemManager {
    private Map<String, ItemManager<? extends Item>> managers;
    
    public EcosystemManager() {
        this.managers = new HashMap<>();
    }
    
    /**
     * Register a new item manager for a specific type
     */
    public <T extends Item> void registerManager(String typeName, ItemManager<T> manager) {
        managers.put(typeName, manager);
    }
    
    /**
     * Get a manager for a specific item type
     */
    @SuppressWarnings("unchecked")
    public <T extends Item> ItemManager<T> getManager(String typeName) {
        return (ItemManager<T>) managers.get(typeName);
    }
    
    /**
     * Add an item to the appropriate manager
     */
    public <T extends Item> void addItem(String typeName, T item) {
        ItemManager<T> manager = getManager(typeName);
        if (manager != null) {
            manager.addItem(item);
        }
    }
    
    /**
     * Get all items at a specific location across all managers
     */
    public Map<String, java.util.List<? extends Item>> getAllItemsAt(Point location) {
        Map<String, java.util.List<? extends Item>> allItems = new HashMap<>();
        for (Map.Entry<String, ItemManager<? extends Item>> entry : managers.entrySet()) {
            allItems.put(entry.getKey(), entry.getValue().getItemsAt(location));
        }
        return allItems;
    }
    
    /**
     * Paint all items from all managers
     */
    public void paintAll(Graphics g) {
        for (ItemManager<? extends Item> manager : managers.values()) {
            manager.paintAll(g);
        }
    }
    
    /**
     * Get total item count across all managers
     */
    public int getTotalItemCount() {
        int total = 0;
        for (ItemManager<? extends Item> manager : managers.values()) {
            total += manager.getItemCount();
        }
        return total;
    }
    
    /**
     * Clear all items from all managers
     */
    public void clearAll() {
        for (ItemManager<? extends Item> manager : managers.values()) {
            manager.clear();
        }
    }
}
