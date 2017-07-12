package ShapeApplication2;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Artem Konyukhov on 12.04.2017.
 */
public abstract class AbstractShape extends JComponent {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintShape(g);
    }

    abstract protected void paintShape(Graphics g);
}
