# COMP2000 Assignment 1 – Grid Game

This project extends the Week 5 into a simple grid-based game: you control the Dog to reach the top row while avoiding other animals. Coins spawn randomly for points. The implementation demonstrates inheritance, interfaces, and generics in a cohesive design.

## How to run
- Requires Java 11 or Java 21

Controls: use the arrow keys to move the Dog one cell at a time.

## Where inheritance, interfaces, and generics improved the design

### Inheritance
- `Actor` is an abstract superclass that encapsulates shared state and behavior for all on-grid characters (location, rendering via polygon list, movement hooks).
- Concrete actors (polymorphic): `Cat`, `Dog`, `Bird`, `Fox`, `Turtle`, `Rabbit` each extend `Actor` and implement `updatePolygons()` to define their shapes and colors.
- Benefits: avoids duplication, allows `Stage` to manage a single `List<Actor>` and call `paint`/movement logic uniformly, and makes adding new actors trivial.

### Interfaces (behavioral contracts decoupled from implementations)
- `Movement` defines `canMove(Direction)` and `move(Direction)`. `Actor` implements `Movement`, enabling shared movement logic while keeping the API explicit.
- `Item` defines a minimal contract for collectibles (`getName`, `paint`, `getCell`). `Coin` implements `Item`. This allows adding new collectible types later without touching the game loop.
- Benefits: clear contracts make it easy to extend or swap implementations; callers depend on capabilities, not concrete classes.

### Generics (type-safe collections and optional values)
- Collections of domain objects:
  - `List<Actor>` in `Stage` for all actors (iteration and uniform updates)
  - `List<Item>` in `Stage` for coins and future collectibles
  - `List<Polygon>` in `Actor` for a shape-composite rendering approach
- Null-safety and intent via `Optional<Cell>` in `Grid` for location queries (`cellAtColRow`, `cellAtPoint`). This avoids accidental nulls and forces callers to consider absence.
- Benefits: strong typing prevents runtime errors, keeps code readable, and communicates intent (e.g., a cell lookup may not succeed).

## Notable design choices
- Territories by row bands: Cat (rows 0–6), Bird (7–13), Dog (14–19). Enemies cannot enter the Dog’s territory; coins do not spawn in the Dog’s territory or on the winning row.
- Stepwise enemy movement: Each enemy chooses valid directions based on grid/territory bounds, moving 1–3 cells per Dog move.
- Rendering: Each `Actor` holds a `List<Polygon>` for simple, scalable vector shapes without external assets.

## Marking guidance mapping
- Inheritance: `Actor` hierarchy with polymorphic rendering and movement hooks.
- Interfaces: `Movement` for actor movement; `Item` for collectibles.
- Generics: `List<Actor>`, `List<Item>`, `List<Polygon>`, and `Optional<Cell>`.
- Git proficiency: commits are structured by features (movement, input, territories, game state, items, spawning, UI).

## Notes
- The code targets clarity suitable for Week 6: no advanced frameworks or patterns; just core OOP with Java standard library.
