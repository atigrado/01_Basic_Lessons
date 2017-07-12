package Exceptions;

/**
 * Created by Artem Konyukhov on 16.05.2017.
 */
public class Generator {

    public String helloMessage(String name) throws SimpleException {                    //метод способен кинуть исключение типа SimpleException
        if (name == null) {
            SimpleException se = new SimpleException(10, "Message is null");            //создаем объект-исключение
            throw se;                                                                   //"кидаем" исключение (способ выход из метода НЕ через return)
//            throw se = new SimpleException(10, "Message is null");
        }

        return "Hello, " + name;
    }
}
