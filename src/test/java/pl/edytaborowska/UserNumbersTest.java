package pl.edytaborowska;

import org.junit.jupiter.api.Test;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserNumbersTest {

    UserNumbers userNumbers = new UserNumbers();

    @Test
    void shouldReturnNumbersInListWhenAllInRange() {
        //given
        Set<Integer> expectedNumbers = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        String givenNumbers = "1 2 3 4 5 6";
        Scanner scanner = mockScannerIn(givenNumbers);
        //when
        final Set<Integer> userInputNumbers = userNumbers.getSixNumbers(scanner);

        //then
        assertEquals(expectedNumbers, userInputNumbers);

    }

    @Test
    void shouldReturnNumbersInListWhenOneNotInRange() {
        //given
        Set<Integer> expectedNumbers = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 15)));
        String givenNumbers = "1 2 3 4 101 15";
        Scanner scanner = mockScannerIn(givenNumbers);
        //when
        final Set<Integer> userInputNumbers = userNumbers.getSixNumbers(scanner);

        //then
        assertThat(expectedNumbers).isEqualTo(userInputNumbers);

    }

    @Test
    void shouldReturnZeroNumbersInListWhenAllNotInRange() {
        //given
        Set<Integer> expectedNumbers = Collections.emptySet();
        String givenNumbers = "0 -1 103 103 104 105 106";
        Scanner scanner = mockScannerIn(givenNumbers);
        //when
        final Set<Integer> userInputNumbers = userNumbers.getSixNumbers(scanner);

        //then
        assertThat(expectedNumbers).isEqualTo(userInputNumbers);

    }

    private Scanner mockScannerIn(String data) {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scanner = new Scanner(System.in);
        System.setIn(stdin);
        return scanner;
    }

}
