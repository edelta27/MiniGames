package pl.edytaborowska;

import java.util.*;

public class MiniLotto implements Game{
    @Override
    public void play(){
        //Implementacja logiki gry MiniLotto
        System.out.println("Hello! I invite you to play mini lotto, guess 6 numbers from 1 to 99. ");
        System.out.println("Enter 6 numbers separated by a space and confirm with enter.");
        //Przykładowa implementacja gry lotto
        Scanner sc = new Scanner(System.in);

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
        DrawingNumbers win = new DrawingNumbers();
        List<Integer> winNumbs = win.getWinNumbs();
        int result = win.checkResult(userNumbers);

        System.out.println("Here are the numbers drawn " + winNumbs);

        Collections.sort(userNumbers);
        System.out.println("The number of your hits " + result);

        System.out.println(win.isEqual(userNumbers));


    }

    private static void generate(Collection<Integer> collection) {
        for(int i = 1; i < 100; ++i) {
            collection.add(i);
        }

    }

    private static void printCollection(Collection<Integer> collection) {
        Iterator var1 = collection.iterator();

        while(var1.hasNext()) {
            Integer s = (Integer)var1.next();
            System.out.print("" + s + "; ");
        }

        System.out.println();
    }


}
