public class Fish implements Item {
    public void apply(Actor a){ if (a instanceof Cat) a.boostEnergy(2); }
    public String name(){ return "Fish"; }
}
