import java.awt.Color;

public class FoodItem extends Item implements Consumable {
    private String animalType;
    
    public FoodItem(String name, Color color, int x, int y, String animalType) {
        super(name, color, x, y);
        this.animalType = animalType;
    }
    
    public boolean canBeEatenBy(String actorType) {
        return animalType.equals(actorType);
    }
}
