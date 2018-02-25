package utils;

import blackjack.Card;
import blackjack.Hand;
import enums.Rank;
import enums.Suit;

public class HandFactory {
    
    public static Hand createHandWithBlackjack() {
        Hand hand = new Hand();
        hand.draw(new Card(Suit.SPADE, Rank.ACE));
        hand.draw(new Card(Suit.SPADE, Rank.KING));
        return hand;
    }
    
    public static Hand createHandWithScore18() {
        Hand hand = new Hand();
        hand.draw(new Card(Suit.SPADE, Rank.EIGHT));
        hand.draw(new Card(Suit.SPADE, Rank.KING));
        return hand;
    }
}
