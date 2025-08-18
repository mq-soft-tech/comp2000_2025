import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Stage {
    Grid GridA;

    Actor cat;
    Actor bird;
    Actor dog;

    public Stage(){
        GridA = new Grid();
        cat = new Cat();
        bird = new Bird();
        dog = new Dog();
    }

    public void paint(Point mousePos){

    }

}
