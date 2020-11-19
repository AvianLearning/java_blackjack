import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardTest {

    Card card1;

    @Before
    public void before() {
        card1 = new Card(CardSuit.CLUBS, CardRank.ACE);
    }

    @Test
    public void canGetSuit() {
        assertEquals(CardSuit.CLUBS, card1.getSuit());
    }

    @Test
    public void canGetRank() {
        assertEquals(CardRank.ACE, card1.getRank());
    }

    @Test
    public void canGetValueRank() {
    assertEquals(1, card1.getValueRank());
    }
}
