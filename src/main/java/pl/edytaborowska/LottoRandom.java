package pl.edytaborowska;

import java.util.Random;
import java.util.*;
import static pl.edytaborowska.lotto.config.LottoGameConfiguration.NUMBERS_TO_GENERATE;
import static pl.edytaborowska.lotto.config.LottoGameConfiguration.NUMBER_ORIGIN;
import static pl.edytaborowska.lotto.config.LottoGameConfiguration.RANDOM_NUMBER_BOUND;

public class LottoRandom {

    private Set<Integer> winNumbs = new HashSet<>();

    LottoRandom() {
        generate();

    }

    Set<Integer> getWinNumbs() {
        return winNumbs;
    }

    private void generate() {
        Random random = new Random();
        for (int winNum = NUMBER_ORIGIN - 1; winNum < NUMBERS_TO_GENERATE; winNum++) {
            int anotherRandomNumber = random.nextInt(RANDOM_NUMBER_BOUND);
            winNumbs.add(anotherRandomNumber);
        }
    }


    String isEqual(Set<Integer> userNumbers) {
        String congratulations = "You won!!! Congratulations!!!";
        String defeat = "Your numbers didn't win, try again.";
        boolean comparison = winNumbs.equals(userNumbers);

        if (comparison == true) {
            return congratulations;
        } else {
            return defeat;
        }
    }

    Set<Integer> checkResult(Set<Integer> userNumbers) {
        Set<Integer> finalHitNumbers = new HashSet<>(userNumbers);
        finalHitNumbers.retainAll(winNumbs);
        return finalHitNumbers;

    }
}



