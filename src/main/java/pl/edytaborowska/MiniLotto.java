package pl.edytaborowska;

import java.util.Collection;
import java.util.Iterator;

public class MiniLotto implements Game{
    @Override
    public void play(){
        //Implementacja logiki gry MiniLotto
        System.out.println("Hello! I invite you to play mini lotto, guess 6 numbers from 1 to 99. ");
        System.out.println("Enter 6 numbers separated by a space and confirm with enter.");
        //Przykładowa implementacja gry lotto

    }

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
