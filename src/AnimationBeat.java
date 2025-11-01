import java.util.ArrayList;
import java.util.List;

public class AnimationBeat implements Beat {
  private long started;
  private long a; // length of phase a
  private long b; // length of phase b
  private long c; // length of phase c

  private List<Pulse> dancers = new ArrayList<>();

  public AnimationBeat() {
    started = System.currentTimeMillis();
    this.a = 5000;
    this.b = 500;
    this.c = 500;
  }

  @Override
  public void punchIn(Pulse member) {
    dancers.add(member);
  }

  @Override
  public void punchOut(Pulse member) {
    dancers.remove(member);
  }

  @Override
  public void ticktock() {
    long currTime = System.currentTimeMillis();
    char phase = inPhase(currTime);
    int percentage = phaseCompletion(currTime);
    for(Pulse o: dancers) {
      o.pulsate(phase, percentage);
    }
  }

  // returns which phase the animation is currently in
  private char inPhase(long currTime) {
    // long currTime = System.currentTimeMillis();
    long rem = (currTime - started) % (a + b + c);
    if (rem > a + b){
      return 'c';
    } else if (rem > a) {
      return 'b';
    } else {
      return 'a';
    }
  }

  // returns a number (out of 100) showing the percentage completion of this phase
  private int phaseCompletion(long currTime) { 
    // long currTime = System.currentTimeMillis();
    long rem = (currTime - started) % (a + b + c);
    if (rem > a + b) {
      return (int) (((rem -a - b) * 100) / c);
    } else if (rem > a) {
      return (int) (((rem - a) * 100) / b);
    } else {
      return (int) (rem * 100 / a);
    }
  }
}
