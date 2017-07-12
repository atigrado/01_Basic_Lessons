package Robot5;

/**
 * Created by Artem Konyukhov on 12.04.2017.
 */
public interface RobotListener {

    public void startMove(double x, double y);                      //Метод вызывается в момент начала движения
    public void endMove(double x, double y);                        //Метод вызывается в момент окончания движения
}
