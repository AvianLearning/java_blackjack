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

    public int countAces() {
        int totalAces = 0;
        for (Card card : this. hand) {
            if (card.getRank() == CardRank.ACE) {
                totalAces += 1;
            }
        }
        return totalAces;
    }

    public int handTotal() {
        int total = 0;
        for (Card card : this.hand) {
            total += card.getValueRank();
            }
        if (countAces() >= 1) {
            total += 10;
        }
        return total;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

}
