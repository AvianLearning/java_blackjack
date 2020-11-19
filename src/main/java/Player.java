import java.util.ArrayList;

public class Player {

    private String name;
    private Card hand;

    public Player(String name) {
        this.name = name;
        this.hand = hand;
    }

    public Card getHand() {
        return this.hand;
    }

    public void setHand(Card hand) {
        this.hand = hand;
    }
}
