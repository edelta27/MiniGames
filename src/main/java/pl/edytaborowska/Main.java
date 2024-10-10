package pl.edytaborowska;

import java.net.SocketOption;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Select a game to launch(e.g. lotto): ");
        String gameType = sc.nextLine();
        try {
            Game game = GameFactory.getGame(gameType);
            game.play();
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        sc.close();
    }
}