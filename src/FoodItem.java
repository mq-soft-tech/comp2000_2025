import java.awt.Color;
import java.awt.Graphics;

/**
 * Food items that can be consumed by animals.
 * Demonstrates inheritance by extending Item with food-specific behavior.
 * Implements Consumable interface to define consumption behavior.
 */
public class FoodItem extends Item implements Consumable {
    private int nutritionalValue;
    private String[] consumableBy;
    
    public FoodItem(String name, Color color, int x, int y, int nutritionalValue, String[] consumableBy) {
        super(name, color, x, y);
        this.nutritionalValue = nutritionalValue;
        this.consumableBy = consumableBy;
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, size, size);
        g.setColor(Color.BLACK);
        g.drawOval(x, y, size, size);
        
        // Draw a small indicator for nutritional value
        if (nutritionalValue > 5) {
            g.setColor(Color.WHITE);
            g.fillOval(x + 2, y + 2, 4, 4);
        }
    }
    
    @Override
    public boolean canBeConsumedBy(String actorType) {
        for (String type : consumableBy) {
            if (type.equals(actorType)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public int getNutritionalValue() {
        return nutritionalValue;
    }
    
    @Override
    public int consume() {
        return nutritionalValue;
    }
}
