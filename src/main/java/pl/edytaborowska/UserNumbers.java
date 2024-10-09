package pl.edytaborowska;

import java.util.*;

public class UserNumbers {
    private Set<Integer> userNumbers = new HashSet<>();

    public UserNumbers() {
        getUserNumber();
        getSixNumbers();

    }

    public Set<Integer> getSixNumbers(Scanner scanner) {
        userNumbers = loadUserNumber(scanner);
        scanner.close();
        return userNumbers;
    }

    public Set<Integer> getUserNumber() {
        return userNumbers;
    }

    public Set<Integer> loadUserNumber(Scanner sc) {

        boolean error = true;

        for (int i = 0; i < 6; ++i) {
            try {
                int nextNumber = sc.nextInt();
                error = false;
                userNumbers.add(nextNumber);
            } catch (InputMismatchException ex) {
                System.out.println("The value provided is not an integer");
                sc.nextLine();
                i--;
            }
            while (error) ;

            if (userNumbers.iterator() < 1) {
                System.out.println("You entered a number less than 1");
                userNumbers.remove(i);
                i--;


            } else {
                if (userNumbers.get(i) > 99) {
                    System.out.println("You entered a number greater than 99");
                    userNumbers.remove(i);
                    i--;

                }
            }


        }
        sc.close();
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
