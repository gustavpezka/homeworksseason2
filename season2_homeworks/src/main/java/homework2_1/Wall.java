package homework2_1;

public class Wall implements Obstacle {
    private final int height;

    public Wall(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void overcome(Creature creature) {
        creature.jump(this);
    }
}
