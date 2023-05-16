import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NapoleonsTombFrame extends JFrame {

    private JPanel panel;
    private CardPile selectedCardPile;
    private List<CardPile> piles;
    private MouseAdapter adapter;
    private Color background;
    private Color foreground;

    public NapoleonsTombFrame(MouseAdapter adapter, int width, int height, List<CardPile> piles, Color background, Color foreGround){
        panel = new NapoleonsTombPanel(adapter, piles, background, foreGround);
        this.background = background;
        this.foreground = foreGround;
        add(panel);
        setSize(width,height);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.piles = piles;
        this.adapter = adapter;
    }

    public void itemClicked(CardPile clicked) {
        if (clicked instanceof CardPile){
            if (selectedCardPile != null){
                CardPile pile = (CardPile) clicked;
                if (this.selectedCardPile instanceof ThrowCardPile && clicked instanceof StartCardPile) {
                    StartCardPile startPile = (StartCardPile) clicked;
                    if (pile.getTopCard() == null) {
                        startPile.addPile(this.selectedCardPile);
                    }
                }
                else if (pile.add(selectedCardPile.getTopCard())){
                    selectedCardPile.remove();
                }
                this.selectedCardPile.highlight(false);
                selectedCardPile = null;
            }
            else if(clicked instanceof StartCardPile){
                if (this.selectedCardPile == null){
                    drawFromStartPile();
                }
                else{
                    this.selectedCardPile.highlight(false);
                    this.selectedCardPile = null;
                }
            }
            else{
                selectedCardPile = clicked;
                clicked.highlight(true);
            }
        }
        this.panel.repaint();
    }

    private void drawFromStartPile(){
        CardPile start = this.piles.get(0);
        if (start.getTopCard() != null){
            this.piles.get(1).add(start.remove());
        }
    }

    public void restart(){
        Random random = new Random();
        List<CardPile> piles = new ArrayList<>();

        CardPile startPile = new StartCardPile(new DeckGenerator(13, new String[] {"c", "d", "h", "s"}).generate(), new Random(), 179 - 131, 124 + 106);
        CardPile throwPile = new ThrowCardPile(179 + 293, 124 + 106);
        CardPile centerPile = new CenterCardPile(179 + 81, 124 + 106);
        CardPile sixPile = new SixCardPile(179 + 81, 124 + 106 +106+106);

        CardPile squareTop = new SquareCardPile(179 + 81, 124);
        CardPile squareRight = new SquareCardPile(179 + 81 + 81, 124 + 106);
        CardPile squareBottom = new SquareCardPile(179 + 81, 124 + 106 +106);
        CardPile squareLeft = new SquareCardPile(179, 124 + 106);

        CardPile rayTopLeft = new RayCardPile(179, 124);
        CardPile rayTopRight = new RayCardPile(179 + 81 + 81, 124);
        CardPile rayBottomRight = new RayCardPile(179 + 81 + 81, 124 + 106 +106);
        CardPile rayBottomLeft = new RayCardPile(179, 124 + 106 +106);

        piles.add(startPile);
        piles.add(throwPile);
        piles.add(centerPile);
        piles.add(sixPile);

        piles.add(squareTop);
        piles.add(squareRight);
        piles.add(squareBottom);
        piles.add(squareLeft);

        piles.add(rayTopLeft);
        piles.add(rayTopRight);
        piles.add(rayBottomRight);
        piles.add(rayBottomLeft);

        this.piles = piles;
        NapoleonsTombMouseListener adapter = new NapoleonsTombMouseListener(this.piles);
        adapter.addGame(this);
        this.adapter = adapter;
        this.remove(this.panel);
        this.panel = new NapoleonsTombPanel(this.adapter, this.piles, this.background, this.foreground);
        this.add(this.panel);
        SwingUtilities.updateComponentTreeUI(this);
        this.panel.repaint();
    }
}
