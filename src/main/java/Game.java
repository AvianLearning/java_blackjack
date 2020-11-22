import java.util.ArrayList;

public class Game {

    private Deck deck;
    private ArrayList<Player> players;
    private Player dealer;

    public Game(Deck deck) {
        this.deck = deck;
        this.players = new ArrayList<>();
        this.dealer = new Player("Dealer");
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

    public void startGame() {
        for(Player player:this.players) {
            for (int i = 0; i < 2; i++) {
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

    public boolean playerIsBust(Player player) {
        return player.handTotal() > 21;
    }

    public boolean hasBlackjack(Player player) {
        return player.handTotal() == 11 && player.cardCount() == 2;
    }

    public Player findWinner() {
        int highestHand = 0;
        Player winner = null;
        for(Player player: this.players) {
            if (player.handTotal() > highestHand)  {
                highestHand = player.handTotal();
                winner = player;
            }
        }
        return winner;
    }

}
