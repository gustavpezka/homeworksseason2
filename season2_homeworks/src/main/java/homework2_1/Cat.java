package homework2_1;

public class Cat implements Creature {
    private int maxRunningDistance = 50;
    private String name;
    private int maxJumpingHeight = 2;
    private boolean status = true;

    public Cat(String name, int maxRunningDistance, int maxJumpingHeight) {
        this.name = name;
        this.maxRunningDistance = maxJumpingHeight;
        this.maxJumpingHeight = maxRunningDistance;
    }

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void jump(int jumpingHeight) {
        if(maxJumpingHeight>jumpingHeight){
            System.out.println(String.format("Cat %s successfully jumped over the obstacle", name));
        }else{
            System.out.println(String.format("Cat %s failed to jump over the obstacle and is disqualified", name));
            status = false;
        }
    }

    @Override
    public void run(int runningDistance) {
        if(maxRunningDistance>runningDistance){
            System.out.println(String.format("Cat %s successfully ran the distance", name));
        }else {
            System.out.println(String.format("Cat %s failed to complete the run and is disqualified", name));
            status = false;
        }
    }

    @Override
    public boolean getStatus() {
        return status;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHeight() {
        return maxJumpingHeight;
    }

    @Override
    public int getLength() {
        return maxRunningDistance;
    }
}
