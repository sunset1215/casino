package blackjack;

import enums.Rank;
import enums.Suit;
import org.junit.Assert;
import org.junit.Test;

public class CardTest {
    
    @Test
    public void testCardWithSameSuitAndRankAreEqual() {
        Card c1 = new Card(Suit.DIAMONDS, Rank.ACE);
        Card c2 = new Card(Suit.DIAMONDS, Rank.ACE);
        Assert.assertEquals(c1, c2);
    }
    
    @Test
    public void testCardWithSameSuitAndDifferentRankAreNotEqual() {
        Card c1 = new Card(Suit.DIAMONDS, Rank.ACE);
        Card c2 = new Card(Suit.DIAMONDS, Rank.KING);
        Assert.assertNotEquals(c1, c2);
    }
    
    @Test
    public void testCardWithDifferentSuitAndRankAreNotEqual() {
        Card c1 = new Card(Suit.DIAMONDS, Rank.ACE);
        Card c2 = new Card(Suit.HEARTS, Rank.KING);
        Assert.assertNotEquals(c1, c2);
    }
    
}
