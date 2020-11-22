import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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
        assertEquals(21, playerOne.handTotal());
        assertEquals(2, playerOne.cardCount());
    }

    @Test
    public void canCountAcesInPlayerHand() {
        playerOne.takeCard(card);
        playerOne.takeCard(card);
        playerOne.takeCard(card);
        assertEquals(3, playerOne.countAces());
    }

    @Test
    public void twoAcesInHandCountAsTwelve() {
        playerOne.takeCard(card);
        playerOne.takeCard(card);
        assertEquals(12, playerOne.handTotal());
    }

    @Test
    public void canShowPlayersFirstCard() {
        playerOne.takeCard(card);
        assertEquals("ACE of SPADES", playerOne.showCard(0));
    }

    @Test
    public void canShowThirdCardInPlayersHand() {
        playerOne.takeCard(card);
        playerOne.takeCard(card);
        playerOne.takeCard(cardTwo);
        assertEquals("KING of DIAMONDS", playerOne.showCard(2));
    }
}
