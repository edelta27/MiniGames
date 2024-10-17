package pl.edytaborowska;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MiniLottoTest {

    private static final Scanner scannerMock = new Scanner(System.in);

    private static final UserNumbers userNumbersMock = mock(UserNumbers.class);
    private static final LottoRandom lottoRandomMock = mock(LottoRandom.class);
    final Set<Integer> userNumbersSet = userNumbersMock.getSixNumbers(scannerMock);
    int numberHit = lottoRandomMock.checkResult(userNumbersSet).size();


    @Test
    void shouldReturnWinnerMessageWhenPlayerIsWinner() {
        //given
        Set<Integer> playerNumbers = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Set<Integer> randomNumbers = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        mockNumbers(playerNumbers, randomNumbers);
        Game lottoGame = new MiniLotto(userNumbersMock, lottoRandomMock);
        final String expectedMessage = "You won!!! Congratulations!!!";
        //when
        lottoGame.play();
        final Set<Integer> userInputNumbers = userNumbersMock.getSixNumbers(scannerMock);
        final String resultMessage = lottoRandomMock.isEqual(userNumbersMock.getUserNumber());
        //then
        assertEquals(expectedMessage,resultMessage );


    }

    private void mockNumbers(Set<Integer> playerNumbers, Set<Integer> randomNumbers) {
        when(userNumbersMock.getSixNumbers(scannerMock)).thenReturn(playerNumbers);
        when(lottoRandomMock.getWinNumbs()).thenReturn(randomNumbers);
    }
}
