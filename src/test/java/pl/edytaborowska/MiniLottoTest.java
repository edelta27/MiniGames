package pl.edytaborowska;

import org.junit.jupiter.api.Test;
import pl.edytaborowska.lotto.LottoHitNumberCalculator;
import pl.edytaborowska.lotto.LottoRandom;
import pl.edytaborowska.lotto.MiniLotto;
import pl.edytaborowska.lotto.UserNumbers;
import pl.edytaborowska.lotto.model.GameResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MiniLottoTest {

    private static final Scanner scannerMock = new Scanner(System.in);
    private static final UserNumbers userNumbersMock = mock(UserNumbers.class);
    private static final LottoRandom lottoRandomMock = mock(LottoRandom.class);
    private  static final LottoHitNumberCalculator numberHit = new LottoHitNumberCalculator();


    @Test
    void shouldReturnWinnerMessageWhenPlayerIsWinner() {
        //given
        Set<Integer> playerNumbers = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Set<Integer> randomNumbers = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        mockNumbers(playerNumbers, randomNumbers);
        Game lottoGame = new MiniLotto(userNumbersMock, lottoRandomMock, numberHit, scannerMock);
        final String expectedMessage = "You hit 6 numbers! Winning numbers were [1, 2, 3, 4, 5, 6], and yours were [1, 2, 3, 4, 5, 6]";
        //when
        final GameResult gameResult = lottoGame.play();
        //then
        assertEquals(expectedMessage,gameResult.getGameResultInfo().getGameResultMessage());
    }
    @Test
    void shouldReturnLoserMessageWhenPlayerIsLoser() {
        //given
        Set<Integer> playerNumbers = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Set<Integer> randomNumbers = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(7, 8, 9, 10, 11, 12)));
        mockNumbers(playerNumbers, randomNumbers);
        Game lottoGame = new MiniLotto(userNumbersMock, lottoRandomMock, numberHit, scannerMock);
        final String expectedMessage = "You hit 0 numbers! Winning numbers were [7, 8, 9, 10, 11, 12], and yours were [1, 2, 3, 4, 5, 6]";
        //when
        final GameResult gameResult = lottoGame.play();
        //then
        assertEquals(expectedMessage,gameResult.getGameResultInfo().getGameResultMessage());
    }
    @Test
    void shouldReturnWinnerMessageWithOneNumberMessageWhenPlayerHitOneNumber() {
        //given
        Set<Integer> playerNumbers = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Set<Integer> randomNumbers = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(6, 8, 9, 10, 11, 12)));
        mockNumbers(playerNumbers, randomNumbers);
        Game lottoGame = new MiniLotto(userNumbersMock, lottoRandomMock, numberHit, scannerMock);
        final String expectedMessage = "You hit 1 numbers! Winning numbers were [6, 8, 9, 10, 11, 12], and yours were [1, 2, 3, 4, 5, 6]";
        //when
        final GameResult gameResult = lottoGame.play();
        //then
        assertEquals(expectedMessage,gameResult.getGameResultInfo().getGameResultMessage());
    }
    private void mockNumbers(Set<Integer> playerNumbers, Set<Integer> randomNumbers) {
        when(userNumbersMock.getSixNumbers(scannerMock)).thenReturn(playerNumbers);
        when(lottoRandomMock.getRandomSixNumbers()).thenReturn(randomNumbers);
    }
}
