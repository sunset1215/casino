package blackjack;

import enums.Rank;
import enums.Suit;

import java.util.Objects;

public class Card {
    
    private Suit suit;
    private Rank rank;
    
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }
    
    public Suit getSuit() {
        return suit;
    }
    
    public Rank getRank() {
        return rank;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Card)) return false;
        
        Card card = (Card) o;
        return suit == card.getSuit()
                && rank == card.getRank();
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(suit, rank);
    }
    
    public boolean isAce() {
        return rank.equals(Rank.ACE);
    }
}
