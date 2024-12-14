package pl.edytaborowska.lotto.model;
import java.util.Set;
import lombok.Data;
@Data
public class LottoGameResultInfo implements GameResultInfo {
    private final Set<Integer> userGivenNumbers;
    private final Set<Integer> randomSixNumbers;
    private final Set<Integer> finalHitNumbers;
    @Override
    public String getGameResultMessage() {
        return String.format("You hit %d numbers! Winning numbers were %s, and yours were %s", finalHitNumbers.size(), randomSixNumbers, userGivenNumbers);
    }
}
