public interface CardPile{

    boolean add(Card card);
    Card getTopCard();
    Card remove();
    CardPile clicked(int x, int y);
    void highlight(boolean highlight);
    boolean isHighlighted();
    VisualizationDetails getVisualizationDetails();

}
