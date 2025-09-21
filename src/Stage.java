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
  EcosystemManager ecosystemManager;
  private Random random = new Random();

  public Stage() {
    grid = new Grid();
    actors = new ArrayList<Actor>();
    actors.add(new Cat(grid.cellAtColRow(0, 0).get()));
    actors.add(new Dog(grid.cellAtColRow(0, 15).get()));
    actors.add(new Bird(grid.cellAtColRow(12, 9).get()));
    
    // Initialize ecosystem manager
    ecosystemManager = new EcosystemManager();
    ecosystemManager.registerManager("Food", new ItemManager<FoodItem>("Food"));
    
    // Add some food items to the ecosystem
    addRandomFoodItems();
  }
  
  private void addRandomFoodItems() {
    for (int i = 0; i < 15; i++) {
      Optional<Cell> randomCell = grid.cellAtColRow(random.nextInt(20), random.nextInt(20));
      if (randomCell.isPresent()) {
        Cell cell = randomCell.get();
        int x = cell.x + random.nextInt(20);
        int y = cell.y + random.nextInt(20);
        
        int itemType = random.nextInt(3);
        switch (itemType) {
          case 0:
            ecosystemManager.addItem("Food", new Bone(x, y));
            break;
          case 1:
            ecosystemManager.addItem("Food", new Fish(x, y));
            break;
          case 2:
            ecosystemManager.addItem("Food", new Seed(x, y));
            break;
        }
      }
    }
  }

  public void paint(Graphics g, Point mouseLoc) {
    grid.paint(g, mouseLoc);
    
    // Paint all items
    ecosystemManager.paintAll(g);
    
    // Paint all actors
    for(Actor a: actors) {
      a.paint(g);
    }
    
    // Display information about the cell under the mouse
    Optional<Cell> underMouse = grid.cellAtPoint(mouseLoc);
    if(underMouse.isPresent()) {
      Cell hoverCell = underMouse.get();
      g.setColor(Color.DARK_GRAY);
      g.drawString("Cell: " + hoverCell.col + hoverCell.row, 740, 30);
      g.drawString("Type: " + hoverCell.getCellType().getTypeName(), 740, 50);
      g.drawString("Movement Cost: " + hoverCell.getMovementCost(), 740, 70);
      g.drawString("Supports Life: " + hoverCell.canSupportLife(), 740, 90);
      
      // Show items at this location
      List<? extends Item> itemsAtLocation = ecosystemManager.getManager("Food").getItemsAt(mouseLoc);
      if (!itemsAtLocation.isEmpty()) {
        g.drawString("Items: " + itemsAtLocation.size(), 740, 110);
        for (int i = 0; i < Math.min(itemsAtLocation.size(), 3); i++) {
          g.drawString("- " + itemsAtLocation.get(i).getName(), 750, 130 + i * 15);
        }
      }
    }
    
    // Display ecosystem statistics
    g.setColor(Color.BLACK);
    g.drawString("Total Items: " + ecosystemManager.getTotalItemCount(), 740, 200);
    g.drawString("Actors: " + actors.size(), 740, 220);
    
    // Display actor hunger levels
    int yOffset = 240;
    for (Actor actor : actors) {
      g.drawString(actor.getActorType() + " Hunger: " + actor.getHungerLevel() + "/" + actor.getMaxHunger(), 740, yOffset);
      yOffset += 20;
    }
  }
}
