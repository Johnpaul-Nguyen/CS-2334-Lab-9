import java.util.Objects;

public class Card{
    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit){
        if(rank == null || suit == null){
            throw new NullPointerException();
        }

        this.rank = rank;
        this.suit = suit;
    }

    public int compareTo(Card card){
        int suitResult = suit.compareTo(card.getSuit());
        int rankResult = rank.compareTo(card.getRank());

        if (suitResult == 0){
            return rankResult;
        }
        return suitResult;
    }

    public boolean equals(Object obj){
        if (obj == null){
            return false;
        }
        else if (!Card.class.isInstance(obj)){
            return false;
        }
        else{
            Card card = (Card) obj;
            int result = compareTo(card);

            if (result == 0){
                return true;
            }
            return false;
        }
    }
    
    public Rank getRank(){
        return rank;
    }

    @Override
	public int hashCode() {
		return Objects.hash(rank, suit);
	}

	public Suit getSuit(){
        return suit;
    }

    public String toString(){
        return rank.toString() + suit.toString();
    }
}
