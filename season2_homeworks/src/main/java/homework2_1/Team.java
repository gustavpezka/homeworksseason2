package homework2_1;

public class Team {
    private String teamName;
    private Creature[] team = new Creature[4];

    public Team(String teamName, Creature member0, Creature member1, Creature member2, Creature member3) {
        this.teamName = teamName;
        team[0] = member0;
        team[1] = member1;
        team[2] = member2;
        team[3] = member3;
    }

    public void passCourse(Course course){
        for (Obstacle trial:course.getObstacles()) {
            System.out.println(String.format("NEW OBSTACLE! %s %d meters", trial.getClass().getSimpleName(), trial.getParam()));
            for (Creature creature : team) {
                if (creature.getStatus()) {
                    if (trial.getClass().getSimpleName().equals("Wall")) {
                        creature.jump(trial.getParam());
                    } else {
                        creature.run(trial.getParam());
                    }
                }
            }
        }
    }

    public void winnersInfo(){
        for (Creature creature : team) {
            if (creature.getStatus()) {
                System.out.println(String.format("%s %s successfully completes trial!", creature.getClass().getSimpleName(), creature.getName()));
            }
        }

    }

    public void membersInfo(){
        System.out.println(String.format("This is team %s", teamName));
        for (int i = 0; i < team.length; i++) {
            System.out.println(String.format("Member %d - %s %s! It can jump %d meters high and run %d meters long",
                    i+1, team[i].getClass().getSimpleName(), team[i].getName(), team[i].getHeight(),team[i].getLength()));
        }
    }
}
