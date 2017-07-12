package MoveSquare;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Artem Konyukhov on 12.04.2017.
 */
public class SquareComponent extends JComponent implements ActionListener{

    private static final int SQUARE_SIZE = 30;                          //Константа для размера квадрата
    private static final int STEP = 10;                                 //Константа для шага
    private int x = 0;                                                  //Поля хранения текущих координат квадрата
    private int y = 0;

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JButton) {                          // Входной параметр содержит ссылку на того, кто послал сообщение.
                                                                        // Получает объект с помощью вызова getSource()
                                                                        // С помощью слова instanceof мы можем проверить, что объект принадлежит классу JButton (или его потомку)
            JButton btn = (JButton) e.getSource();                      //Приводим объект к типу JButton
            if (MoveSquareFrame.UP.equals(btn.getActionCommand())) {    //Сравниваем команду со строкой UP
                y -= STEP;                                              //Вверх двигаемся уменьшением координаты Y
            }

            if (MoveSquareFrame.DOWN.equals(btn.getActionCommand())) {  //Вниз двигаемся увеличением координаты Y
                y += STEP;
            }

            if (MoveSquareFrame.LEFT.equals(btn.getActionCommand())) {
                x -= STEP;
            }

            if (MoveSquareFrame.RIGHT.equals(btn.getActionCommand())) {
                x += STEP;
            }

            repaint();                                                  //Перерисовываем компонент для обновления экрана
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(x, y, SQUARE_SIZE, SQUARE_SIZE);
    }
}
