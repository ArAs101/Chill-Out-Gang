package JFX;

public class Main {
    public static void MainMenu(Players p1, Players p2) {

        // JFX importieren...


        System.out.println("Chill-Out Gang presents:");
        System.out.println("Vier gewinnt!!");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Main Menu");




    }

    public static void main(String[] args) {
        Players p1 = new Players("", 'A');
        Players p2 = new Players("", 'B');
        MainMenu(p1, p2);
    }
}