package ArrayListCollection;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Artem Konyukhov on 11.07.2016.
 */
public class Test {

    public static void main(String[] args) {
        Test t = new Test();
        ArrayList al = new ArrayList();
        al.add("First Element");
        al.add("Second Element");
        al.add("Third Element");
        Iterator it = al.iterator();
        while(it.hasNext()) {
            System.out.println((String)it.next());
        }

        System.out.println("\n");

        al.add(2, "Insertion");
        it = al.iterator();
        while(it.hasNext()) {
            System.out.println((String)it.next());

        }
    }
}

