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
        playerOne = new Player("Iain");
        dealer = new Player("Dealer");
        game = new Game(deck);
    }

    @Test
    public void canAddPlayer() {
        game.addPlayer(playerOne);
        assertEquals(1, game.playerCount());
    }

    @Test
    public void canAddFullDeckToGame() {
        game.prepareDeck();
        assertEquals(52, deck.getNumOfCards());
    }



    
}
