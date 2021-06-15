package homework2_1;

public class Human implements Creature{
    private int maxRunningDistance = 20;
    private String name;
    private int maxJumpingHeight = 1;
    private boolean status = true;

    public Human(String name, int maxRunningDistance, int maxJumpingHeight) {
        this.name = name;
        this.maxRunningDistance = maxRunningDistance;
        this.maxJumpingHeight = maxJumpingHeight;
    }

    public Human(String name) {
        this.name = name;
    }

    @Override
    public void jump(int jumpingHeight) {
        if(maxJumpingHeight>jumpingHeight){
            System.out.println(String.format("Human %s successfully jumped over the obstacle", name));
        }else{
            System.out.println(String.format("Human %s failed to jump over the obstacle and is disqualified", name));
            status = false;
        }
    }

    @Override
    public void run(int runningDistance) {
        if(maxRunningDistance>runningDistance){
            System.out.println(String.format("Human %s successfully ran the distance", name));
        }else {
            System.out.println(String.format("Human %s failed to complete the run and is disqualified", name));
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
