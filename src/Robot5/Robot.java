package Robot5;

import java.util.ArrayList;

/**
 * Created by Artem Konyukhov on 28.07.2016.
 */
public class Robot {

    private double x = 0;
    private double y = 0;
    protected double course = 0;

    private ArrayList<RobotLine> lines = new ArrayList<RobotLine>();                    //Список для хранения линий, по которым ходил робот

    private RobotListener listener;                                             //Ссылка на интерфейс!

    public Robot(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setListener(RobotListener listener) {                                   //Метод для установки реального слушателя
        this.listener = listener;
    }

    public void forward(int distance) {
        if(listener != null) {                                                          //Вызываем слушателя (если он установлен) в начале
            listener.startMove(x, y);
        }

        final double xOld = x;                                                          //Запоминаем координаты робота перед перемещением
        final double yOld = y;

        x += distance * Math.cos(course / 180 * Math.PI);                               //Меняем координаты
        y += distance * Math.sin(course / 180 * Math.PI);

        if(listener != null) {                                                          //Вызываем слушателя (если он установлен) после остановки
            listener.endMove(x, y);
        }

        lines.add(new RobotLine(xOld, yOld, x, y));                                     //Запоминаем координаты пройденного пути в списке
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getCourse() {
        return course;
    }

    public void setCourse(double course) {
        this.course = course;
    }

    public ArrayList<RobotLine> getLines() {
        return lines;
    }
}
