import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;
    
    public Deck(){
        cards = new ArrayList<Card>();
        Card card;

        for (Suit suit : Suit.values()) {
            for (Rank rank: Rank.values()){
                card = new Card(rank, suit);
                cards.add(card);
            }
        }
    }

    public int size(){
        return cards.size();
    }

    public String toString(){
        return cards.toString();
    }

    public Card draw(){
        if (size() == 0){
            return null;
        }
        
        Card result = cards.get(0);
        cards.remove(0);
        return result;
    }

    public List<Card> draw(int count){
        List<Card> result = new ArrayList<Card>();

        if (count < 0){
            return result;
        }
        else if (count >= size()){
            result.addAll(cards);

            cards.removeAll(cards);
        }
        else{
            for(int i = 0; i < count; i++){
                result.add(cards.get(0));
                cards.remove(0);
            }
        }

        return result;

    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public List<Card> getCardsByRank(Rank rank){
        List<Card> result = new ArrayList<Card>();

        for (int i = 0; i < size(); i++){
            if (cards.get(i).getRank() == rank){
                result.add(cards.get(i));
            }
        }

        return result;
    }
}
