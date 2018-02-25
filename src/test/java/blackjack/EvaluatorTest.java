package blackjack;

import enums.Rank;
import enums.Suit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EvaluatorTest {
    
    private static Evaluator evaluator;
    private Hand hand;
    
    @BeforeClass
    public static void initEvaluator() {
        evaluator = new Evaluator();
    }
    
    @Before
    public void setUp() {
        hand = new Hand();
    }
    
    @Test
    public void testComputeScoreBlackjackReturn21() {
        hand.draw(createSpadesCard(Rank.ACE));
        hand.draw(createSpadesCard(Rank.KING));
        Assert.assertEquals(21, evaluator.computeScore(hand));
    }
    
    @Test
    public void testComputeScoreFaceAndNumberCard() {
        hand.draw(createSpadesCard(Rank.EIGHT));
        hand.draw(createSpadesCard(Rank.KING));
        Assert.assertEquals(18, evaluator.computeScore(hand));
    }
    
    @Test
    public void testComputeScoreAceValueIsOneWhenHandCountMoreThanTwo() {
        hand.draw(createSpadesCard(Rank.ACE));
        hand.draw(createSpadesCard(Rank.EIGHT));
        hand.draw(createSpadesCard(Rank.KING));
        Assert.assertEquals(19, evaluator.computeScore(hand));
    }
    
    private Card createSpadesCard(Rank rank) {
        return new Card(Suit.SPADES, rank);
    }
}
