package Robot5;

/**
 * Created by Artem Konyukhov on 12.04.2017.
 */
public class SimpleRobotListener implements RobotListener {
    @Override
    public void startMove(double x, double y) {
        System.out.println("Робот начал движение, координаты:" + x + "," + y);
    }

    @Override
    public void endMove(double x, double y) {
        System.out.println("Робот закончил движение, координаты:" + x + "," + y);
    }
}
