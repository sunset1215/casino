package blackjack;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;

public class HandTest {
    
    @Test
    public void testDraw() {
        Hand hand = new Hand();
        Assert.assertEquals(0, hand.size());
        hand.draw(EasyMock.anyObject(Card.class));
        Assert.assertEquals(1, hand.size());
    }
}
