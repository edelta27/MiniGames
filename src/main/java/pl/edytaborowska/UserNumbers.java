package pl.edytaborowska;

import static pl.edytaborowska.lotto.config.LottoGameConfiguration.HOW_MANY_NUMBERS_FROM_USER;
import static pl.edytaborowska.lotto.config.LottoGameConfiguration.LOWER_BOUND;
import static pl.edytaborowska.lotto.config.LottoGameConfiguration.UPPER_BOUND;
import java.util.*;

public class UserNumbers {
    private Set<Integer> userNumbers = new HashSet<>();

    public UserNumbers() {
        getUserNumber();
    }
    public Set<Integer> getUserNumber() {
        return userNumbers;
    }
    public Set<Integer> getSixNumbers(Scanner scanner) {
        userNumbers = loadUserNumbers(scanner);
        scanner.close();
        return userNumbers;
    }

    public Set<Integer> loadUserNumbers(Scanner sc) {
        System.out.println("Hello! I invite you to play mini lotto, guess 6 numbers from 1 to 99. ");

        while (userNumbers.size() < HOW_MANY_NUMBERS_FROM_USER) {
            System.out.println("Enter 6 numbers separated by a space and confirm with enter.");

            while (!sc.hasNextInt()) {
                System.out.println("Enter a number between 1 and 99");
                if (!sc.hasNext()) {
                    return Collections.emptySet();
                }
            }

            final int userNumber = sc.nextInt();
            if (userNumber >= LOWER_BOUND && userNumber <= UPPER_BOUND) {
                userNumbers.add(userNumber);
            } else {
                System.out.println("Enter a number between 1 and 99");
            }
        }
        return userNumbers;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserNumbers that = (UserNumbers) o;
        return Objects.equals(userNumbers, that.userNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userNumbers);
    }

}
