# Ecosystem Simulation Game

## Overview

This project extends the basic grid-based game from week 5 into a comprehensive ecosystem simulation. The game features diverse terrain types, a food system with different items, and animal behaviors that demonstrate intelligent use of inheritance, interfaces, and generics in Java.

## How to Compile and Run

### Prerequisites
- Java 11 or Java 21 (both versions are supported)
- No additional dependencies required

### Compilation
```bash
cd src
javac *.java
```

### Running
```bash
cd src
java Main
```

The game will open in a 1024x720 window with a 20x20 grid showing different terrain types and food items scattered throughout.

## Game Features

### Terrain System
The grid now features four different cell types:
- **Grass** (Green) - Easy to traverse, supports life, low movement cost
- **Water** (Blue) - Difficult to traverse, doesn't support land life, high movement cost  
- **Sand** (Beige) - Moderate traversal, limited life support, medium movement cost
- **Rock** (Gray) - Very difficult to traverse, no life support, highest movement cost

### Food System
Three types of food items are scattered throughout the ecosystem:
- **Bone** (Beige) - Can be consumed by dogs, provides 8 nutrition
- **Fish** (Orange) - Can be consumed by cats, provides 6 nutrition
- **Seed** (Brown) - Can be consumed by birds, provides 4 nutrition

### Animal Behavior
Animals now have hunger systems and can consume appropriate food items:
- **Cat** (Blue) - Can eat fish, max hunger: 10
- **Dog** (Yellow) - Can eat bones, max hunger: 12
- **Bird** (Green) - Can eat seeds, max hunger: 8

## Design Patterns and Java Concepts

### Inheritance

#### Cell Type Hierarchy
The most significant use of inheritance is in the cell type system:

```
CellType (abstract)
├── GrassCell
├── WaterCell  
├── SandCell
└── RockCell
```

**Why this demonstrates good inheritance design:**
- **Common Interface**: All cell types share the same contract (paint, getMovementCost, canSupportLife)
- **Specialized Behavior**: Each cell type has unique visual appearance and gameplay properties
- **Polymorphism**: The Cell class can work with any CellType without knowing the specific type
- **Extensibility**: New cell types can be easily added by extending CellType

#### Item Hierarchy
```
Item (abstract)
└── FoodItem (abstract)
    ├── Bone
    ├── Fish
    └── Seed
```

**Why this demonstrates good inheritance design:**
- **Code Reuse**: Common item functionality is shared through the hierarchy
- **Specialized Behavior**: Each food type has unique appearance and consumption rules
- **Type Safety**: The type system ensures only appropriate items can be consumed by specific animals

### Interfaces

#### Consumable Interface
```java
public interface Consumable {
    boolean canBeConsumedBy(String actorType);
    int getNutritionalValue();
    int consume();
}
```

**Why this demonstrates good interface design:**
- **Contract Definition**: Clearly defines what it means to be consumable
- **Flexibility**: Any class can implement Consumable, not just food items
- **Separation of Concerns**: Consumption behavior is separate from item appearance
- **Testability**: Easy to mock and test consumption behavior

#### Movable and Feeder Interfaces
```java
public interface Movable {
    void moveTo(Point newLocation);
    Point getCurrentLocation();
    boolean canMoveTo(Point location);
}

public interface Feeder {
    boolean consumeItem(Consumable item);
    int getHungerLevel();
    boolean isHungry();
}
```

**Why this demonstrates good interface design:**
- **Multiple Inheritance**: Actors can implement both Movable and Feeder
- **Behavioral Contracts**: Defines specific capabilities without implementation details
- **Flexibility**: Different actor types can have different movement/feeding behaviors

### Generics

#### Generic Item Management
The most sophisticated use of generics is in the item management system:

```java
public class ItemManager<T extends Item> {
    private List<T> items;
    // ... type-safe operations
}

public class EcosystemManager {
    private Map<String, ItemManager<? extends Item>> managers;
    // ... manages multiple item types
}
```

**Why this demonstrates excellent generics usage:**
- **Type Safety**: Compile-time checking ensures only appropriate items are managed
- **Code Reuse**: Single ItemManager class handles any type of item
- **Flexibility**: Can manage different item types with the same code
- **Custom Generic Class**: Goes beyond simple collections to create domain-specific generic types

#### Generic Collections
```java
List<Actor> actors;
List<Polygon> display;
Optional<Cell> cellAtPoint(Point p);
```

**Why this demonstrates good generics usage:**
- **Type Safety**: Prevents ClassCastException at runtime
- **Code Clarity**: Makes the code more readable and self-documenting
- **IDE Support**: Better autocomplete and error detection

## Architecture Benefits

### Maintainability
- **Single Responsibility**: Each class has a clear, focused purpose
- **Open/Closed Principle**: Easy to add new cell types, items, or actors without modifying existing code
- **Dependency Inversion**: High-level modules depend on abstractions (interfaces) not concretions

### Extensibility
- **New Cell Types**: Simply extend CellType and add to Grid generation
- **New Items**: Extend FoodItem and register with EcosystemManager
- **New Actors**: Extend Actor and implement required interfaces
- **New Behaviors**: Add new interfaces and implement them in existing classes

### Testability
- **Interface-Based**: Easy to create mock objects for testing
- **Dependency Injection**: Components can be easily replaced for testing
- **Isolated Concerns**: Each component can be tested independently

## Gameplay Instructions

1. **Explore the Terrain**: Move your mouse over different cells to see their properties
2. **Find Food**: Look for small colored items scattered around the grid
3. **Watch Animal Behavior**: Animals show hunger indicators (red dots) when they need food
4. **Observe Terrain Effects**: Different terrain types have different movement costs and life support

## Technical Implementation Notes

- **Random Terrain Generation**: Uses a fixed seed for reproducible terrain patterns
- **Collision Detection**: Items and actors use point-in-rectangle collision detection
- **Memory Management**: Items are managed through generic collections for efficient memory usage
- **Rendering Pipeline**: Separate rendering for terrain, items, and actors with proper layering

This implementation demonstrates a deep understanding of object-oriented design principles and Java's type system, creating a maintainable, extensible, and well-structured codebase that showcases the power of inheritance, interfaces, and generics in real-world applications.