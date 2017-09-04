package JPanelExample;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Artem Konyukhov on 04.09.2017.
 */
public class MyDrawPanel extends JPanel {
    public void paintComponent(Graphics g) {

        g.fillRect(0,0, this.getWidth(), this.getHeight());

        Graphics2D g2d = (Graphics2D) g;

        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);
        Color startColor = new Color(red, green, blue);

        red = (int) (Math.random() * 255);
        green = (int) (Math.random() * 255);
        blue = (int) (Math.random() * 255);
        Color endColor = new Color(red, green, blue);

        GradientPaint gradient = new GradientPaint(70, 70, startColor, 100, 100, endColor);
        g2d.setPaint(gradient);
        g2d.fillOval(70, 70, 100, 100);
    }
}
