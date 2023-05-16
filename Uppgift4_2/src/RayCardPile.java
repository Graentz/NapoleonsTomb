import java.util.Stack;

public class RayCardPile implements CardPile{

    private Stack<Card> pile;
    private int x,y;
    private boolean isHighlighted;

    public RayCardPile(int x, int y){
        this.pile = new Stack<Card>();
        this.x = x;
        this.y = y;
        this.isHighlighted = false;
    }

    public boolean add(Card card) {
        if (card != null){
            if (this.pile.empty() && card.getValue() == 7){
                this.pile.add(card);
                return true;
            }
            else if (!this.pile.empty() && card.getValue() == this.pile.peek().getValue() + 1){
                this.pile.add(card);
                return true;
            }
        }
        return false;
    }

    public Card getTopCard() {
        if (!this.pile.empty()){
            return this.pile.peek();
        }
        return null;
    }

    public Card remove() {
        if (!this.pile.empty()){
            return this.pile.pop();
        }
        return null;
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

    public VisualizationDetails getVisualizationDetails() {
        if(this.pile.empty() || this.pile.peek() == null){
            return null;
        }
        return new VisualizationDetails(this.pile.peek().getImgPath(), this.x, this.y);
    }
}
