package homework2_1;

public class Robot implements Creature{
    private int maxRunningDistance = 30;
    private String name;
    private int maxJumpingHeight = 3;
    private boolean status = true;

    public Robot(String name, int maxRunningDistance, int maxJumpingHeight) {
        this.name = name;
        this.maxRunningDistance = maxRunningDistance;
        this.maxJumpingHeight = maxJumpingHeight;
    }

    public Robot(String name) {
        this.name = name;
    }


    @Override
    public void jump(int jumpingHeight) {
        if(maxJumpingHeight>jumpingHeight){
            System.out.println(String.format("Robot %s successfully jumped over the obstacle", name));
        }else{
            System.out.println(String.format("Robot %s failed to jump over the obstacle and is disqualified", name));
            status = false;
        }
    }

    @Override
    public void run(int runningDistance) {
        if(maxRunningDistance>runningDistance){
            System.out.println(String.format("Robot %s successfully ran the distance", name));
        }else {
            System.out.println(String.format("Robot %s failed to complete the run and is disqualified", name));
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
