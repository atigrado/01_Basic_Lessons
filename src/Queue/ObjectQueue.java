package Queue;

/**
 * Created by Artem Konyukhov on 03.04.2017.
 */
public class ObjectQueue {

    private ObjectBox head = null;                                          //Указатель на первый элемент очереди
    private ObjectBox tail = null;                                          //Указатель на последний элемент
    private int size = 0;                                                   //Поле для хранения размера очереди

    public void push (Object obj) {
        ObjectBox ob = new ObjectBox();                                     //Создаем вспомогательный объект и помещаем новый элемент в него
        ob.setObject(obj);

        if (head == null) {                                                 //Если очередь пустая - в ней нет еще элементов
            head = ob;                                                      //Теперь голова указывает на первый элемент
        }
        else {                                                              //Если это не первый элемент, то надо, чтобы последний элемент очереди
            tail.setNext(ob);                                               //указывал на вновь прибывший элемент
        }
                                                                            //В любом случае нужно "хвост" переместить на новый элемент
        tail = ob;                                                          //Если это первый элемент, то "голова" и "хвост" будут указывать на один и тот же элемент
        size++;                                                             //Увеличиваем размер очереди
    }

    public Object pull() {
        if (size == 0) {                                                    //Если нет элементов, то возвращаем NULL
            return null;
        }

        Object obj = head.getObject();                                      //Получаем наш объект из вспомогательного класса из "головы"
        head = head.getNext();                                              //Перемещаем "голову" на следующий элемент

        if (head == null) {                                                 //Если это был единственный элемент, то head станет равен null
            tail = null;                                                    //и тогда tail тоже должен ууказать на null
        }

        size--;                                                             //Уменьшаем размер очереди

        return obj;
    }

    public Object get(int index) {                                          //Функция — получение элемента по индексу
        if (size == 0 || index >= size || index < 0) {                      //Если нет элементов или индекс больше размера или индекс меньше 0
            return null;
        }

        ObjectBox current = head;                                           //Устанавливаем указатель, который будем перемещать на "голову"
        int pos = 0;                                                        //В этом случае позиция равна 0

        while (pos < index) {                                               //Пока позиция не достигла нужного индекса
            current = current.getNext();                                    //Перемещаемся на следующий элемент
            pos++;                                                          //И увеличиваем позицию
        }

        Object obj = current.getObject();                                   //Дошли до нужной позиции и можем вернуть элемент
        return obj;
    }

    public int size() {
        return size;
    }


    private class ObjectBox {                                               //Вспомогательный класс
        private Object object;                                              //Поле для хранения объекта
        private ObjectBox next;                                             //Поле для указания на следующй элемент в цепочке
                                                                            //Если оно равно NULL - значит это последний элемент
        public Object getObject() {
            return object;
        }

        public void setObject(Object object) {
            this.object = object;
        }

        public ObjectBox getNext() {
            return next;
        }

        public void setNext(ObjectBox next) {
            this.next = next;
        }
    }
}
