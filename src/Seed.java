public class Seed implements Item {
    @Override public String name() { return "Seed"; }
    @Override public void apply(Actor actor) {
        if (actor instanceof Bird) actor.boostEnergy(2);
    }
}
