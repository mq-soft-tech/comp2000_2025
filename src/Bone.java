public class Bone implements Item {
    public void apply(Actor a){ if (a instanceof Dog) a.boostEnergy(2); }
    public String name(){ return "Bone"; }
}
