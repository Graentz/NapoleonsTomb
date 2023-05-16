import java.awt.*;

public class HighlightSquare {

    private int x,y, width, height;
    private Color color;

    public HighlightSquare(int x, int y, int width, int height, Color color){
        this.x = x;
        this.y = y;
        this.color = color;
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics graphics){
        graphics.setColor(color);
        graphics.fillRect(this.x, this.y, width, height);
    }

    public void change(int x, int y, Color color){
        this.x = x;
        this.y = y;
        this.color = color;
    }
}
