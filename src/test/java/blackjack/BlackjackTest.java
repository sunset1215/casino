package blackjack;

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
    public void testPlayerBlackjackAndWin() {
        expectPlayerScore(21);
        expectDealerScore(18);
        EasyMock.replay(evaluator);
        Assert.assertEquals("Player wins", Blackjack.Result.WIN, game.play());
        EasyMock.verify(evaluator);
    }

//    @Test
//    public void testDealerBlackjackAndLose() {
//        game.setPlayerHand(new Hand(10, 9));
//        game.setDealerHand(createBlackjackHand());
//        Assert.assertEquals("Player loses", Blackjack.Result.LOSE, game.play());
//    }
//
//    @Test
//    public void testBothBlackjackAndPush() {
//        game.setPlayerHand(createBlackjackHand());
//        game.setDealerHand(createBlackjackHand());
//        Assert.assertEquals("Player pushes", Blackjack.Result.PUSH, game.play());
//    }
//
//    @Test
//    public void testPlayerExceedAndLose() {
//        Hand playerHand = new Hand(10, 2);
//        playerHand.draw(10);
//        game.setPlayerHand(playerHand);
//        game.setDealerHand(createBlackjackHand());
//        Assert.assertEquals("Player exceed and lose", Blackjack.Result.LOSE, game.play());
//    }
//
//    @Test
//    public void testDealerExceedAndWin() {
//        Hand dealerHand = new Hand(10, 2);
//        dealerHand.draw(10);
//        game.setPlayerHand(createBlackjackHand());
//        game.setDealerHand(dealerHand);
//        Assert.assertEquals("Dealer exceed and player win", Blackjack.Result.WIN, game.play());
//    }
//
//    @Test
//    public void testBothExceedAndKeep() {
//        Hand dealerHand = new Hand(10, 2);
//        dealerHand.draw(10);
//        Hand playerHand = new Hand(10, 2);
//        playerHand.draw(10);
//        game.setPlayerHand(playerHand);
//        game.setDealerHand(dealerHand);
//        Assert.assertEquals("Both exceed and player keep", Blackjack.Result.KEEP, game.play());
//    }
//
//    private Hand createBlackjackHand() {
//        return new Hand(10, 11);
//    }
    
    
    private void expectPlayerScore(int score) {
        EasyMock.expect(evaluator.computeScore(handMock)).andReturn(score);
    }
    
    private void expectDealerScore(int score) {
        EasyMock.expect(evaluator.computeScore(handMock)).andReturn(score);
    }

}
