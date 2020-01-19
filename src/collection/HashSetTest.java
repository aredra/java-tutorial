package collection;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest<M> {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("Aredra");
        set.add("Aredra");
        set.add("PSY");
        set.add("YJB");
        set.add("Time");

        Iterator ir = set.iterator();

        while(ir.hasNext()) {
            System.out.println(ir.next());
        }
        System.out.println(set);
    }
}
