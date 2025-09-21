# Welcome to COMP2000 - Object Oriented Programming Practices
## Session 2, 2025

Please ensure that you follow the weekly updates in this repository

You are free to clone this repository into your own hosted git environment, such as Github, Bitbucket, or Gitlab.

*However*, please be aware that any repository containing your assignment code **must** be made private. Any repository with assignment code that is public available, or found to be shared with other students, will be considered a violation of the academic integrity policy.

This lesson extends the week 5 practice by:

Adding terrain to each square: GRASS, WATER, SAND, MOUNTAIN (different colors).

Movement rules: Bird (implements Flier) can go through WATER and MOUNTAIN; Dog/Cat is blocked.

Adding simple objects (Items) spread on the grid: Bone (Dog uses), Fish (Cat uses), Seed (Bird uses). When entering a square with items, the Actor picks them up and +energy.

(Small) Move cost: entering SAND costs 1 energy (to show more terrain rules).

Inheritance

TerrainCell extends Cell: extend cell behavior (isPassableBy travel rule, moveCost cost, drawing method) without modifying the original Cell → reduce scattered if-else, easy to extend more terrain.

Interfaces

Flier (marker) attached to Bird: express clear ability, avoid stuffing properties into common Actor.

Item defines apply(Actor): is a contract for all objects. Thanks to that, adding Cheese, Worm… just need to create a new class implementing Item.

Generics (custom class)

Bag<T extends Item>: a class created by students, contains type-safe items, does not depend on List<Item> directly.