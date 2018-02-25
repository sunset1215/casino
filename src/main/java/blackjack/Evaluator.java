package blackjack;

import enums.Rank;

import java.util.HashMap;
import java.util.Map;

public class Evaluator {
    
    private Map<Rank, Integer> rankValueMap;
    
    public Evaluator() {
        rankValueMap = buildRankValueMap();
    }
    
    private Map<Rank, Integer> buildRankValueMap() {
        Map<Rank, Integer> map = new HashMap<>();
        map.put(Rank.TWO, 2);
        map.put(Rank.THREE, 3);
        map.put(Rank.FOUR, 4);
        map.put(Rank.FIVE, 5);
        map.put(Rank.SIX, 6);
        map.put(Rank.SEVEN, 7);
        map.put(Rank.EIGHT, 8);
        map.put(Rank.NINE, 9);
        map.put(Rank.TEN, 10);
        map.put(Rank.JACK, 10);
        map.put(Rank.QUEEN, 10);
        map.put(Rank.KING, 10);
        map.put(Rank.ACE, 11);
        return map;
    }
    
    public int computeScore(Hand hand) {
        int score = 0;
        for (Card card : hand.getCards()) {
            score += getCardValue(card, hand.size());
        }
        return score;
    }
    
    private int getCardValue(Card card, int handSize) {
        if (card.isAce() && handSize > 2) {
            return 1;
        }
        return rankValueMap.get(card.getRank());
    }
}
