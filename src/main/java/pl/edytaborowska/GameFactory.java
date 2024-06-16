package pl.edytaborowska;

public class GameFactory {
    public static Game getGame(String gameType) {
        switch (gameType.toLowerCase()) {
            case "lotto":
                return new MiniLotto();
            //Można dodać kolejne gry tutaj
            //case "innaGra":
            //return new InnaGra();
            default:
                throw new IllegalArgumentException("Nieznany typ gry" + gameType);
        }
    }
}
