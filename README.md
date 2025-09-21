# Welcome to COMP2000 - Object Oriented Programming Practices
## Session 2, 2025

Assignment 2 ReadMe

Idea: Adapting the grid into a simple Pokemon-themed battle. Each actor on the grid will be a Pokemon with a type, e.g. Fire, Water, or Grass. The types interact with eachother in a straightforward way (similiar to paper scissors rock), where one has an advantage over another, and a disadvantage to the other. Players can choose Pokemon and try to pick the most effective type against an opponent that appears on the grid. To make it more interesting, opponents can place barriers that affect how battles play out, the focus remains on keeping the design simple and capable of being expanded on later.

Changes

- Replaced paint with paintComponent, and utilised super.paintComponent(g) to clear background correctly, this combination prevents artefacts and flickers.
- Removed run() method, replaced by Timer, which drives repainting instead of a while loop, calling every ~33ms, i.e. 30 frames per second. Reduces CPU usage from 100%.
- Utilised MouseMotionListener and MouseListener to update mousePos, and replaced getMousePosition() call with a stored value. Making tracking smoother and avoids null errors.