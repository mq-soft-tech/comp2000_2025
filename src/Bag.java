import java.util.*;

public class Bag <T extends Item> {
    private final List<T> items = new ArrayList<>();
    public void add(T t){ items.add(t); }
    public boolean isEmpty(){ return items.isEmpty(); }
    public List<T> view(){ return Collections.unmodifiableList(items); }
    public void clear() { items.clear(); }

}


