package Counter;

/**
 * Created by Artem Konyukhov on 30.06.2016.
 */
public class Counter {
    private int count = 5;

    public static void main(String[] args) {
//        System.out.println(count); //Так как метод main статичный, а переменная count нет,
                                   // в этом случае метод println, внутри метода main выбросит “Compile time error”.
    }
}
