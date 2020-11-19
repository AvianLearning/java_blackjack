import java.util.ArrayList;

public class Game {

    private Deck deck;
    private ArrayList<Player> players;

    public Game(Deck deck) {
        this.deck = deck;
        this.players = new ArrayList<>();
    }

    public void prepareDeck() {
        this.deck.populate();
        this.deck.shuffle();
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void dealCards() {
        for (Player player : players) {
            player.setHand(deck.deal());
        }
    }
}
