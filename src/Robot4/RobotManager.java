package Robot4;

import javax.swing.*;

/**
 * Created by Artem Konyukhov on 28.07.2016.
 */
public class RobotManager {

    public static void main(String[] args) {
        final double COUNT = 25;                                       //Количество сторон многоугольника
        final int SIDE = 50;                                          //Длина стороны

        Robot robot = new Robot(200, 50);

        for (int i = 0; i < COUNT; i++) {                              //Создаем замкнутую фигуру с количеством углов COUNT
            robot.forward(SIDE);
            robot.setCourse(robot.getCourse() + 360/COUNT);
        }

        RobotFrame rf = new RobotFrame(robot);                         //Создаем форму для отрисовки пути робота
        rf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rf.setVisible(true);
    }
}
