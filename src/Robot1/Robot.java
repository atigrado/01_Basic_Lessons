package Robot1;

/**
 * Created by Artem Konyukhov on 05.07.2016.
 */
public class Robot {
    private double x = 0;                                                   //текущая координата X
    private double y = 0;                                                   //текущая координата Y
    protected double course = 0;                                            //текущий курс (в градусах) с измененным доступом

    private Operator operator;                                              //Робот управляется оператором

    public Robot(double x, double y) {                                      //конструктор с присваиванием
        this.x = x;
        this.y = y;
    }

    public Operator getOperator() {                                         //Можно узнать какой оператор управляет роботом
        return operator;
    }

    public void setOperator (Operator operator) {                           //Можно установить оператора для робота
        this.operator = operator;
    }

    public void forward(int distance) {                                     //передвижение на дистанцию distance
        x = x + distance * Math.cos(course / 180 * Math.PI);                //обращение к полю объекта X
        y = y + distance * Math.sin(course / 180 * Math.PI);                //обращение к полю объекта Y
    }

    public void printCordinates() {                                         //печать координат робота
        System.out.println(x + ", " + y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getCourse() {
        return course;
    }

    public void setCourse(double course) {
        this.course = course;
    }

    public double getTotalDistance() {
        return 0;
    }
}