import java.awt.Color;
import java.awt.Polygon;
import java.util.ArrayList;

public class GrassPokemon extends Pokemon {
    public GrassPokemon(Cell loc){
        super(loc, "Sprigatito", 100, Type.GRASS); // Example grass-type Pokemon
        this.color = Color.GREEN; 

        display = new ArrayList<>();
        Polygon body = new Polygon();
        body.addPoint(loc.x + 5, loc.y + 5);
        body.addPoint(loc.x + 30, loc.y + 5);
        body.addPoint(loc.x + 30, loc.y + 30);
        body.addPoint(loc.x + 5, loc.y + 30);
        display.add(body);
    }
}
