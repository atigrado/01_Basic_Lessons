package MoveSquare;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Artem Konyukhov on 12.04.2017.
 */
public class MoveSquareFrame extends JFrame {

    public static final String UP = "UP";
    public static final String DOWN = "DOWN";
    public static final String LEFT = "LEFT";
    public static final String RIGHT = "RIGHT";

    public MoveSquareFrame() {
        SquareComponent sc = new SquareComponent();
        add(sc);                                                //Кладем компонт для рисования квадрата

        JButton btnUp = new JButton(UP);                        //Кнопка для команды движения вверх
        btnUp.setActionCommand(UP);                             //Идентификатор кнопки
        btnUp.addActionListener(sc);                            //Слушатель - компонент для рисования квадрата
        add(btnUp, BorderLayout.NORTH);                         //Кладем кнопку на самый верх формы - на север

        JButton btnDown = new JButton(DOWN);                    //Кнопка для команды движения Вниз
        btnDown.setActionCommand(DOWN);                         //Идентификатор кнопки
        btnDown.addActionListener(sc);                          //Слушатель - компонент для рисования квадрата
        add(btnDown, BorderLayout.SOUTH);                       //Кладем кнопку на самый низ формы - на юг

        JButton btnLeft = new JButton(LEFT);
        btnLeft.setActionCommand(LEFT);
        btnLeft.addActionListener(sc);
        add(btnLeft, BorderLayout.WEST);

        JButton btnRight = new JButton(RIGHT);
        btnRight.setActionCommand(RIGHT);
        btnRight.addActionListener(sc);
        add(btnRight, BorderLayout.EAST);

        setBounds(100, 100, 400, 400);          //Устанавливаем координаты
    }
}
