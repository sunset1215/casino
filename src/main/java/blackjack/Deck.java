package blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    
    private List<Integer> cards;
    
    public Deck() {
        cards = new ArrayList<>();
        for (int i = 0; i < 52; i++) {
            cards.add(i);
        }
    }
    
    public int size() {
        return cards.size();
    }
    
    public Integer deal() {
        return cards.remove(0);
    }
    
    public void shuffle() {
        Collections.shuffle(cards);
    }
}
