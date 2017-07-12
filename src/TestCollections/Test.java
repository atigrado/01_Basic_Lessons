package TestCollections;

import java.util.*;

/**
 * Created by Artem Konyukhov on 19.07.2016.
 */
public class Test {
    public class TestObject {
        private String name = "";

        public TestObject(String name) {
            this.name = name;
        }
    }

    private class MyComparator implements Comparator {
        public int compare(Object l, Object r) {
            String left = (String)l;
            String right = (String)r;
            return -1 * left.compareTo(right);
        }
    }

    public Test() {
    }

    public static void main(String[] args) {
        Test test = new Test();
        Vector v = new Vector();
        v.add("bbbbb");
        v.add("aaaaa");
        v.add("ccccc");
        System.out.println("Default elements order");
        test.dumpList(v);
        Collections.sort(v);
        System.out.println("Default sorting order");
        test.dumpList(v);
        System.out.println("Reverse sorting order with providing implicit comparator");
        Collections.sort(v, test.new MyComparator());
        test.dumpList(v);
    }

    private void dumpList(List l) {
        Iterator it = l.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}