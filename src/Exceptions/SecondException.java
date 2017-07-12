package Exceptions;

/**
 * Created by Artem Konyukhov on 16.05.2017.
 */
public class SecondException extends Exception {

    public SecondException(String message) {                            //переопределение конструктора
        super(message);
    }
}
