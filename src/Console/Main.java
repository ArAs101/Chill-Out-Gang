package Console;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void MainMenu(Players p1, Players p2) {
        System.out.println("Chill-Out Gang presents:");
        System.out.println("Vier gewinnt!!");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Main Menu");
        Scanner scanner = new Scanner(System.in);
        char modechoice = 0;
        while (modechoice != 'S' && modechoice != 'M') {
            System.out.print("Please enter 'S' for Singleplayer mode or 'M' for Multiplayer mode: ");
            modechoice = scanner.next().charAt(0);

            if (modechoice == 'S' || modechoice == 'M') {
                System.out.print("Please enter the name of Player 1: ");
                scanner.nextLine();
                p1.setName(scanner.nextLine());
            } else {
                System.out.println("Invalid input");
            }
        }
        if (modechoice == 'S') {
            do {
                System.out.print("Please choose a symbol for Player 1 (as long as it isn't 'X', which is reserved for the AI): ");
                p1.setSymbol(scanner.next().charAt(0));
                if (p1.getSymbol() == 'X') {
                    System.out.println("'" + p1.getSymbol() + "' isn't allowed as symbol for Player 1!");
                }
            } while (p1.getSymbol() == 0 || p1.getSymbol() == 'X');
            p2.setName("COM");
            p2.setSymbol('X');
        }
        if (modechoice == 'M') {
            System.out.print("Please choose a symbol for Player 1: ");
            p1.setSymbol(scanner.next().charAt(0));

            do {
                System.out.print("Please enter the name of Player 2: ");
                scanner.nextLine();
                p2.setName(scanner.next());
                if (Objects.equals(p1.getName(), p2.getName())) {
                    System.out.println("The player names must be different!");
                }
            } while (Objects.equals(p1.getName(), p2.getName()) || Objects.equals(p2.getName(), ""));

            do {
                System.out.print("Please choose a symbol for Player 2: ");
                p2.setSymbol(scanner.next().charAt(0));

                if (p1.getSymbol() == p2.getSymbol()) {
                    System.out.println("The players' symbols must be different!");
                }
            } while (p2.getSymbol() == 0 || p1.getSymbol() == p2.getSymbol());
        }

        System.out.println();
        System.out.println("_________________________________________________________________________________________");
        System.out.println("Summary of Players:");
        System.out.println("Player 1:");
        System.out.println("Name: " + p1.getName());
        System.out.println("Symbol: " + p1.getSymbol());
        System.out.println("Player 2:");
        System.out.println("Name: " + p2.getName());
        System.out.println("Symbol: " + p2.getSymbol());

        System.out.println("The game will start soon :)");
        System.out.println("_________________________________________________________________________________________");

        if (modechoice == 'S')
        {
            playGameSingleplayer(p1,p2);
        }
        else {
            playGameMultiplayer(p1,p2);
        }
    }

    public static void playGameMultiplayer(Players p1, Players p2)
    {
        GameBoard gameBoard = new GameBoard(p1,p2);
        boolean win = false;
        double round = 1;
        System.out.println("Game starting....");
        while(!win && round < 43)
        {
            //gameBoard.print();
            System.out.println("Player " + gameBoard.p1.getName() + " turn:");
            gameBoard.p1.place(gameBoard);
            round++;
            if (round >= 43)
            {
                break;
            }
            //checkifwon = true = win = true = break; Player 1 win
            //gameBoard.print();
            System.out.println("Player " + gameBoard.p2.getName() + " turn:");
            gameBoard.p1.place(gameBoard);
            round++;
            //checkifwon = true = win = true; - Player 2 win
        }
    }

    public static void playGameSingleplayer(Players p1, Players p2)
    {
        //same as Multiplayer with random place
    }



    public static void main(String[] args) {
        Players p1 = new Players("", (char) 0);
        Players p2 = new Players("", (char) 0);
        MainMenu(p1, p2);


    }
}