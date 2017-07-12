package Exceptions;

/**
 * Created by Artem Konyukhov on 16.05.2017.
 */
public class Generator2 {

    public String helloMessage(String name) throws FirstException, SecondException {    //метод способен кинуть исключение типа SimpleException
        if ("FIRST".equals(name)) {
            throw new FirstException("FirstException occured");                         //создаем и "кидаем" объект-исключение
        }
        if ("SECOND".equals(name)) {
            throw new SecondException("SecondException occured");
        }
        return "Hello, " + name;
    }
}
