package ShapeApplication2;

import java.awt.*;

/**
 * Created by Artem Konyukhov on 12.04.2017.
 */
public class RectangleComponent extends AbstractShape {
    @Override
    protected void paintShape(Graphics g) {
        g.drawRect(5, 5, getWidth() - 10, getHeight() - 10);
    }
}
