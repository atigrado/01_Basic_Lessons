package ShapeApplication2;

import javax.swing.*;

/**
 * Created by Artem Konyukhov on 12.04.2017.
 */
public class ShapeApplication {

    public static void main(String[] args) {
        ShapeFrame of = new ShapeFrame();                     //Создаем новое графическое окно
        of.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //Правило закрытия приложения по закрытию формы
        of.setVisible(true);                                  //Делаем окно видимым
    }
}
