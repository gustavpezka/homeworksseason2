package homework2_1;

public class Main {
    public static void main(String[] args) {
        Main main1 = new Main();
        main1.play();
    }

    void play(){
        Creature[]creatures = {
                new Human("Fsds", 10,3),
                new Cat("Fdfgvb", 12,4),
                new Robot("sdfgsv", 15,1),
        };
        
        Obstacle[] obstacles = {
                new Treadmill(5),
                new Treadmill(10),
                new Wall(1),
                new Wall(4)
        };

        for (Obstacle obstacle: obstacles) {
            for (Creature creature : creatures) {
                obstacle.overcome(creature);
            }
        }

        for (Creature creature: creatures){
            if (creature.isPlay()){

            }
        }
    }
}
