package homework2_1;

public class Wall implements Obstacle {
    private int height;
    private String type = "Wall";

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int getParam() {
        return height;
    }
}
