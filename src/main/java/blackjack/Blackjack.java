package blackjack;

public class Blackjack {
    
    private Hand playerHand;
    private Hand dealerHand;
    private Evaluator evaluator;
    
    public void setPlayerHand(Hand playerHand) {
        this.playerHand = playerHand;
    }
    
    public void setDealerHand(Hand dealerHand) {
        this.dealerHand = dealerHand;
    }
    
    public void setEvaluator(Evaluator evaluator) {
        this.evaluator = evaluator;
    }
    
    public Result play() {
        int playerScore = evaluator.computeScore(playerHand);
        int dealerScore = evaluator.computeScore(dealerHand);

        if (dealerScore > 21 && playerScore > 21) {
            return Result.KEEP;
        } else if (playerScore > 21) {
            return Result.LOSE;
        } else if (dealerScore > 21) {
            return Result.WIN;
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
        KEEP,
        PUSH
    }
}
