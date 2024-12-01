package pl.edytaborowska;

import org.junit.jupiter.api.Test;
import pl.edytaborowska.lotto.UserNumbers;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class UserNumbersTest {
    private final UserNumbers userNumbers = new UserNumbers();

    @Test
    void testValidInput() {
        String input = "10\n20\n30\n40\n50\n60\n";
        Scanner scanner = mockScannerIn(input);

        Set<Integer> result = userNumbers.loadUserNumbers(scanner);

        assertEquals(6, result.size());
        assertTrue(result.contains(10));
        assertTrue(result.contains(60));
    }

    @Test
    void testInvalidInput() {
        String input = "10\nabc\n20\n-5\n30\n100\n40\n50\n60\n";
        Scanner scanner = mockScannerIn(input);

        Set<Integer> result = userNumbers.loadUserNumbers(scanner);

        assertEquals(6, result.size());
        assertTrue(result.contains(10));
        assertTrue(result.contains(30));
    }

    @Test
    void testEndCommand() {
        String input = "10\n20\nend\n";
        Scanner scanner = mockScannerIn(input);

        Set<Integer> result = userNumbers.loadUserNumbers(scanner);

        assertEquals(2, result.size());
        assertTrue(result.contains(10));
        assertTrue(result.contains(20));
    }

    @Test
    void testNumberFormatException() {
        String input = "abc\n10\n20\n30\n40\n50\n60\n";
        Scanner scanner = mockScannerIn(input);

        Set<Integer> result = userNumbers.loadUserNumbers(scanner);

        assertEquals(6, result.size());
        assertTrue(result.contains(10));
        assertTrue(result.contains(20));
        assertTrue(result.contains(30));
        assertTrue(result.contains(40));
        assertTrue(result.contains(50));
        assertTrue(result.contains(60));
    }

    @Test
    void testEmptyInput() {
        String input = "\n\n\n";
        Scanner scanner = mockScannerIn(input);

        Set<Integer> result = userNumbers.loadUserNumbers(scanner);

        assertTrue(result.isEmpty());
    }

    @Test
    void testEndCommandImmediately() {
        String input = "end\n";
        Scanner scanner = mockScannerIn(input);

        Set<Integer> result = userNumbers.loadUserNumbers(scanner);

        assertTrue(result.isEmpty());
    }

    @Test
    void testOutOfRangeNumbers() {
        String input = "-5\n200\n10\n20\n30\n40\n50\n60\n";
        Scanner scanner = mockScannerIn(input);

        Set<Integer> result = userNumbers.loadUserNumbers(scanner);

        assertEquals(6, result.size());
        assertFalse(result.contains(-5));
        assertFalse(result.contains(200));
    }

    private Scanner mockScannerIn(String data) {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scanner = new Scanner(System.in);
        System.setIn(stdin);
        return scanner;
    }
}
