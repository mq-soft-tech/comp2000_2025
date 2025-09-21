# Grid Game - Animal World Simulation

## Project Overview
The game that I built in this project is a java-based grid game. In this, I have considered different types of animal habitat and their food habits according to various regions. I have used the core OOP concepts in this game.

## How to Compile and Run

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

## Requirements
- Java 11 or Java 21 (both versions are supported)
- No additional dependencies required

## File Structure
```
├── Main.java
├── Stage.java
├── Grid.java
├── Cell.java
├── Actor.java
├── CellType.java
├── Item.java
├── FoodItem.java
├── ItemManager.java
├── Consumable.java
├── [Animals]
    ├── Cat.java
    ├── Dog.java
    ├── Bird.java
├── [Cell Types]        
    ├── GrassCell.java
    ├── WaterCell.java
    ├── SandCell.java
└── [Food Items]        
    ├── Bone.java
    ├── Fish.java
    ├── Seed.java
```

## Features
- **Interactive Grid**: 20x20 grid 
- **Cell Types**: Three types of cells
  - Grass
  - Sand
  - Water
- **Animals**: Three types of animals with distinct visual representations
  - Cats (blue)
  - Dogs (yellow)
  - Birds (green)
- **Food System**: Different food items scattered across the grid
  - Bone (For Dogs)
  - Fish (For Cats)
  - Seed (For Birds)
- **Information**: When we hover the mouse over the grid, we get the cell and item informations on the right side of the screen.
- **Visual Effects**: Shadows, Colored element

## Class Structure

### Core Classes
- **Main**: Entry point and window management
- **Stage**: Game logic and rendering coordinator
- **Grid**: Manages the 20x20 cell grid
- **Cell**: Individual grid cell with position and type

## Technical Implementation

### 1. Interface Usage - Consumable
**Definition:** It is a type which is used to define a set of methods that a class needs to implement

**Why I used it:**
- I used to determine which animal is gonna eat which one.
- It also helps to enable the polymorphic food comption behaviour.

**How I implemented it:**
```java
public interface Consumable {
    boolean canBeEatenBy(String actorType);
}
```

The FoodItem class applies this interface. Through this, it determines whether the food is consumable for the animal or not. This design is helpful because:
- It separates the concept of "being edible" from the item hierarchy
- Allows for future expansion (any class could implement Consumable)
- Enables type-safe food interaction logic

### 2. Inheritance:
**Definition:** Inheritance means a class that possess all the methods and properties of another class
### Actor Hierarchy (Inheritance)
```
Actor
├── Cat
├── Dog
└── Bird
```

**Why:** All the characters that I used here have common behavior that includes painting, location management and their own unique appearance.

**How:** Though I have used the same class and method for all the species, but due to use of overrides drawDetails() the unique features e.g.whiskers for cats, floppy ears for dogs, beaks for birds are expressed.

### Cell Type Hierarchy (Inheritance)
```
CellType
├── GrassCell
├── WaterCell
├── SandCell
└── RockCell
```

**Why:** Though I considered basic painting for all the cells but they differ due to different visual patterns.

**How:** I created the background with basic class, but the subclasses override drawPattern() for region specified details.

### Item Hierarchy (Inheritance)
```
Item
└── FoodItem
    ├── Bone
    ├── Fish
    └── Seed
```

**Why:** The items that I used have common behavior like their positions and basic features, but food logics are specified for each item.

**How:** Due to different levels of inheritance, FoodItem adds logic for consumption. This specifies unique visuals for each different group.

### 3. Generic Management
**Definition:** It allows us to use class, interfaces for different types.
- **ItemManager\<T>**: This is a generic class which is used to manage the items.

**Why I used generics:**
- Instead of using different methods and class, I have used Generic class to make it more easier to manage collection of items
- Through this, I got the advantage of managing the items with the same code rather than writing the same thing again and again.
- I just need to check Compiler error instead of checking run time error


## Graphic feature:
- I have customized different polygons to express animal shapes.
- Further, shadow effects have added depth to each object.
- To differentiate regions, I have used different colors.
- The mouse interaction is presented real time based for better understanding.
- Finally, the statistical data are presented in the information panel.
