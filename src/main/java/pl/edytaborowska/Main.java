package pl.edytaborowska;

import pl.edytaborowska.lotto.LottoRandom;
import pl.edytaborowska.lotto.LottoHitNumberCalculator;
import pl.edytaborowska.lotto.MiniLotto;
import pl.edytaborowska.lotto.UserNumbers;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        final Game lottoGame = getLottoGame();
        lottoGame.play();
    }

    private static Game getLottoGame() {
        final UserNumbers userNumbers = new UserNumbers();
        final LottoRandom randomGenerator = new LottoRandom();
        final LottoHitNumberCalculator lottoHitNumberCalculator = new LottoHitNumberCalculator();
        final Scanner scanner = new Scanner(System.in);
        return new MiniLotto(userNumbers, randomGenerator, lottoHitNumberCalculator, scanner);
    }
}