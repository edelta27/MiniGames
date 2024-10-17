package pl.edytaborowska.lotto.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.edytaborowska.Game;

@AllArgsConstructor
@Getter
public class GameResult {


    private final Game game;
    private final GameResultInfo gameResultInfo;
}
