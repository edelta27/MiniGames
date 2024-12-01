package pl.edytaborowska.lotto;

import static pl.edytaborowska.lotto.config.LottoGameConfiguration.HOW_MANY_NUMBERS_FROM_USER;
import static pl.edytaborowska.lotto.config.LottoGameConfiguration.LOWER_BOUND;
import static pl.edytaborowska.lotto.config.LottoGameConfiguration.UPPER_BOUND;

import java.util.*;
import java.util.logging.Logger;

public class UserNumbers {
    Logger log = Logger.getLogger(String.valueOf(UserNumbers.class));

    public Set<Integer> getSixNumbers(Scanner scanner) {
        Set<Integer> userInputNumbers = loadUserNumbers(scanner);
        scanner.close();
        return userInputNumbers;
    }

    public Set<Integer> loadUserNumbers(Scanner sc) {
        final Set<Integer> userInputNumbers = new HashSet<>();
        log.info("Hello! I invite you to play mini lotto, guess 6 numbers from 1 to 99. ");
        log.info("Type 'end' to exit the game at any time.");

        int attempts = 0;
        final int MAX_ATTEMPTS = 3;

        while (userInputNumbers.size() < HOW_MANY_NUMBERS_FROM_USER) {
            log.info("Please give number: ");
            String input = sc.nextLine().trim();
            if (input.equalsIgnoreCase("end")) {
                log.info("You have ended the game. Thank you for playing!");
                return userInputNumbers;
            }
            if (input.isEmpty()) {
                attempts++;
                log.info("You didn't provide any input. Please try again.");
                if (attempts >= MAX_ATTEMPTS) {
                    log.info("No valid input provided after multiple attempts. Returning an empty set.");
                    return Collections.emptySet();
                }
                continue;
            }
            try {
                int userNumber = Integer.parseInt(input);
                if (userNumber >= LOWER_BOUND && userNumber <= UPPER_BOUND) {
                    if (!userInputNumbers.add(userNumber)) {
                        log.info("You have already entered this number. Try a different one.");
                    }
                } else {
                    log.info("Enter a number between 1 and 99.");
                }
            } catch (NumberFormatException ex) {
                log.info("The value provided is not a valid number. Please try again.");
            }
        }
        return userInputNumbers;
    }
}