import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class Runner {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Deck deck = new Deck();
        Game game = new Game(deck);
        boolean playerSticks;

        System.out.println("Welcome to Blackjack!");

        String namePrompt = "Please enter your name: ";
        System.out.println(namePrompt);
        String playerName = scanner.next();
        Player player = new Player(playerName);

        game.addPlayer(player);
        Player dealer = new Player("Dealer");
        game.addPlayer(dealer);

        game.prepareDeck();
        game.startGame();

        System.out.println("You have been dealt: ");
        System.out.println(player.showCard(0));
        System.out.println(player.showCard(1));
        System.out.println("Your total hand value is: " + player.handTotal());
        System.out.println();
        System.out.println("The Dealer has: ");
        System.out.println(dealer.showCard(0));
        System.out.println("The dealer's second card is hidden");
        System.out.println();

        if (game.hasBlackjack(player)) {
            System.out.println("You win with BLACKJACK!");
        }

        while(!game.playerIsBust(player) && player.handTotal() < 21) {
            System.out.println("Enter 1 to stick, 2 to twist");
            int stickOrTwist = parseInt(scanner.next());

            if (stickOrTwist == 1) {
                break;
            } else if (stickOrTwist == 2) {
                Card card = deck.deal();
                player.takeCard(card);
                System.out.println("You have been dealt the: ");
                System.out.println(card.cardName());
                System.out.println("Your total hand value is now: " + player.handTotal());
            }
        }
        if (game.playerIsBust(player)) {
            System.out.println("You're BUST! The dealer wins...");
            } else {
            System.out.println("You are sticking with a total of: " + player.handTotal());
            System.out.println();
            System.out.println("Now it's the dealer's turn!");
            System.out.println("The dealer's second card is: ");
            System.out.println(dealer.showCard(1));

            while (dealer.handTotal() < 16) {
                Card card = deck.deal();
                dealer.takeCard(card);
                System.out.println("The dealer has been dealt the: ");
                System.out.println(card.cardName());
                if (game.playerIsBust(dealer)) {
                    System.out.println("The dealer is BUST! You win!");
                    break;
                }
            }

            System.out.println("The dealers's total hand value is: " + dealer.handTotal());

            if (game.checkDraw()) {
                System.out.println("It's a draw!");
            } else {
                game.findWinner();
                System.out.println("The winner is: ");
                System.out.println(game.findWinner().getName());
            }
        }
    }
}
