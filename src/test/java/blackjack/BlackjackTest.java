package blackjack;

import enums.Result;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BlackjackTest {
    
    private Blackjack game;
    private Hand handMock;
    private Evaluator evaluator;
    
    @Before
    public void setUp() {
        game = new Blackjack();
        evaluator = EasyMock.createStrictMock(Evaluator.class);
        handMock = EasyMock.createNiceMock(Hand.class);
        game.setEvaluator(evaluator);
        game.setPlayerHand(handMock);
        game.setDealerHand(handMock);
    }
    
    @Test
    public void testPlayerBlackjackAndBlackjackWin() {
        expectPlayerAndDealerScore(21, 18);
        replayAssertAndVerify("Player wins", Result.BLACKJACK_WIN);
    }
    
    @Test
    public void testDealerBlackjackAndBlackjackLose() {
        expectPlayerAndDealerScore(18, 21);
        replayAssertAndVerify("Player loses", Result.BLACKJACK_LOSE);
    }

    @Test
    public void testBothBlackjackAndPush() {
        expectPlayerAndDealerScore(21, 21);
        replayAssertAndVerify("Player pushes", Result.PUSH);
    }

    @Test
    public void testPlayerBustAndLose() {
        expectPlayerAndDealerScore(22, 18);
        expectPlayerAndDealerScore(22, 18);
        replayAssertAndVerify("Player bust and lose", Result.LOSE);
    }

    @Test
    public void testDealerBustAndWin() {
        expectPlayerAndDealerScore(18, 22);
        expectPlayerAndDealerScore(18, 22);
        replayAssertAndVerify("Dealer bust and player win", Result.WIN);
    }

    @Test
    public void testBothBustAndPush() {
        expectPlayerAndDealerScore(22, 22);
        expectPlayerAndDealerScore(22, 22);
        replayAssertAndVerify("Both bust and player push", Result.PUSH);
    }
    
    @Test
    public void testPlayerHigherScoreAndWin() {
        expectPlayerAndDealerScore(20, 19);
        expectPlayerAndDealerScore(20, 19);
        replayAssertAndVerify("Player wins", Result.WIN);
    }
    
    @Test
    public void testDealerHigherScoreAndLose() {
        expectPlayerAndDealerScore(19, 20);
        expectPlayerAndDealerScore(19, 20);
        replayAssertAndVerify("Player wins", Result.LOSE);
    }
    
    @Test
    public void testSameScoreAndPush() {
        expectPlayerAndDealerScore(20, 20);
        expectPlayerAndDealerScore(20, 20);
        replayAssertAndVerify("Player push", Result.PUSH);
    }
    
    private void expectPlayerAndDealerScore(int playerScore, int dealerScore) {
        EasyMock.expect(evaluator.computeScore(handMock)).andReturn(playerScore);
        EasyMock.expect(evaluator.computeScore(handMock)).andReturn(dealerScore);
    }
    
    private void replayAssertAndVerify(String message, Result result) {
        EasyMock.replay(evaluator);
        Assert.assertEquals(message, result, game.play());
        EasyMock.verify(evaluator);
    }
    
}
