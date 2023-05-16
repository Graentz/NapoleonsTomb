import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class NapoleonsTombMouseListener extends MouseAdapter implements ActionListener {

    private NapoleonsTombFrame napoleonsTomb;
    private List<CardPile> clickables;

    public NapoleonsTombMouseListener(List<CardPile> clickables){
        this.clickables = clickables;
    }

    public void mousePressed(MouseEvent event) {
        int x = event.getX();
        int y = event.getY();
        for (CardPile clickable : clickables) {
            CardPile clicked = clickable.clicked(x, y);
            if (clicked != null){
                napoleonsTomb.itemClicked(clicked);
            }
        }
    }

    public void addGame(NapoleonsTombFrame napoleonsTomb){
        this.napoleonsTomb = napoleonsTomb;
    }

    public void actionPerformed(ActionEvent e) {
        napoleonsTomb.restart();
    }
}
