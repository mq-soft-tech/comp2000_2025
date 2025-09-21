# Assignment 1 – Enhancements to Week 5 Grid

## How to Compile & Run
javac -d out $(find src -name "*.java")
java -cp out Main

## Summary of My Work
- Added **GrassCell**, **SandCell**, and **WaterCell** classes extending `Cell`.
- Created **Terrain** interface with `moveCost()` method.
- Updated **Grid** to place a patch of grass, a strip of sand, and a water column.
- Updated **Stage** to show cell type & move cost when hovering.
- Created **Group<T>** generic class and used it in `Stage` to manage `Actor` objects.

## Design Rationale
- **Inheritance:** Allows new cell types to be added without modifying grid logic, demonstrating polymorphism.
- **Interfaces:** `Terrain` decouples the concept of movement cost from the `Cell` hierarchy, making it easy to add more terrain types in the future.
- **Generics:** `Group<T>` is a reusable, type-safe container that makes actor management cleaner and improves code readability.

## Repository Details
- Based on the **week05** branch of the class repository.
- All work committed on a new branch `assignment1` with clear commit messages.
- `.gitignore` added to keep build outputs and `.DS_Store` out of version control.
