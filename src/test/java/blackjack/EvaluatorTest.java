package blackjack;

import enums.Rank;
import enums.Suit;
import org.junit.Assert;
import org.junit.Test;

public class EvaluatorTest {
    
    @Test
    public void testComputeScoreBlackjackReturn21() {
        Hand hand = new Hand();
        hand.draw(createSpadesCard(Rank.ACE));
        hand.draw(createSpadesCard(Rank.KING));
        Evaluator evaluator = new Evaluator();
        Assert.assertEquals(21, evaluator.computeScore(hand));
    }
    
    @Test
    public void testComputeScoreFaceAndNumberCard() {
        Hand hand = new Hand();
        hand.draw(createSpadesCard(Rank.EIGHT));
        hand.draw(createSpadesCard(Rank.KING));
        Evaluator evaluator = new Evaluator();
        Assert.assertEquals(18, evaluator.computeScore(hand));
    }
    
    @Test
    public void testComputeScoreAceValueIsOneWhenHandCountMoreThanTwo() {
        Hand hand = new Hand();
        hand.draw(createSpadesCard(Rank.ACE));
        hand.draw(createSpadesCard(Rank.EIGHT));
        hand.draw(createSpadesCard(Rank.KING));
        Evaluator evaluator = new Evaluator();
        Assert.assertEquals(19, evaluator.computeScore(hand));
    }
    
    private Card createSpadesCard(Rank rank) {
        return new Card(Suit.SPADES, rank);
    }
}
