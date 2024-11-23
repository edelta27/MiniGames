package pl.edytaborowska.lotto;

import lombok.Data;
import pl.edytaborowska.Game;
import pl.edytaborowska.lotto.model.GameResultInfo;
import pl.edytaborowska.lotto.model.GameResult;

import java.util.*;
import java.util.Scanner;
import java.util.logging.Logger;

@Data
public class MiniLotto implements Game {
    private final UserNumbers userNumbers;
    private final LottoRandom win;
    private final LottoHitNumberCalculator lottoHitNumberCalculator;
    private final Scanner scanner;

    Logger log = Logger.getLogger(String.valueOf(MiniLotto.class));
    public GameResult play() {
        log.info("Game Lotto started");
        final GameResultInfo gameResultInfo = getHitNumbers();
        return getGameResult(gameResultInfo);
    }
    private GameResultInfo getHitNumbers() {
        final Set<Integer> inputNumbers = userNumbers.getSixNumbers(scanner);
        final Set<Integer> randomNumbers = win.getRandomSixNumbers();
        return lottoHitNumberCalculator.getHitNumbers(inputNumbers, randomNumbers);
    }
    private GameResult getGameResult(GameResultInfo gameResultInfo) {
        final GameResult gameResult = new GameResult(this, gameResultInfo);
        log.info(gameResult.getGameResultInfo().getGameResultMessage());
        return gameResult;
    }
}
