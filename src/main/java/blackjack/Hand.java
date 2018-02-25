package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    
    private List<Card> cards;
    
    public Hand() {
        cards = new ArrayList<>(13);
    }
    
    public void draw(Card card) {
        cards.add(card);
    }
    
    public int size() {
        return cards.size();
    }
}
