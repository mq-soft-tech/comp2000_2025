import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Group<T extends Actor> {
  private final List<T> list = new ArrayList<>();
  public void add(T a){ list.add(a); }
  public void paintAll(Graphics g){ for (T a : list) a.paint(g); }
  public List<T> asList(){ return List.copyOf(list); }
}
