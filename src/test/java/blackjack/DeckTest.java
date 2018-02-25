package blackjack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DeckTest {
    
    private Deck deck1;
    private Deck deck2;
    
    @Before
    public void setUp() {
        deck1 = new Deck();
        deck2 = new Deck();
    }
    
    @Test
    public void testNewDeckSizeIs52() {
        Assert.assertEquals(52, deck1.size());
    }
    
    @Test
    public void testDeckDealDecrementCardCount() {
        deck1.deal();
        Assert.assertEquals(51, deck1.size());
    }
    
    @Test
    public void testDeckOrderAfterShuffleNotSame() {
        deck2.shuffle();
        Assert.assertFalse(deck1.hasSameOrder(deck2));
    }
    
    @Test
    public void testNewDecksOrderAreSame() {
        Assert.assertTrue(deck1.hasSameOrder(deck2));
    }
    
    @Test
    public void testNewDecksAreDifferent() {
        Assert.assertNotEquals(deck1, deck2);
    }
    
}
