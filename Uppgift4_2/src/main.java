import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class main {
    public static void main(String[] args) {
        DeckGenerator deckGenerator = new DeckGenerator(13, new String[] {"c", "d", "h", "s"});
        List<CardPile> piles = new ArrayList<>();

        CardPile startPile = new StartCardPile(deckGenerator.generate(), new Random(4), 179 - 131, 124 + 106);
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

        NapoleonsTombMouseListener adapter = new NapoleonsTombMouseListener(piles);
        NapoleonsTombFrame game = new NapoleonsTombFrame(adapter, 600, 600, piles, Color.LIGHT_GRAY, Color.BLACK);
        adapter.addGame(game);
    }
}
