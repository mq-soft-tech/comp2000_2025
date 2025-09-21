public class Pokemon extends Actor {
    String name;
    int hp;
    Type type;

    public Pokemon(Cell loc, String name, int hp, Type type) {
        this.loc = loc;
        this.name = name;
        this.hp = hp;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Type getType() {
        return type;
    }
}
