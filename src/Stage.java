import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Stage {
  Grid grid;
  List<Actor> actors;
  ItemManager<FoodItem> foodManager;
  private Random random = new Random();

  public Stage() {
    grid = new Grid();
    actors = new ArrayList<Actor>();
    actors.add(new Cat(grid.cellAtColRow(0, 0).get()));
    actors.add(new Dog(grid.cellAtColRow(0, 15).get()));
    actors.add(new Bird(grid.cellAtColRow(12, 9).get()));
    
    // Initialize food manager
    foodManager = new ItemManager<FoodItem>();
    
    // Add some food items
    addRandomFoodItems();
  }
  
  private void addRandomFoodItems() {
    for (int i = 0; i < 10; i++) {
      Optional<Cell> randomCell = grid.cellAtColRow(random.nextInt(20), random.nextInt(20));
      if (randomCell.isPresent()) {
        Cell cell = randomCell.get();
        int x = cell.x + random.nextInt(20);
        int y = cell.y + random.nextInt(20);
        
        int itemType = random.nextInt(3);
        switch (itemType) {
          case 0:
            foodManager.addItem(new Bone(x, y));
            break;
          case 1:
            foodManager.addItem(new Fish(x, y));
            break;
          case 2:
            foodManager.addItem(new Seed(x, y));
            break;
        }
      }
    }
  }

  public void paint(Graphics g, Point mouseLoc) {
    grid.paint(g, mouseLoc);
    
    // Paint all food items
    foodManager.paintAll(g);
    
    // Paint all actors
    for(Actor a: actors) {
      a.paint(g);
    }
    
    // Draw info panel background
    g.setColor(new Color(240, 240, 240));
    g.fillRect(720, 10, 290, 300);
    g.setColor(Color.BLACK);
    g.drawRect(720, 10, 290, 300);
    
    // Display information about the cell under the mouse
    Optional<Cell> underMouse = grid.cellAtPoint(mouseLoc);
    if(underMouse.isPresent()) {
      Cell hoverCell = underMouse.get();
      g.setColor(Color.BLACK);
      g.setFont(g.getFont().deriveFont(14f));
      g.drawString("Cell Information", 730, 30);
      g.setFont(g.getFont().deriveFont(12f));
      g.drawString("Location: " + hoverCell.col + hoverCell.row, 730, 50);
      g.drawString("Type: " + hoverCell.getCellType().getName(), 730, 70);
      
      // Show items at this location
      List<FoodItem> itemsAtLocation = foodManager.getItemsAt(mouseLoc);
      if (!itemsAtLocation.isEmpty()) {
        g.drawString("Items found: " + itemsAtLocation.size(), 730, 90);
        for (int i = 0; i < Math.min(itemsAtLocation.size(), 3); i++) {
          g.drawString("• " + itemsAtLocation.get(i).getName(), 740, 110 + i * 15);
        }
      } else {
        g.drawString("No items here", 730, 90);
      }
    } else {
      g.setColor(Color.BLACK);
      g.setFont(g.getFont().deriveFont(14f));
      g.drawString("Grid Game", 730, 30);
      g.setFont(g.getFont().deriveFont(12f));
      g.drawString("Move mouse over cells", 730, 50);
      g.drawString("to see information", 730, 70);
    }
    
    // Display statistics
    g.setColor(Color.BLACK);
    g.setFont(g.getFont().deriveFont(14f));
    g.drawString("Game Statistics", 730, 150);
    g.setFont(g.getFont().deriveFont(12f));
    g.drawString("Total Items: " + foodManager.getItemCount(), 730, 170);
    g.drawString("Animals: " + actors.size(), 730, 190);
    
    // Draw legend
    g.setFont(g.getFont().deriveFont(14f));
    g.drawString("Legend", 730, 220);
    g.setFont(g.getFont().deriveFont(10f));
    g.drawString("Grass (Green) - Water (Blue)", 730, 240);
    g.drawString("Sand (Beige) - Rock (Gray)", 730, 255);
    g.drawString("Bone (Beige) - Fish (Orange) - Seed (Brown)", 730, 270);
    g.drawString("Cat (Blue) - Dog (Yellow) - Bird (Green)", 730, 285);
  }
}
