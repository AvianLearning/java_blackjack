import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public ArrayList<Card> getHand() {
        return this.hand;
    }

    public String getName() {
        return name;
    }

    public int cardCount() {
        return this.hand.size();
    }

    public void takeCard(Card card) {
        this.hand.add(card);
    }

    public int handTotal() {
        int total = 0;
        for (Card card : this.hand) {
            total += card.getValueRank();
        }
        return total;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

}
