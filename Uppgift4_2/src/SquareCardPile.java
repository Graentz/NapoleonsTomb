import java.util.Stack;

public class SquareCardPile implements CardPile{

    Stack<Card> card;
    int x,y;
    boolean isHighlighted;

    public SquareCardPile(int x, int y){
        card = new Stack<Card>();
        this.x = x;
        this.y = y;
        this.isHighlighted = false;
    }

    public boolean add(Card card) {
        if (this.card.empty() && card != null){
            this.card.add(card);
            return true;
        }
        return false;
    }


    public Card getTopCard() {
        if(!this.card.empty()){
            return this.card.peek();
        }
        return null;
    }

    public Card remove() {
        if(!this.card.empty()){
            return this.card.pop();
        }
        return null;
    }

    public VisualizationDetails getVisualizationDetails() {
        if(this.card.empty() || this.card.peek() == null){
            return null;
        }
        return new VisualizationDetails(this.card.peek().getImgPath(), this.x, this.y);
    }

    public CardPile clicked(int x, int y) {
        if (x > this.x && x < this.x + 71 && y > this.y && y < this.y + 96){
            return this;
        }
        return null;
    }

    public void highlight(boolean highlight) {
        this.isHighlighted = highlight;
    }

    public boolean isHighlighted() {
        return this.isHighlighted;
    }
}
