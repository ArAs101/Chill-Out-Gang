package src_Console;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void MainMenu(Players p1, Players p2) {
        System.out.println("Chill-Out Gang presents:");
        System.out.println("Vier gewinnt!!");
        System.out.println();
        System.out.println();
        System.out.println();
        while (true) {                              // Fehlerfälle bearbeiten!!! Abfragen sollen sich immer wiederholen!
            System.out.print("Please enter 'S' for Singleplayer mode or 'M' for Multiplayer mode: ");
            Scanner scanner = new Scanner(System.in);
            char modechoice = scanner.next().charAt(0);

            if (modechoice == 'S' || modechoice == 'M') {
                System.out.print("Please enter the name of Player 1: ");
                scanner.nextLine();
                p1.name = scanner.nextLine();
            } else {
                System.out.println("Invalid input");
            }

            if (modechoice == 'S') {
                //while (p1.symbol == 'X') {
                    System.out.print("Please choose a symbol for Player 1 (as long as it isn't 'X', which is reserved for the AI): ");
                    p1.symbol = scanner.next().charAt(0);
                    if (p1.symbol != 'X') {
                        System.out.println("Player 1:");
                        System.out.println("Name: " + p1.name);
                        System.out.println("Symbol: " + p1.symbol);
                        p2.name = "COM";
                        p2.symbol = 'X';
                        System.out.println("Player 2:");
                        System.out.println("Name: " + p2.name);
                        System.out.println("Symbol: " + p2.symbol);
                    } else {
                        System.out.println("'X' isn't allowed as symbol for Player 1!");
                    }
                //}

            }
            if (modechoice == 'M') {
                //while (p2.symbol == p1.symbol) {
                    System.out.print("Please choose a symbol for Player 1: ");
                    p1.symbol = scanner.next().charAt(0);
                    System.out.print("Please enter the name of Player 2: ");
                    scanner.nextLine();
                    p2.name = scanner.nextLine();
                    if (!Objects.equals(p1.name, p2.name)) {                    // fehlerhaft...
                        System.out.print("Please choose a symbol for Player 2: ");
                        p2.symbol = scanner.next().charAt(0);
                    } else {
                        System.out.println("The player names must be different!");
                    }
                //}
                if (p2.symbol == p1.symbol) {
                    System.out.println(p2.symbol + " isn't allowed as symbol for Player 2!");
                } else {
                    System.out.println("Player 1:");
                    System.out.println("Name: " + p1.name);
                    System.out.println("Symbol: " + p1.symbol);

                    System.out.println("Player 2:");
                    System.out.println("Name: " + p2.name);
                    System.out.println("Symbol: " + p2.symbol);
                }

            }
        }

        //System.out.println("The game will start soon :)");
    }


    public static void main(String[] args) {
        Players p1 = new Players("Armin", 'A');
        Players p2 = new Players("Hamza", 'B');
        MainMenu(p1, p2);
    }
}