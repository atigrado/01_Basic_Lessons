package Robot4;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Artem Konyukhov on 28.07.2016.
 */
public class RobotPathComponent extends JComponent{

    private Robot robot;

    public RobotPathComponent(Robot robot) {
        this.robot = robot;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (RobotLine rl : robot.getLines()) {                             //Перебираем все линии, которые сохранились у робота
            int x1 = (int) Math.round(rl.getX1());                          //Для каждой линии получаем координаты
            int y1 = (int) Math.round(rl.getY1());
            int x2 = (int) Math.round(rl.getX2());
            int y2 = (int) Math.round(rl.getY2());

            g.drawLine(x1, y1, x2, y2);                                     //Рисуем линию с координатами
        }
    }
}
