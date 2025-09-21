Comp2000_2025 — Grid Maze Adventure 
This repository is based on the COMP2000 classwork repository and extends the week 5 grid project with new functionality including:
Additional terrain types (WaterCell, LavaCell, FloorCell, WallCell).


A Warrior character that can collect coins and teleport randomly to valid floor cells.

An inheritance-based cell hierarchy to simplify extensibility.


A generic CellFactory<T extends Cell> for easy grid building from tokens.

How to Compile and Run
Requirements: Java 11 or Java 21. 
From the project root:
cd src
javac *.java
java Main
Alternatively:
Run Main - in Main.java
When run, a 20×20 grid window opens. Use the arrow keys to move the Warrior around. Collectible coins increase the Warrior’s score and random teleportation occurs when stepping onto Blue Cell (Water terrain), reset to start occurs when the Warrior Steps onto Red Cell (LavaCell).

Usage: 
From the spawn point, the ability to use the 4 arrows allows for the movement of the Warrior, corresponding to up arrow moving up, down arrow moving down, left arrow moving left and right arrow moving right. This then created the ability to guide through the maze and collect all the coins on the map, then search through the possible tracks to reach to the exit of the maze. 

Inheritance in the Design
Inheritance was used to create a cell hierarchy and an actor system:
Cell (base class): defines common properties (grid location, size, drawing).

FloorCell, WallCell, WaterCell, LavaCell: subclasses of Cell overriding behavior: 
FloorCell can be walked on.
WallCell can not be walked on, acts like a Wall.
LavaCell can be walked on but reset Warrior position.
WaterCell can be walked on but randomly spawns a new position on the map. 

Actor: defines common actor behavior and rendering. The Warrior extends this base and adds coin count and movement logic.

Generics in the Design
Generics were applied in a custom class:
CellFactory<T extends Cell>: a functional interface used to build grids from tokens (Letter corresponds to colour of Cell). It ensures type safety when constructing specialized Cell objects.

Example: Grid.buildGroundFromToken(String[][] map) uses this generic factory to instantiate the correct Cell subclass (FloorCell, WallCell, etc.).

Creativity and Improvements:
Compared to the baseline week 5 work:
New terrain types (water, lava, floor, wall).
Teleportation mechanic for the Warrior.
Collectibles system with coins.
Token driven map builder using generics.
HUD display for coin count and cell coordinates.

Changelog:
Floor and Wall Creation — initial terrain support.
Created Water and Lava Files — added new terrain types.
Creation of Random Teleporter of Warrior and reset of Warrior— implemented teleportation functionality and reset function.
Add Passable into Cell — introduced Passable interface for movement rules.
Updated Warrior — enhanced movement and rendering.
Coins - added coins to spawn on the map to be collected
Coin Collection- created a count of coins collected.
Debugging commits — iterative fixes and improvements.

Project File Structure: 
Doc:
4_goal.png
task9.png
src:
Actor.java
Cell.java
CellFactory.java
Coin.java
Collectible.java
FloorCell.java
LavaCell.java
Main.java
Passable.java
Stage.java
WallCell.java
Warrior.java
WaterCell.java
README.md
	
Credits
Developed by ethalo46123 as part of COMP2000 (2025). All work builds upon the official class repository with individual improvements for assessment.