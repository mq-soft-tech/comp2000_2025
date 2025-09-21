import java.awt.Color;
import java.awt.Polygon;
import java.util.ArrayList;

public class WaterPokemon extends Pokemon {
    public WaterPokemon(Cell loc){
        super(loc, "Oshawott", 100, Type.WATER); // Example water-type Pokemon
        this.color = Color.BLUE; 

        display = new ArrayList<>();
        Polygon body = new Polygon();
        body.addPoint(loc.x + 5, loc.y + 5);
        body.addPoint(loc.x + 30, loc.y + 5);
        body.addPoint(loc.x + 30, loc.y + 30);
        body.addPoint(loc.x + 5, loc.y + 30);
        display.add(body);
    }
}
