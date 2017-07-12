package Exceptions;

/**
 * Created by Artem Konyukhov on 16.05.2017.
 */
public class SimpleException extends Exception {

    private int errorCode;                                              //поле для хранения информации о нашем классе-исключении

    public SimpleException(String message) {                            //переопределение конструктора
        this(0, message);
    }

    public SimpleException(int errorCode, String message) {             //создаем свой конструктор
        super(message);                                                 //вызываем конструктор предка
        this.errorCode = errorCode;                                     //добавляем инициализацию своего поля
    }

    public int getErrorCode() {                                         //метод получения кода ошибки
        return errorCode;
    }

}
