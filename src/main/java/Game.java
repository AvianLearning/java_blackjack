import java.util.ArrayList;

public class Game {

    private Deck deck;
    private ArrayList<Player> players;

    public Game(Deck deck) {
        this.deck = deck;
        this.players = new ArrayList<>();
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    public int playerCount() {
        return this.players.size();
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void prepareDeck() {
        this.deck.populate();
        this.deck.shuffle();
    }

    public void startGame(int numberOfCards) {
        for(Player player:this.players) {
            for (int i = 0; i < numberOfCards; i++) {
                Card card = deck.deal();
                player.takeCard(card);
            }
        }
    }

    public boolean checkDraw() {
        boolean draw = true;
        int handTotal = this.players.get(0).handTotal();
        for(Player player:this.players) {
            if(player.handTotal() != handTotal) {
                draw = false;
            }
        }
        return draw;
    }


}
