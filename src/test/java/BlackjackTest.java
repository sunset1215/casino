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
    public void testPlayerBlackjackWin() {
        game.setPlayerHand(new Hand(10, 11));
        game.setDealerHand(new Hand(10, 9));
        Assert.assertEquals("Player wins", Blackjack.Result.WIN, game.play());
    }
    
    @Test
    public void testDealerBlackjackPlayerLose() {
        game.setPlayerHand(new Hand(10, 9));
        game.setDealerHand(new Hand(10, 11));
        Assert.assertEquals("Player loses", Blackjack.Result.LOSE, game.play());
    }


}
