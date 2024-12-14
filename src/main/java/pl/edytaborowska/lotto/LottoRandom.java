package pl.edytaborowska.lotto;

import java.util.Random;
import java.util.*;

import static pl.edytaborowska.lotto.config.LottoGameConfiguration.NUMBERS_TO_GENERATE;
import static pl.edytaborowska.lotto.config.LottoGameConfiguration.NUMBER_ORIGIN;
import static pl.edytaborowska.lotto.config.LottoGameConfiguration.RANDOM_NUMBER_BOUND;

public class LottoRandom {
    private final Random random = new Random();

    public Set<Integer> getRandomSixNumbers() {
        Set<Integer> winNumbs = new HashSet<>();
        while( winNumbs.size()<6) {
            int anotherRandomNumber = random.nextInt(RANDOM_NUMBER_BOUND) + 1;
            winNumbs.add(anotherRandomNumber);
        }
        return winNumbs;
    }
}



