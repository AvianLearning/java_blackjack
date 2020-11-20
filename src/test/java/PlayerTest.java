import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    Player playerOne;
    Player playerTwo;
    Card card;
    Card cardTwo;

    @Before
    public void before() {
        playerOne = new Player("Andrew");
        playerTwo = new Player("Iain");
        card = new Card(CardSuit.SPADES, CardRank.ACE);
        cardTwo = new Card(CardSuit.DIAMONDS, CardRank.KING);
    }

    @Test
    public void playerHasName() {
        assertEquals("Iain", playerTwo.getName());
    }

    @Test
    public void playerStartsWithEmptyHand() {
        assertEquals(0, playerOne.cardCount());
    }

    @Test
    public void playerCanTakeCard() {
        playerOne.takeCard(card);
        assertEquals(1, playerOne.cardCount());
    }

    @Test
    public void playerHasHandTotal() {
        playerOne.takeCard(card);
        playerOne.takeCard(cardTwo);
        assertEquals(11, playerOne.handTotal());
    }
}
