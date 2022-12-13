package src_Console;

import java.util.Scanner;

public class Main {


    public static void MainMenu(String p1, String p2) {
        System.out.println("Chill-Out Gang presents:");
        System.out.println("Vier gewinnt!!");
        System.out.println();
        System.out.println();
        while (true) {
            System.out.print("Please enter \\S for Singleplayer mode or \\M for Multiplayer mode: ");
            Scanner scanner = new Scanner(System.in);
            char modechoice = scanner.next().charAt(0);
            if (modechoice == 'S' || modechoice == 'M') {
                System.out.print("Please enter the name of player 1: ");
                //...




                return;
            } else {
                System.out.println("Invalid input");
            }
        }

    }


    public static void main(String[] args) {
        MainMenu("Armin", "Lenny");
    }
}
