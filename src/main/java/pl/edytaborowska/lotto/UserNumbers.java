package pl.edytaborowska.lotto;


import static pl.edytaborowska.lotto.config.LottoGameConfiguration.HOW_MANY_NUMBERS_FROM_USER;
import static pl.edytaborowska.lotto.config.LottoGameConfiguration.LOWER_BOUND;
import static pl.edytaborowska.lotto.config.LottoGameConfiguration.UPPER_BOUND;

import java.util.*;
import java.util.logging.Logger;


public class UserNumbers {
    Logger log = Logger.getLogger(String.valueOf(UserNumbers.class));

    private Set<Integer> userInputNumbers = new HashSet<>();
    public Set<Integer> getSixNumbers(Scanner scanner) {
        Set<Integer> userNumbers = loadUserNumbers(scanner);
        scanner.close();
        return userNumbers;
    }
    private Set<Integer> loadUserNumbers(Scanner sc) {
        final Set<Integer> userNumbers = new HashSet<>();
        log.info("Hello! I invite you to play mini lotto, guess 6 numbers from 1 to 99. ");
        while (userNumbers.size() < HOW_MANY_NUMBERS_FROM_USER) {
            log.info("Please give number: ");
            //while (!sc.hasNextInt()) {
            //    System.out.println("Enter a number between 1 and 99");
            //    if (!sc.hasNext()) {
            //        return Collections.emptySet();
            //    }
            //}
            try {
                int userNumber = sc.nextInt();
                if (userNumber >= LOWER_BOUND && userNumber <= UPPER_BOUND) {
                    userNumbers.add(userNumber);
                } else {
                    log.info("Enter a number between 1 and 99");
                }
            }
         catch (InputMismatchException ex){
             log.info("The value provided is not an integer ");
            sc.nextLine();
            }
        }
        return userNumbers;
    }
}
