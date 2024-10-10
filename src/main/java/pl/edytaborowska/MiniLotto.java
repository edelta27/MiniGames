package pl.edytaborowska;

import java.util.*;
import java.util.Scanner;

public class MiniLotto implements Game {

    private final UserNumbers userNumbers = new UserNumbers();
    private final LottoRandom win = new LottoRandom();


    public MiniLotto() {
    }

    @Override
    public void play() {

        Scanner scanner = new Scanner(System.in);;
        final Set<Integer> userNumbersSet = userNumbers.getSixNumbers(scanner);

        Set<Integer> winNumbs = win.getWinNumbs();

        int numberHit = win.checkResult(userNumbersSet).size();

        System.out.println("Here are the numbers drawn " + winNumbs);
        System.out.println("Number of hit numbers " + numberHit);

        System.out.println(win.isEqual(userNumbers.getUserNumber()));
    }


}
