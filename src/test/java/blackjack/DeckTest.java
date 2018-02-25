package blackjack;

import org.junit.Assert;
import org.junit.Test;

public class DeckTest {
    
    @Test
    public void testNewDeckSizeIs52() {
        Deck deck = new Deck();
        Assert.assertTrue(deck.size() == 52);
    }
    
}
