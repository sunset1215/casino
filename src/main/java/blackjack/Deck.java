package blackjack;

import enums.Rank;
import enums.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    
    private List<Card> cards;
    
    public Deck() {
        cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }
    
    public int size() {
        return cards.size();
    }
    
    public Card deal() {
        return cards.remove(0);
    }
    
    public void shuffle() {
        Collections.shuffle(cards);
    }
    
    public boolean hasSameOrder(Deck d) {
        return cards.equals(d.cards);
    }
}
