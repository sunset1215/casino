package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    
    private List<Integer> cards;
    
    public Hand() {
        cards = new ArrayList<>(13);
    }
    
    public Hand(int c1, int c2) {
        cards = new ArrayList<>(13);
        cards.add(c1);
        cards.add(c2);
    }
    
    public int score() {
        return cards.stream().reduce(Integer::sum).get();
    }
    
    public void draw(int card) {
        cards.add(card);
    }
}
