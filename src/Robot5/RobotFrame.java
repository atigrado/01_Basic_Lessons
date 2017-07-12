package Robot5;

import javax.swing.*;

/**
 * Created by Artem Konyukhov on 28.07.2016.
 */
public class RobotFrame extends JFrame {

    public RobotFrame(Robot robot) {
        setTitle("Robot frame");                        //Устанавливает заголовок окна
        add(new RobotPathComponent(robot));             //Добавляем компонент для рисования пути робота
        setBounds(100, 100, 500, 500);                  //Устанавливаем размеры окна
    }
}
