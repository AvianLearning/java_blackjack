import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    Player playerOne;
    Player playerTwo;
    Card cardOne;

    @Before
    public void before() {
        playerOne = new Player("Andrew");
        playerTwo = new Player("Iain");
    }

    @Test
    public void playerCanGetHand() {
        playerOne.setHand(cardOne);
        assertEquals(cardOne, playerOne.getHand());
    }
}
