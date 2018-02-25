import org.junit.Assert;
import org.junit.Test;

public class BlackjackTest {
    
    @Test
    public void testPlayerBlackjackWin() {
        BlackJack game = new BlackJack();
        Hand playerHand = new Hand(10, 11);
        Hand dealerHand = new Hand(10, 9);
        game.setPlayerHand(playerHand);
        game.setDealerHand(dealerHand);
        Assert.assertEquals("Player wins", Blackjack.Result.WIN, game.play());
    }


}
