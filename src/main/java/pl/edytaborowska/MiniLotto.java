package pl.edytaborowska;

import java.util.*;

public class MiniLotto implements Game{
    @Override
    public void play(){
        //Implementacja logiki gry MiniLotto
        System.out.println("Hello! I invite you to play mini lotto, guess 6 numbers from 1 to 99. ");
        System.out.println("Enter 6 numbers separated by a space and confirm with enter.");
        //Przykładowa implementacja gry lotto

        UserNumbers userNumbersList = new UserNumbers();

        LottoRandom win = new LottoRandom();
        List<Integer> winNumbs = win.getWinNumbs();
        int result = win.checkResult(userNumbersList.getUserNumber());

        System.out.println("Here are the numbers drawn " + winNumbs);

        Collections.sort(userNumbersList.getUserNumber());
        System.out.println("The number of your hits " + result);

        System.out.println(win.isEqual(userNumbersList.getUserNumber()));


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
