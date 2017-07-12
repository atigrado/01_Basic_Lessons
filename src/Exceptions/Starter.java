package Exceptions;

/**
 * Created by Artem Konyukhov on 16.05.2017.
 */
public class Starter {

    public static void main(String[] args) {

        Generator generator = new Generator();                         //создаем класс для генерации исключений
        Generator2 generator2 = new Generator2();

        try {                                                          //блок для обработки исключений
            String answer = generator.helloMessage(null);         //оно обязательно возникнет: мы же передали null
            System.out.println("Answer 1:" + answer);
        } catch (SimpleException ex) {
            System.out.println("Error code:" + ex.getErrorCode());     //обрабатываем объект-исключение
            System.out.println("Error message:" + ex.getMessage());    //получаем некоторую инвформацию
        } finally {
            System.out.println("Этот блок вызывается всегда");         //блок вызывается всегда, независимо от результата
        }

        try {                                                         //блок тоже будет обрабатывать исключение
            String answer = generator.helloMessage("Yoda");     //но его не будет: мы передали коректный параметр
            System.out.println("Answer 2:" + answer);
        } catch (SimpleException ex) {
            System.out.println("Error:" + ex.getMessage());
        } finally {
            System.out.println("Этот блок вызывается всегда");         //блок вызывается всегда, независимо от результата
        }

        try {
            //String answer = generator2.helloMessage("FIRST");
            String answer = generator2.helloMessage("SECOND");
            //String answer = generator2.helloMessage("OTHER");
        } catch (FirstException | SecondException ex) {
            System.out.println("Error message:" + ex.getMessage());
        }
    }
}
