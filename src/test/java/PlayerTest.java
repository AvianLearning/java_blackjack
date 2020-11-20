import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    Player playerOne;
    Player playerTwo;
    Card card;

    @Before
    public void before() {
        playerOne = new Player("Andrew");
        playerTwo = new Player("Iain");
        card = new Card(CardSuit.SPADES, CardRank.ACE);
    }

    @Test
    public void playerHasName() {
        assertEquals("Iain", playerTwo.getName());
    }


}
