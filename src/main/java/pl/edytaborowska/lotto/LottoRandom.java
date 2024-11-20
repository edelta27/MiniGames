package pl.edytaborowska.lotto;

import java.util.Random;
import java.util.*;
import static pl.edytaborowska.lotto.config.LottoGameConfiguration.NUMBERS_TO_GENERATE;
import static pl.edytaborowska.lotto.config.LottoGameConfiguration.NUMBER_ORIGIN;
import static pl.edytaborowska.lotto.config.LottoGameConfiguration.RANDOM_NUMBER_BOUND;

public class LottoRandom {
    public Set<Integer> getRandomSixNumbers() {
        Set<Integer> winNumbs = new HashSet<>();
        Random random = new Random();
        for (int winNum = NUMBER_ORIGIN; winNum < NUMBERS_TO_GENERATE; winNum++) {
            int anotherRandomNumber = random.nextInt(RANDOM_NUMBER_BOUND) + 1;
            winNumbs.add(anotherRandomNumber);
        }
        return winNumbs;
    }
}



