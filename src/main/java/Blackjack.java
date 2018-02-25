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
        if (playerHand.score() > dealerHand.score()) {
            return Result.WIN;
        } else {
            return Result.LOSE;
        }
        
    }
    
    public enum Result {
        WIN,
        LOSE,
        PUSH
    }
}
