package blackjack;

import org.junit.Assert;
import org.junit.Test;

public class CardTest {
    
    @Test
    public void testCardWithSameSuitAndRankAreEqual() {
        Card c1 = new Card(Suit.DIAMONDS, Rank.ACE);
        Card c2 = new Card(Suit.DIAMONDS, Rank.ACE);
        Assert.assertEquals(c1, c2);
    }
}
