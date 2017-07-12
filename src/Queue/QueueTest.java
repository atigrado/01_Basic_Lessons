package Queue;

/**
 * Created by Artem Konyukhov on 03.04.2017.
 */
public class QueueTest {

    public static void main(String[] args) {
        ObjectQueue queue = new ObjectQueue();

        for (int i = 0; i < 10; i++) {
            queue.push("Строка" + i);                                   //Складываем в очередь строки
        }

//        while (queue.size() > 0) {
//            String s = (String) queue.pull();                               //Делаем жесткое приведение типа, т.к. знаем, что в очереди лежат строки
//            System.out.println(s);
//            System.out.println("Размер очереди:" + queue.size());
//        }

        for (int i = 0; i < queue.size(); i++) {
            String s = (String) queue.get(i);                               //Делаем жесткое приведение типа, т.к. знаем, что в очереди лежат строки
            System.out.println(s);
            System.out.println("Размер очереди:" + queue.size());
        }
    }
}
