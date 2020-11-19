import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeckTest {
    Deck deck;

    @Before
    public void before() {
        deck = new Deck();
    }

    @Test
    public void deckHasNoCards() {
        assertEquals(0, deck.getNumOfCards());
    }

    @Test
    public void deckHas52Cards() {
        deck.populate();
        assertEquals(52, deck.getNumOfCards());
    }

     @Test
     public void canDealOneCard() {
         deck.populate();
         deck.deal();
         assertEquals(51, deck.getNumOfCards());
     }
}
