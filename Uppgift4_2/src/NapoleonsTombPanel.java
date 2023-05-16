import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class NapoleonsTombPanel extends JPanel {

    private List<CardPile> piles;
    private Color background;
    private HighlightSquare highlightSquare;

    public NapoleonsTombPanel(MouseAdapter adapter, List<CardPile> piles, Color background, Color foreground){
        this.addMouseListener(adapter);
        this.piles = piles;
        this.background = background;
        setBackground(background);
        setForeground(foreground);
        Button restartButton = new Button("New Game");
        restartButton.addActionListener((ActionListener) adapter);
        add("North", restartButton);
    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        drawPlayField(graphics);
        this.highlightSquare = new HighlightSquare(0,0,81,106, background);
        this.highlightSquare.draw(graphics);
        for (CardPile clickable : piles) {
            VisualizationDetails details;
            if ((details = clickable.getVisualizationDetails()) != null){
                if (clickable.isHighlighted()){
                    this.highlightSquare.change(details.getX() -5, details.getY() - 5, Color.YELLOW);
                    this.highlightSquare.draw(graphics);
                }
                graphics.drawImage(readImage(details.getImgPath()), details.getX(), details.getY(), null);
            }
        }
    }

    private void drawPlayField(Graphics graphics){
        graphics.fillRect(169, 114, 253, 328);
        graphics.fillRect(179 + 81 -10, 124 + 106 +106 + 106, 91, 106);
        graphics.fillRect(179 - 131 - 10, 124 + 106 -10, 91, 116);
        graphics.fillRect(179 + 293-10, 124 + 106-10, 91, 116);

        graphics.setColor(background);
        graphics.fillRect(179, 124, 71, 96);
        graphics.fillRect(179 + 81, 124, 71, 96);
        graphics.fillRect(179 + 81 + 81, 124, 71, 96);

        graphics.fillRect(179, 124 + 106, 71, 96);
        graphics.fillRect(179, 124 + 106 +106, 71, 96);

        graphics.fillRect(179 + 81, 124 + 106, 71, 96);
        graphics.fillRect(179 + 81, 124 + 106 +106, 71, 96);

        graphics.fillRect(179 + 81 + 81, 124 + 106, 71, 96);
        graphics.fillRect(179 + 81 + 81, 124 + 106 +106, 71, 96);

        graphics.fillRect(179 + 81, 124 + 106 +106+106, 71, 96);
        graphics.fillRect(179 - 131, 124 + 106, 71, 96);
        graphics.fillRect(179 + 293, 124 + 106, 71, 96);
    }

    //stolen from exampleprogram
    private Image readImage (String imageFile) {
        Image image;
        try {
            image = ImageIO.read(new File(imageFile));
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        return image;
    }
}
