package pl.edytaborowska;

import java.net.SocketOption;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello! I invite you to play mini lotto, guess 6 numbers from 1 to 99. ");
        System.out.println("Enter 6 numbers separated by a space and confirm with enter.");

        Scanner sc = new Scanner(System.in);

        List<Integer> userNumbers = new ArrayList();

        boolean error = true;

        for (int i = 0; i < 6; ++i) {
            try{
                int nextNumber = sc.nextInt();
                error = false;
                userNumbers.add(nextNumber);
            }
            catch(InputMismatchException ex){
                System.out.println("Podana wartość nie jest liczbą calpwotą");
                sc.nextLine();
                i--;
            }while (error);


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