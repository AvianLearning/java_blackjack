import com.oracle.webservices.internal.api.EnvelopeStyle;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {
    Deck deck;
    Player playerOne;
    Player dealer;
    Game game;
    Card highCard;
    Card lowCard;
    Card sevenOfHearts;

    @Before
    public void before() {
        deck = new Deck();
        game = new Game(deck);
        game.prepareDeck();
        playerOne = new Player("Iain");
        dealer = new Player("Dealer");
        game.addPlayer(playerOne);
        game.addPlayer(dealer);
        highCard = new Card(CardSuit.DIAMONDS, CardRank.KING);
        lowCard = new Card(CardSuit.SPADES, CardRank.ACE);
        sevenOfHearts = new Card(CardSuit.HEARTS, CardRank.SEVEN);
    }

    @Test
    public void canAddPlayer() {
        assertEquals(2, game.playerCount());
    }

    @Test
    public void canAddFullDeckToGame() {
        assertEquals(52, deck.getNumOfCards());
    }

    @Test
    public void startGameDealsTwoCardsEach() {
        game.startGame();
        assertEquals(2, playerOne.cardCount());
        assertEquals(2, dealer.cardCount());
    }

    @Test
    public void canCheckDraw() {
        playerOne.takeCard(highCard);
        playerOne.takeCard(lowCard);
        dealer.takeCard(highCard);
        dealer.takeCard(lowCard);
        assertTrue(game.checkDraw());
    }

    @Test
    public void canCheckIfPlayerIsBust() {
        playerOne.takeCard(highCard);
        playerOne.takeCard(highCard);
        playerOne.takeCard(highCard);
        assertTrue(game.playerIsBust(playerOne));
    }

    @Test
    public void aceAndTenWithTwoCardsIsBlackjack() {
        playerOne.takeCard(highCard);
        playerOne.takeCard(lowCard);
        assertTrue(game.hasBlackjack(playerOne));
    }

    @Test
    public void twentyOneWithThreeCardsIsNotBlackjack() {
        playerOne.takeCard(highCard);
        playerOne.takeCard(highCard);
        playerOne.takeCard(lowCard);
        assertFalse(game.hasBlackjack(playerOne));
    }

    @Test
    public void canFindWinnerWhereBlackjack() {
        playerOne.takeCard(highCard);
        playerOne.takeCard(lowCard);
        dealer.takeCard(lowCard);
        assertEquals(playerOne, game.findWinner());
    }

    @Test
    public void canFindWinnerWhereNoBlackJack() {
        playerOne.takeCard(highCard);
        playerOne.takeCard(sevenOfHearts);
        dealer.takeCard(sevenOfHearts);
        dealer.takeCard(lowCard);
        assertEquals(dealer, game.findWinner());
    }

    @Test
    public void checkWinnerCannotBeBust() {
        dealer.takeCard(sevenOfHearts);
        dealer.takeCard(lowCard);
        playerOne.takeCard(highCard);
        playerOne.takeCard(sevenOfHearts);
        playerOne.takeCard(sevenOfHearts);
        assertEquals(dealer, game.findWinner());
    }

}
