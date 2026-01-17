## Week 2 Application Exercise

### Task 1

Clone this repository (well done!)

### Task 2

The repository you just cloned is a VSCode project, so lets work with it.  It currently will print "Red vs. Blue" message to the console when run.

You will find "Run" and "Debug" commands over the `main` method.  Try them out.  You can also trigger them with `F5` for "Debug" and `Ctrl-F5` for "Run"

Modify the application so that instead it prints

~~~~~
COMP2000 2025
~~~~~

## Week 3 Application Exercise

### Task 3

Draw a 20 by 20 grid on a 720x720 window.  Each cell in the grid should be 35 pixels high and wide and the grid should be drawn 10 pixels off the top and left borders of the screen.  To do this, you should use the `Graphics` class from the Java libraries.  Be sure to consult the tips video for this task (it is a link in iLearn).  Without it, you will be very confused.

### Task 4

The "grid" has no identity - it is just drawn.  Later on we will need to do lots of things "with" this grid.  We will modify it and adjust it and ask it questions.  Our task here is to refactor the program to give this grid an identity.  We will create an object to represent the grid and will give that object its own `paint` method for drawing the grid.

We will also need to give an identity to each "cell" of the grid and make each cell responsible for it's own painting to the screen.

Modify the program to make these things happen.  Make a `Grid` class and a `Cell` class and organise them in a sensible way.  What fields and methods should each class have?

### Task 5

Anything that is a `JFrame` or `JPanel` can find out the position of the mouse using `getMousePosition`.  Modify your program so that mousing over a cell will "highlight" it.  Highlighted cells should be drawn in grey.  You may have to think about how you will get the mouse position from the place you can read it, to the place it is needed (the `paint` method of a `Cell` object).

## Week 4 Application Exercise

This week we will add characters to the game.  There are three different characters (cat, dog, and bird) and each looks different when drawn to the grid.  Your task is to design a few new classes/objects to best achieve this outcome.  Inheritance is likely to play a big role in a good design which can grow as the program grows.  To keep things simple, each character can just be a different colour - you don't need sprites for them.  The file `doc/4_goal.png` is a screenshot of my solution running but the real value is in the design that was done to achieve this outcome. During the synchronous reporting, each team will put up a UML diagram as well as showing off their code in action.

Your team should go about this task any way you like but we have added a breakdown of how _we_ went about it below as a guide.  We prefer you don't follow the guide, but it is there if you need it.  Note that the solutions we publish will follow this guide.  Our guide is structured as hints for the next 4 tasks towards one of the solutions.  I.e. _tasks 6-9 are not your goal for this class, but they are possible tasks you might do to achieve this week's goal.

### Task 6

Our `Cell` class is really a specialised rectangle and the Java API already has a `Rectangle` class.  Have `Cell` inherit from `java.awt.Rectangle` (https://docs.oracle.com/en/java/javase/21/docs/api/java.desktop/java/awt/Rectangle.html).  It will be good to call `super` in the `Cell` constructor and to use the `contains` method that comes in `Rectangle` instead of your own.  NB:  The `contains` we wrote was graceful when given a `null` pointer for the point, the one from `Rectangle` is not, you will need to "protect" it in some way.

### Task 7

Define a `Stage` class that can contain one `Grid` object and many `Actor` objects.  There must be three separate actors, each a subclass of an `Actor` superclass and each must have its own `paint` method.  The `paint` method must take a `Graphics` parameter and draw the actor on that graphic.  Have the `paint` method specified in the `Actor` class and have each subclass define it.

Since `Actors`s are drawing themselves, they need to know where they are on the screen so each will have a `Cell` field (that is set in the constructor) indicating where on the grid they are.

Have the program start with 1 grid and 3 actors:

  * Cat (drawn blue)
  * Dog (drawn yellow)
  * Bird (drawn green)

You can place each of these three `Actor` objects in grid locations of your choosing.

### Task 8

Have a close look at your `Cat`, `Dog` and `Bird` classes.  If they are anything like mine they are _all the same except for the colour they use_.  This repetition is "a bad thing" because if the same thing is done in three different places, we need to remember that updating one requires us to update all three.

Is there a place that you could put all the common parts?

🤔 Will this work given what you currently have?  If not, what would we need to change?

### Task 9

Draw a picture of the inheritance hierarchy you have created.  You should (loosely) use [UML notation](http://umich.edu/~eecs381/handouts/UMLNotationSummary.pdf) for your diagram.  You are using UML In this case, and all through this course, only for "a rough sketch of an idea".

## Week 5 Application Exercise

Your team's task this week is to find the _most sensible and useful way to incorporate generics_ into the program you have at this point.  It will be worth making sure your team's code is all up to date so you have the most to work with.  You can take any approach you want and use the generics for any task you want.  Keep in mind what generics are good at in your considerations because we will be asking ourselves which teams had the most useful generics.

We have provided a possible sensible path via Tasks 10, 11, and 12 if your team wants some direction to head in.

### Task 10

Did you notice the repetition in the stage paint method?  All three actors have the `paint` method called on them.  In fact, we might later want to have dozens of actors on the stage at any one time, we don't want dozens of calls to `someone.paint(g);`.  What we need is a collection to store all the actors, something like an array that we can put them all in.  Then we can just loop over that array and call  `paint` on every element.  _I think_ we should use an `ArrayList` (https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/ArrayList.html).  Notice it is a generic collection?  You will need to use generics to make this work.  Put all the actors in a single array list called `actors` and then loop over this list to paint them.  Once you have done that you might like to add more actors to the stage.

🤔 In my solution, I will declare the actors list as a `List` instead of an `ArrayList`.  Any idea why?  Why does this even work?

### Task 11

Turns out you are not able to use colours to distinguish the different types of actors!  You are going to need to draw little shapes to represent them.  You have been told you can't use images, you have to draw with Java2D primitives so the game can scale up and down as required.  The `Graphics` objects we are painting on know how to draw `Polygon`s (https://docs.oracle.com/en/java/javase/21/docs/api/java.desktop/java/awt/Polygon.html) so that is what we are going to use.  However, one polygon is not enough for each actor, we need each to be made of a list of polygons.  We will use `ArrayList` again!  Have the `Color` field of `Actor` changed to a list of polygons and initialise each subclass to an appropriate set of polygons.  You might find the following polygons a useful starting point where `location` is the top-left point of the actor (but I am sure you can do better as well - share your designs on the forums!):

#### Cat

~~~~~
    Polygon ear1 = new Polygon();
    ear1.addPoint(loc.x + 11, loc.y + 5);
    ear1.addPoint(loc.x + 15, loc.y + 15);
    ear1.addPoint(loc.x + 7, loc.y + 15);
    Polygon ear2 = new Polygon();
    ear2.addPoint(loc.x + 22, loc.y + 5);
    ear2.addPoint(loc.x + 26, loc.y + 15);
    ear2.addPoint(loc.x + 18, loc.y + 15);
    Polygon face = new Polygon();
    face.addPoint(loc.x + 5, loc.y + 15);
    face.addPoint(loc.x + 29, loc.y + 15);
    face.addPoint(loc.x + 17, loc.y + 30);
~~~~~

#### Dog

~~~~~
    Polygon ear1 = new Polygon();
    ear1.addPoint(loc.x + 5, loc.y + 5);
    ear1.addPoint(loc.x + 15, loc.y + 5);
    ear1.addPoint(loc.x + 5, loc.y + 15);
    Polygon ear2 = new Polygon();
    ear2.addPoint(loc.x + 20, loc.y + 5);
    ear2.addPoint(loc.x + 30, loc.y + 5);
    ear2.addPoint(loc.x + 30, loc.y + 15);
    Polygon face = new Polygon();
    face.addPoint(loc.x + 8, loc.y + 7);
    face.addPoint(loc.x + 27, loc.y + 7);
    face.addPoint(loc.x + 27, loc.y + 25);
    face.addPoint(loc.x + 8, loc.y + 25);
~~~~~

#### Bird

~~~~~
    Polygon wing1 = new Polygon();
    wing1.addPoint(loc.x + 5, loc.y + 5);
    wing1.addPoint(loc.x + 15, loc.y + 17);
    wing1.addPoint(loc.x + 5, loc.y + 17);
    Polygon wing2 = new Polygon();
    wing2.addPoint(loc.x + 30, loc.y + 5);
    wing2.addPoint(loc.x + 20, loc.y + 17);
    wing2.addPoint(loc.x + 30, loc.y + 17);
    Polygon body = new Polygon();
    body.addPoint(loc.x + 15, loc.y + 10);
    body.addPoint(loc.x + 20, loc.y + 10);
    body.addPoint(loc.x + 20, loc.y + 25);
    body.addPoint(loc.x + 15, loc.y + 25);
~~~~~

### Task 12

In this task we will add a method to the grid class that returns whatever cell is under a particular location.

Such a method needs to take in a `Point` and return back a `Cell`.  It will do a simple calculation to turn the x and y coordinates into the right array indices and look them up.

However, there are some areas on our stage where there are no cells, not to mention what to do when a `null` point is passed in!

So, we need a method that _might_ return a `Cell`.  What should it do when it can't find a cell?  Return `null`?  Definitely not!!!!  You are just asking for a asking for null-pointer exception if you do that.  Instead, we will use the `Optional` generic container (https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Optional.html).  

Add the following method to `Grid` that will return whatever cell is located around the point that is passed in.

~~~~~
public Optional<Cell> cellAtPoint(Point p)
~~~~~

🤔 How about we improve the `cellAtColRow` method now we know about optional containers?

🤔 Now that we have `cellAtPoint`, lets use it.  Grow the app window to 1024x720 so we have some clear space to the right of the grid.  In this space, put the details of whatever cell we are hoving over.  For example, you might put the type of cell that is located there, and what it's elevation is.  There are many ways to do this, but one good way is to call `cellAtPoint` while painting the stage and use the resulting cell information.