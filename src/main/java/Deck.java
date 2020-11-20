import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cardDeck;

    public Deck(){
        this.cardDeck = new ArrayList<>();
    }

    public int getNumOfCards() {
        return this.cardDeck.size();
    }

    public void populate() {
        CardSuit[] suits = CardSuit.values();
        CardRank[] ranks = CardRank.values();

        for (CardSuit suit : suits) {
            for (CardRank rank : ranks) {
                this.cardDeck.add(new Card(suit, rank));
            }
        }
    }
    public void shuffle() {
        Collections.shuffle(this.cardDeck);
    }

    public Card deal() {
        return this.cardDeck.remove(0);
    }
}
