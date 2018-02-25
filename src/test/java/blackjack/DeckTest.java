package blackjack;

import org.junit.Assert;
import org.junit.Test;

public class DeckTest {
    
    @Test
    public void testNewDeckSizeIs52() {
        Deck deck = new Deck();
        Assert.assertEquals(52, deck.size());
    }
    
    @Test
    public void testDeckDealDecrementCardCount() {
        Deck deck = new Deck();
        deck.deal();
        Assert.assertEquals(51, deck.size());
    }
    
    @Test
    public void testDeckOrderAfterShuffleNotSame() {
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();
        deck2.shuffle();
        Assert.assertFalse(deck1.hasSameOrder(deck2));
    }
    
    @Test
    public void testNewDecksOrderAreSame() {
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();
        Assert.assertTrue(deck1.hasSameOrder(deck2));
    }
    
    @Test
    public void testNewDecksAreDifferent() {
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();
        Assert.assertNotEquals(deck1, deck2);
    }
    
}
