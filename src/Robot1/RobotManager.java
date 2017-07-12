package Robot1;

/**
 * Created by Artem Konyukhov on 05.07.2016.
 */
public class RobotManager {

    public static void main(String[] args) {
        Robot robot = new RobotTotal(0, 0);                     //полиморфизм: ссылке на класс-предок можно присвоить класс-потомок

        robot.forward(20);                                          //вперед на 20 метров
        robot.printCordinates();
        robot.setCourse(90);                                        //курс 90 градусов
        robot.printCordinates();
        robot.forward(20);
        robot.printCordinates();
        robot.setCourse(90);                                        //курс 45 градусов
        robot.printCordinates();
        robot.forward(50);
        robot.printCordinates();

        System.out.println(robot.getTotalDistance());

//        robot.back(10);                                             //назад на 10 метров - это метод для RobotExt
//        robot.printCordinates();
    }
}