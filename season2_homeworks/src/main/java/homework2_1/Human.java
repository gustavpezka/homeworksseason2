package homework2_1;

public class Human implements Creature {
    private final String name;
    private final int runLimit;
    private final int jumpLimit;
    private boolean play;

    public Human(String name, int runLimit, int jumpLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
        this.play = true;
    }

    @Override
    public boolean isPlay() {
        return play;
    }

    @Override
    public void jump(Wall wall) {
        if(play){
            if(jumpLimit>=wall.getHeight()){
                System.out.printf("Human %s jumped over a wall %d meters high",name,wall.getHeight());
                return;
            }
            System.out.printf("Human %s failed to jump over a wall %d meters high",name,wall.getHeight());
        }
    }

    @Override
    public void run(Treadmill treadmill) {
        if(play){
            if(runLimit>=treadmill.getLength()){
                System.out.printf("Human %s ran on a treadmill %d meters",name,treadmill.getLength());
                return;
            }
            System.out.printf("Human %s failed to ran on a treadmill %d meters",name,treadmill.getLength());
        }
    }
}
