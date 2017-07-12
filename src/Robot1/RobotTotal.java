package Robot1;

public class RobotTotal extends Robot {

    private double totalDistance = 0;                           //поле для хранения пройденной дистанции

    public RobotTotal(double x, double y) {                     //переопределяем конструктор
        super(x, y);
    }

    @Override
    public void forward(int distance) {                         //вызов метода у класса предка
        super.forward(distance);
        totalDistance += distance;
    }

    public double getTotalDistance() {
        return totalDistance;
    }
}
