package ShapeApplication2;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Artem Konyukhov on 12.04.2017.
 */
public class ShapeFrame extends JFrame {
    public ShapeFrame() {
        setLayout(new GridLayout(2, 3));                //Устанавливаем LayoutManager в виде таблицы размерами 2 строки на 3 столбца

        add(new OvalComponent());                                //Создаем и "укладываем" на форму компоненты разных классов
        add(new RectangleComponent());
        add(new TriangleComponent());
        add(new OvalComponent());
        add(new RectangleComponent());
        add(new TriangleComponent());

        setBounds(200, 200, 450, 350);          //Устанавливаем координаты и размеры окна
    }
}
