
public enum Suit {
    // Defining enum types // All are constants so all letters capitalized
    CLUBS("C"), DIAMONDS("D"), HEARTS("H"), SPADES("S");

    private String symbol;

    // Constructors
    private Suit(String symbol){
    	this.symbol = symbol;
    }

    public String toString(){
        return symbol;
    }
}
