package Robot1;

public class RobotExt extends Robot {                                     //наследуемся от основного класса

    public RobotExt(double x, double y, double course) {                  //конструктор с параметрами
        super(x, y);                                                      //вызов конструктора родительского класса (слово "super")
        this.course = course;
    }

    public void back(int distance) {
        forward(-distance);
    }
}