Assignment 1 
**Overview**

The grid exercise from Week 5 is expanded upon in this project.  I created a small grid-based game in which the player must navigate from the upper-left corner to the lower-right corner.  Every time the program runs, a new grid with three distinct terrain types, grass, sand, and water, is created at random.  Every form of terrain has its unique behaviour and is implemented as a subclass of Cell.  The W, A, S, and D keys allow the player to travel across the grid.  Sand and grass allow for walking, but water prevents it.  Since both the start and finish cells are set to Grass, the ultimate goal is always assured to be achievable.

**Design and Use of Concepts**

**Inheritance**
I created an abstract Cell class that stores the common properties (size, row, column, and drawing behaviour).
Three subclasses (GrassCell, SandCell, and WaterCell) extend the Cell class. This lets me reuse code while giving each terrain its own rules and graphics. For example, Grass is simple to walk on, Sand has a higher movement cost, and Water blocks movement.

**Interfaces**
I added Walkable and Swimmable interfaces to represent capabilities. Grass and Sand implement Walkable, while Water implements Swimmable. The player checks whether a cell is Walkable before moving. This design makes it easy to add more terrain types later (e.g. Lava could be neither walkable nor swimmable).

**Generics**
The Grid class uses generics so that the grid can hold any subtype of Cell. This improves type safety and reusability. For example, the same grid code works whether it contains only GrassCell or a mixture of all three cell types.

**Creativity/Uniqueness**
I added random terrain generation so each run of the game is different. I also included a clear start and finish goal so the player has an objective. This goes beyond the base classwork and demonstrates creativity while still showing the use of inheritance, interfaces, and generics.

**How to Compile and Run**

Windows (VS Code terminal)
run command (top right, looks like the 'pause' button)

After running, a window will open showing the grid.

Use W, A, S, D to move the player (red circle).

The goal is to reach the bottom-right corner (outlined in yellow).

Grass and Sand can be walked on. Water blocks movement.

The map is different each time because the terrain is generated randomly.

**File Overview**

Cell.java – abstract base class for all grid cells.

GrassCell.java, SandCell.java, WaterCell.java are  subclasses of Cell with their own behaviour and drawing.

Walkable.java and Swimmable.java  interfaces for movement rules.

Grid.java – generic grid implementation that stores Cell objects.

Player.java – stores the player’s position and checks valid movement.

GamePanel.java – Swing panel that draws the grid and handles WASD controls.

Main.java – entry point that sets up the grid, generates random terrain, and launches the game window.
