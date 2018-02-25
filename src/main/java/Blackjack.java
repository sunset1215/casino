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
        if (playerHand.score() > 21) {
            return Result.LOSE;
        }
        
        if (playerHand.score() > dealerHand.score()) {
            return Result.WIN;
        } else if (playerHand.score() < dealerHand.score()) {
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
