public class VisualizationDetails {
    private String imgPath;
    private int x;
    private int y;

    public VisualizationDetails(String imgPath, int x, int y){
        this.imgPath = imgPath;
        this.x = x;
        this.y = y;
    }

    public String getImgPath(){
        return this.imgPath;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}
