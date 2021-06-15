package homework2_1;

public class Treadmill implements Obstacle {
    private int length;
    private String type = "Treadmill";

    public Treadmill(int length) {
        this.length = length;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int getParam() {
        return length;
    }
}
