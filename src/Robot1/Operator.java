package Robot1;

/**
 * Created by Artem Konyukhov on 28.07.2016.
 */
public class Operator {

    private String firstName;
    private String lastName;

    private Robot robot;                                                //Оператор управляет конкретным роботом

    public Operator (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Robot getRobot() {                                           //У оператора можно спросить каким роботом он управляет
        return robot;
    }

    public void setRobot(Robot robot) {                                 //Оператору можно поручить управление роботом
        this.robot = robot;
    }
}
