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
        return Result.WIN;
    }
    
    public enum Result {
        WIN,
        LOSE,
        PUSH
    }
}
