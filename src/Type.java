public enum Type{
    FIRE, WATER, GRASS;

    // Effectiveness: Fire > Grass, Grass > Water, Water > Fire
    public double multiplierAgainst(Type other){
        if(this == FIRE && other == GRASS) return 2.0; // Super effective
        if(this == GRASS && other == WATER) return 2.0;
        if(this == WATER && other == FIRE) return 2.0;
        if(this == FIRE && other == WATER) return 0.5; // Not very effective
        if(this == GRASS && other == FIRE) return 0.5;
        if(this == WATER && other == GRASS) return 0.5;
        return 1.0; // Neutral
    }
}
