package pl.edytaborowska;

import java.net.SocketOption;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Wybierz grę do uruchomienia(np. lotto): ");
        String gameType = sc.nextLine();
        try {
            Game game = GameFactory.getGame(gameType);
            game.play();
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        List<Integer> userNumbers = new ArrayList();

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

            if (userNumbers.get(i) < 1) {
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

        if (userNumbers.size() != 6) System.out.println("You didn't provide 6 numbers, try again");

        for (int i = 0; i < 6; i++) {
            if (0 > userNumbers.get(i)) {
                if (userNumbers.get(i) > 100)
                    System.out.println("You have entered numbers greater than or less than the set of integers from 1 to 99, try again");
            }
        }
        DrawingNumbers win = new DrawingNumbers();
        List<Integer> winNumbs = win.getWinNumbs();
        int result = win.checkResult(userNumbers);

        System.out.println("Here are the numbers drawn " + winNumbs);

        Collections.sort(userNumbers);
        System.out.println("The number of your hits " + result);

        System.out.println(win.isEqual(userNumbers));


    }
}