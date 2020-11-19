public class Card {

    private CardSuit suit;
    private CardRank rank;

    public Card(CardSuit suit, CardRank rank) {
        this.suit = suit;
        this.rank = rank;
    }
    
    public CardSuit getSuit() {
        return this.suit;
    }
    
    public CardRank getRank() {
        return this.rank;
    }
    
    public int getValueRank() {
        return this.rank.getValue();
    }
}
