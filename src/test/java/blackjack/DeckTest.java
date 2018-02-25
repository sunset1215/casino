package blackjack;

import org.junit.Assert;
import org.junit.Test;

public class DeckTest {
    
    @Test
    public void testNewDeckSizeIs52() {
        Deck deck = new Deck();
        Assert.assertTrue(deck.size() == 52);
    }
    
    @Test
    public void testDeckDealDecrementCardCount() {
        Deck deck = new Deck();
        deck.deal();
        Assert.assertTrue(deck.size() == 51);
    }
    
    @Test
    public void testShuffle() {
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();
        deck2.shuffle();
        Assert.assertNotEquals(deck1, deck2);
    }
    
    @Test
    public void testNewDecksAreEqual() {
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();
        Assert.assertNotEquals(deck1, deck2);
    }
    
}
