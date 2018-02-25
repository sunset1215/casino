package blackjack;

public class Blackjack {
    
    private Hand playerHand;
    private Hand dealerHand;
    
    public void setPlayerHand(Hand playerHand) {
        this.playerHand = playerHand;
    }
    
    public void setDealerHand(Hand dealerHand) {
        this.dealerHand = dealerHand;
    }
    
    public Result play() {
        int playerScore = playerHand.score();
        int dealerScore = dealerHand.score();
        
        if (playerScore > 21) {
            return Result.LOSE;
        }
        
        if (playerScore > dealerScore) {
            return Result.WIN;
        } else if (playerScore < dealerScore) {
            return Result.LOSE;
        } else {
            return Result.PUSH;
        }
    }
    
    public enum Result {
        WIN,
        LOSE,
        PUSH
    }
}
