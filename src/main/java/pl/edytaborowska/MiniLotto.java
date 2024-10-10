package pl.edytaborowska;

import java.util.*;

public class MiniLotto implements Game {
    @Override
    public void play() {

        UserNumbers userNumbers = new UserNumbers();
        Set<Integer> userNumbersSet = userNumbers.getUserNumber();

        LottoRandom win = new LottoRandom();
        Set<Integer> winNumbs = win.getWinNumbs();

        int numberHit = win.checkResult(userNumbersSet).size();

        System.out.println("Here are the numbers drawn " + winNumbs);
        System.out.println("Number of hit numbers " + numberHit);

        System.out.println(win.isEqual(userNumbers.getUserNumber()));
    }

    private static void generate(Collection<Integer> collection) {
        for (int i = 1; i < 100; ++i) {
            collection.add(i);
        }
    }

    private static void printCollection(Collection<Integer> collection) {
        Iterator var1 = collection.iterator();
        while (var1.hasNext()) {
            Integer s = (Integer) var1.next();
            System.out.print("" + s + "; ");
        }
        System.out.println();
    }
}
