import java.util.Stack;

public class DeckGenerator {

    private static int highestValue;
    private static String[] types;
    private static Stack<Card> deck;

    public DeckGenerator(int highestValue, String[] types){
        this.highestValue = highestValue;
        this.types = types;
        deck = new Stack<Card>();
    }

    public Stack<Card> generate(){
        this.deck = new Stack<>();
        int tempValue = this.highestValue;
        for (int i = 1; i <= tempValue; i++) {
            for (String type: types) {
                deck.push(new Card(i, type, "./images/" + type + i + ".gif"));
            }
        }
        return deck;
    }

}
