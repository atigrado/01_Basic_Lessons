package ShapeApplication2;

import java.awt.*;

/**
 * Created by Artem Konyukhov on 12.04.2017.
 */
public class OvalComponent extends AbstractShape {
    @Override
    protected void paintShape(Graphics g) {
        g.drawOval(5, 5, getWidth() - 10, getHeight() - 10);
    }
}
