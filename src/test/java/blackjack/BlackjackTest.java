package blackjack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BlackjackTest {
    
    private Blackjack game;
    
    @Before
    public void setUp() {
        game = new Blackjack();
    }
    
    @Test
    public void testPlayerBlackjackAndWin() {
        game.setPlayerHand(createBlackjackHand());
        game.setDealerHand(new Hand(10, 9));
        Assert.assertEquals("Player wins", Blackjack.Result.WIN, game.play());
    }
    
    @Test
    public void testDealerBlackjackAndLose() {
        game.setPlayerHand(new Hand(10, 9));
        game.setDealerHand(createBlackjackHand());
        Assert.assertEquals("Player loses", Blackjack.Result.LOSE, game.play());
    }
    
    @Test
    public void testBothBlackjackAndPush() {
        game.setPlayerHand(createBlackjackHand());
        game.setDealerHand(createBlackjackHand());
        Assert.assertEquals("Player pushes", Blackjack.Result.PUSH, game.play());
    }
    
    @Test
    public void testPlayerExceedAndLose() {
        Hand playerHand = new Hand(10, 2);
        playerHand.draw(10);
        game.setPlayerHand(playerHand);
        game.setDealerHand(createBlackjackHand());
        Assert.assertEquals("Player exceed and lose", Blackjack.Result.LOSE, game.play());
    }
    
    private Hand createBlackjackHand() {
        return new Hand(10, 11);
    }

}
