package pl.edytaborowska;

import java.util.Collection;
import java.util.Iterator;

public class MiniLotto {

    private static void generate(Collection<Integer> collection) {
        for(int i = 1; i < 100; ++i) {
            collection.add(i);
        }

    }

    private static void printCollection(Collection<Integer> collection) {
        Iterator var1 = collection.iterator();

        while(var1.hasNext()) {
            Integer s = (Integer)var1.next();
            System.out.print("" + s + "; ");
        }

        System.out.println();
    }


}
