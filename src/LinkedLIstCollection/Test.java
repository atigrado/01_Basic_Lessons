package LinkedLIstCollection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Artem Konyukhov on 11.07.2016.
 */
public class Test {
    public Test() {
    }

    public static void main(String[] args) {
        Test test = new Test();
        LinkedList ll = new LinkedList();
        ll.add("Element1");
        ll.addFirst("Element2");
        ll.addFirst("Element3");
        ll.addLast("Element4");
        test.dumpList(ll);
        ll.remove(2);
        test.dumpList(ll);
        String element = (String)ll.getLast();
        ll.remove(element);
        test.dumpList(ll);
    }

    private void dumpList(List list) {
        Iterator it = list.iterator();
        System.out.println();
        while(it.hasNext()) {
            System.out.println((String)it.next());
        }
    }
}
