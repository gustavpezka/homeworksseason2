package homework2_1;

import java.util.Random;

public class Course {
    private Obstacle[] obstacles;
    private int minWallHeight = 1;
    private int maxWallHeight = 3;
    private int minTreadmillLength = 15;
    private int maxTreadmillLength = 50;

    public Course(int numberOfObstacles) {
        obstacles = new Obstacle[numberOfObstacles];
        for (int i = 0; i < obstacles.length; i++) {
            switch ((int) (Math.random() * 2 + 1)) {
                case 1:
                    obstacles[i] = new Wall((int) (Math.random() * maxWallHeight + minWallHeight));
                    break;
                case 2:
                    obstacles[i] = new Treadmill((int) (Math.random() * maxTreadmillLength + minTreadmillLength));
                    break;
            }
        }
    }

    public void courseInfo(){
        for (Obstacle obstacle : obstacles) {
            System.out.println(obstacle.getType());
            System.out.println(obstacle.getParam());
        }
    }

    public Obstacle[] getObstacles() {
        return obstacles;
    }
}
