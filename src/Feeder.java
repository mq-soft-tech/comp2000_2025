/**
 * Interface for objects that can consume food.
 * Demonstrates interface usage by defining feeding behavior.
 */
public interface Feeder {
    /**
     * Attempt to consume an item
     */
    boolean consumeItem(Consumable item);
    
    /**
     * Get the current hunger level
     */
    int getHungerLevel();
    
    /**
     * Get the maximum hunger level
     */
    int getMaxHunger();
    
    /**
     * Check if this feeder is hungry
     */
    boolean isHungry();
}
