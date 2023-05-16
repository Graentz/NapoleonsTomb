public class Card {
    private int value;
    private String type;
    private String imgPath;

    public Card(int value, String type, String imgPath) {
        this.value = value;
        this.type = type;
        this.imgPath = imgPath;
    }

    public String getImgPath(){
        return this.imgPath;
    }

    public int getValue(){
        return this.value;
    }

}
