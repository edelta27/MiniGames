package pl.edytaborowska;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.*;

public class LottoRandom {
    private static final int RANGE_NUMBERS = 100;
    private static final int NUMBER_DRAWN = 6;

    private List<Integer> winNumbs = new ArrayList<Integer>();

    LottoRandom() {
        generate();
        sorting();
    }
    List<Integer> getWinNumbs(){
        return winNumbs;
    }

    private void generate() {
        Random random = new Random();
        for (int winNum = 0; winNum < NUMBER_DRAWN; winNum++) {
            int anotherRandomNumber = random.nextInt(RANGE_NUMBERS);
            winNumbs.add(anotherRandomNumber);
        }
    }

    private void sorting() {
        Collections.sort(winNumbs);
    }

    String isEqual(List<Integer> userNumbers) {
        String congratulations = "You won!!! Congratulations!!!";
        String defeat = "Your numbers didn't win, try again.";
        boolean comparison = winNumbs.equals(userNumbers);

        if (comparison == true) {
            return congratulations;
        } else {
            return defeat;
        }
    }
    int checkResult(List<Integer> userNumbers) {
        int found = 0;
        for(int i = 0; i< NUMBER_DRAWN;i++){
            if(winNumbs.contains(userNumbers.get(i)))
                found++;}
        return found;
        }

    }



