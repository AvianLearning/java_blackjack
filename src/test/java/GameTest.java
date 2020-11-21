import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {
    Deck deck;
    Player playerOne;
    Player dealer;
    Game game;
    Card highCard;
    Card lowCard;

    @Before
    public void before() {
        deck = new Deck();
        game = new Game(deck);
        game.prepareDeck();
        playerOne = new Player("Iain");
        dealer = new Player("Dealer");
        game.addPlayer(playerOne);
        game.addPlayer(dealer);
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
        game.startGame(2);
        assertEquals(2, playerOne.cardCount());
        assertEquals(2, dealer.cardCount());
    }

}
