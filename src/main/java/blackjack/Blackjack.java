package blackjack;

import enums.Result;
import org.junit.Assert;

public class Blackjack {
    
    public static final int MAX = 21;
    
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
        Result result;
    
        int playerScore = evaluator.computeScore(playerHand);
        int dealerScore = evaluator.computeScore(dealerHand);
        
        result = handleBlackjackScenarios(playerScore, dealerScore);
        if (result != null) return result;
        
        playerScore = evaluator.computeScore(playerHand);
        dealerScore = evaluator.computeScore(dealerHand);
        
        result = handleBustScenarios(playerScore, dealerScore);
        if (result != null) return result;
        
        result = handleNoBustScenarios(playerScore, dealerScore);
        Assert.assertTrue(result != null);
        return result;
    }
    
    private Result handleNoBustScenarios(int playerScore, int dealerScore) {
        if (playerScore > dealerScore) {
            return Result.WIN;
        } else if (playerScore < dealerScore) {
            return Result.LOSE;
        } else {
            return Result.PUSH;
        }
    }
    
    private Result handleBustScenarios(int playerScore, int dealerScore) {
        if (dealerScore > MAX && playerScore > MAX) {
            return Result.PUSH;
        } else if (playerScore > MAX) {
            return Result.LOSE;
        } else if (dealerScore > MAX) {
            return Result.WIN;
        } else {
            return null;
        }
    }
    
    private Result handleBlackjackScenarios(int playerScore, int dealerScore) {
        if (playerScore == MAX && dealerScore == MAX) {
            return Result.PUSH;
        } else if (playerScore == MAX) {
            return Result.BLACKJACK_WIN;
        } else if (dealerScore == MAX) {
            return Result.BLACKJACK_LOSE;
        } else {
            return null;
        }
    }
    
}
