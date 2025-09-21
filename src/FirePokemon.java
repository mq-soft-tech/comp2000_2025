import java.awt.Color;
import java.awt.Polygon;
import java.util.ArrayList;

public class FirePokemon extends Pokemon {
    public FirePokemon(Cell loc){
        super(loc, "Slugma", 100, Type.FIRE); // Example fire-type Pokemon
        this.color = Color.RED; 

        display = new ArrayList<>();
        Polygon body = new Polygon();
        body.addPoint(loc.x + 5, loc.y + 5);
        body.addPoint(loc.x + 30, loc.y + 5);
        body.addPoint(loc.x + 30, loc.y + 30);
        body.addPoint(loc.x + 5, loc.y + 30);
        display.add(body);
    }
}
