import java.util.Collections;
import java.util.Random;
import java.util.Stack;


public class StartCardPile implements CardPile{

    private Stack<Card> deck;
    private int x,y;
    private boolean isHighlighted;
    private int resets;

    public StartCardPile(Stack<Card> deck, Random seed, int x, int y){
        this.deck = deck;
        this.x = x;
        this.y = y;
        this.isHighlighted = false;
        resets = 0;
        shuffle(seed);
    }

    public boolean add(Card card) {
        return false;
    }

    public void addPile(CardPile pile){
        if(this.resets < 1){
            while (pile.getTopCard() != null){
                this.deck.add(pile.remove());
            }
            this.resets ++;
        }
    }

    public Card getTopCard() {
        if (!this.deck.empty()){
            return deck.peek();
        }
        return null;
    }

    public Card remove() {
        if (!this.deck.empty()){
            return deck.pop();
        }
        return null;
    }

    public VisualizationDetails getVisualizationDetails() {
        if(this.deck.empty() || this.deck.peek() == null){
            return null;
        }
        return new VisualizationDetails("./images/b1fv.gif", this.x, this.y);
    }

    private void shuffle(Random seed){
        Collections.shuffle(this.deck, seed);
    }

    public CardPile clicked(int x, int y) {
        if (x > this.x && x < this.x + 71 && y > this.y && y < this.y + 96){
            return this;
        }
        return null;
    }

    public void highlight(boolean highlighted) {
        this.isHighlighted = false;
    }

    public boolean isHighlighted() {
        return this.isHighlighted;
    }
}
