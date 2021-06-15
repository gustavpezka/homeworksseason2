package homework2_1;

public class Main {
    public static void main(String[] args) {

        Course course = new Course( 5);
        course.courseInfo();

        Team team = new Team("FTW!", new Human("Volodja",150,10),
                new Cat("Mister Bigglesworth"), new Robot("Robocop", 150, 7), new Robot("Fedor"));
        team.membersInfo();
        team.passCourse(course);
        team.winnersInfo() ;
    }
}
