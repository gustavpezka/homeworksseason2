package homework2_1;

public class Treadmill implements Obstacle {
    private final int length;

    public Treadmill(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void overcome(Creature creature) {
        creature.run(this);
    }
}
