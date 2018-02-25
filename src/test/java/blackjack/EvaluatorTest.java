package blackjack;

import org.junit.Assert;
import org.junit.Test;
import utils.HandFactory;

public class EvaluatorTest {
    
    @Test
    public void testComputeScoreBlackjackReturn21() {
        Hand bj = HandFactory.createHandWithBlackjack();
        Evaluator evaluator = new Evaluator();
        Assert.assertEquals(21, evaluator.computeScore(bj));
    }
}
