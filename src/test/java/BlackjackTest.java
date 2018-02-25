import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BlackjackTest {
    
    Blackjack game;
    
    @Before
    public void setUp() {
        game = new Blackjack();
    }
    
    @Test
    public void testPlayerBlackjackAndWin() {
        game.setPlayerHand(new Hand(10, 11));
        game.setDealerHand(new Hand(10, 9));
        Assert.assertEquals("Player wins", Blackjack.Result.WIN, game.play());
    }
    
    @Test
    public void testDealerBlackjackAndLose() {
        game.setPlayerHand(new Hand(10, 9));
        game.setDealerHand(new Hand(10, 11));
        Assert.assertEquals("Player loses", Blackjack.Result.LOSE, game.play());
    }
    
    @Test
    public void testBothBlackjackAndPush() {
        game.setPlayerHand(new Hand(10, 11));
        game.setDealerHand(new Hand(10, 11));
        Assert.assertEquals("Player pushes", Blackjack.Result.PUSH, game.play());
    }
    
    @Test
    public void testPlayerExceedAndLose() {
        Hand playerHand = new Hand(10, 2);
        playerHand.draw(10);
        game.setPlayerHand(playerHand);
        game.setDealerHand(new Hand(10, 11));
        Assert.assertEquals("Player exceed and lose", Blackjack.Result.LOSE, game.play());
    }

}
