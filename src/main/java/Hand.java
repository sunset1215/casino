import java.util.ArrayList;
import java.util.List;

public class Hand {
    
    List<Integer> cards;
    
    public Hand(int c1, int c2) {
        cards = new ArrayList<>();
        cards.add(c1);
        cards.add(c2);
    }
    
    public int score() {
        return cards.stream().reduce(Integer::sum).get();
    }
}
