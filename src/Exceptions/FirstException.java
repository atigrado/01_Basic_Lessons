package Exceptions;

/**
 * Created by Artem Konyukhov on 16.05.2017.
 */
public class FirstException extends Exception {

    public FirstException(String message) {                            //переопределение конструктора
        super(message);
    }
}
