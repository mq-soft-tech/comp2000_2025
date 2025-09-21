/**
 * Interface for items that can be consumed by actors.
 * Demonstrates interface usage by defining a contract for consumable behavior.
 */
public interface Consumable {
    /**
     * Check if this item can be consumed by the specified actor type
     */
    boolean canBeConsumedBy(String actorType);
    
    /**
     * Get the nutritional value this item provides when consumed
     */
    int getNutritionalValue();
    
    /**
     * Consume this item and return the nutritional value gained
     */
    int consume();
}
