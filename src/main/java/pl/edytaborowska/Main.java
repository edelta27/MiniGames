package pl.edytaborowska;

import java.net.SocketOption;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello! I invite you to play mini lotto, guess 6 numbers from 1 to 99. ");
        System.out.println("Enter 6 numbers separated by a space and confirm with enter.");

        Scanner sc = new Scanner(System.in);

        List<Integer> userNumbers = new ArrayList();
        for (int i = 0; i < 6; ++i) {
            int nextNumber = sc.nextInt();
            userNumbers.add(nextNumber);
        }

        if (userNumbers.size() != 6) System.out.println("You didn't provide 6 numbers, try again");

        for (int i = 0; i < 6; i++) {
            if (0 > userNumbers.get(i)) {
                if (userNumbers.get(i) > 100)
                    System.out.println("You have entered numbers greater than or less than the set of integers from 1 to 99, try again");
            }
        }

        System.out.println("Oto wylosowane liczby");
        Random random = new Random();

        List<Integer> winNumbs = new ArrayList<Integer>();
        for (int winNum = 0; winNum < 6; winNum++) {
            int anotherRandomNumber = random.nextInt(100);
            winNumbs.add(anotherRandomNumber);
            System.out.println(winNumbs.get(winNum));
        }

        Collections.sort(winNumbs);
        Collections.sort(userNumbers);

        boolean isEqual = winNumbs.equals(userNumbers);

        if (isEqual == true) {
            System.out.println("Wygrałeś!!! Gratulacje!!!");
        } else {
            System.out.println("Twoje liczby nie wygrały, spróbuj jeszcze raz.");
        }

    }
}