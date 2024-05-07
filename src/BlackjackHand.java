import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlackjackHand {
    private static Map<Rank, Integer> CARD_VALUE;
    static{
        CARD_VALUE = new HashMap<>();
        CARD_VALUE.put(Rank.TWO, 2);
        CARD_VALUE.put(Rank.THREE, 3);
        CARD_VALUE.put(Rank.FOUR, 4);
        CARD_VALUE.put(Rank.FIVE, 5);
        CARD_VALUE.put(Rank.SIX, 6);
        CARD_VALUE.put(Rank.SEVEN, 7);
        CARD_VALUE.put(Rank.EIGHT, 8);
        CARD_VALUE.put(Rank.NINE, 9);
        CARD_VALUE.put(Rank.TEN, 10);
        CARD_VALUE.put(Rank.JACK, 10);
        CARD_VALUE.put(Rank.QUEEN, 10);
        CARD_VALUE.put(Rank.KING, 10);
        CARD_VALUE.put(Rank.ACE, 11);
    }

    private static int MAX_VALUE = 21;

    private List<Card> cards;
    private int value = 0;
    private int numAcesAs11 = 0;

    public BlackjackHand(Card c1, Card c2){
       cards = new ArrayList<>();
       cards.add(c1);
       cards.add(c2);

       value = CARD_VALUE.get(c1.getRank()) + CARD_VALUE.get(c2.getRank());
       if (c1.getRank() == Rank.ACE){
            numAcesAs11++;
       }
       if (c2.getRank() == Rank.ACE){
            numAcesAs11++;
       }
       
       if (value > MAX_VALUE && numAcesAs11 > 0){
            value = value - 10;
            numAcesAs11--;
        }
    }

    public void addCard(Card card){
        if (card == null){
            throw new NullPointerException();
        }
        if (value < MAX_VALUE){
            cards.add(card);
            value = value + CARD_VALUE.get(card.getRank());
            
            if (card.getRank() == Rank.ACE){
                numAcesAs11++;
            }    
            
            if (value > MAX_VALUE && numAcesAs11 > 0){
                value = value - 10;
                numAcesAs11--;
            }
        }
    }

    public int size(){
        return cards.size();
    }

    public static Map<Rank, Integer> getCardValues(){
        //return result;
        
        return new HashMap(CARD_VALUE);
    }

    public List<Card> getCards(){
        List<Card> result = new ArrayList<Card>();
        result.addAll(cards);
        return result;
    }

    public int getValue(){
        return value;
    }

    public String toString(){
        return cards.toString();
    }
}
