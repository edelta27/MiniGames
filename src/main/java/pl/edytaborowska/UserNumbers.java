package pl.edytaborowska;

import java.util.*;

public class UserNumbers {

  //  public List<Integer> getSixNumbers(Scanner scanner) {

   //     userNumbersList = loadUserNumber();
   //     scanner.close();
   //     return userNumbersList;
   // }
    private List<Integer> userNumbersList = new ArrayList<>();

    public UserNumbers(){
        Object scanner = new Object();
        sorting();
    }

    List<Integer> getUserNumber(){
        return userNumbersList;
    }
    public List<Integer> loadUserNumber(Scanner sc) {




        boolean error = true;

        for (int i = 0; i < 6; ++i) {
            try {
                int nextNumber = sc.nextInt();
                error = false;
                userNumbersList.add(nextNumber);
            } catch (InputMismatchException ex) {
                System.out.println("The value provided is not an integer");
                sc.nextLine();
                i--;
            }
            while (error) ;

            if (userNumbersList.get(i) < 1) {
                System.out.println("You entered a number less than 1");
                userNumbersList.remove(i);
                i--;


            } else {
                if (userNumbersList.get(i) > 99) {
                    System.out.println("You entered a number greater than 99");
                    userNumbersList.remove(i);
                    i--;

                }
            }


        }
        sc.close();
        return userNumbersList;
    }

    private void sorting() {
        Collections.sort(userNumbersList);
    }
}
