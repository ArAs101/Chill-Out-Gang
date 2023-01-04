package Console;

import java.util.Random;
import java.util.Scanner;

public class Players {
    private String name;
    private char symbol;


    public Players(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public void place(GameBoard gameBoard)
    {
        Scanner sc = new Scanner(System.in);
        int selected;
        boolean loop = true;
        do {
            System.out.print("Enter a number between 1 and 7: ");
            selected = sc.nextInt();
            if(selected >= 1 && selected <= 7)
            {
                if(gameBoard.placeOnGameBoard(this,selected-1))
                {
                    loop = false;
                }
            }
        } while ((selected < 1 || selected > 7) || loop);
    }
    public void place(GameBoard gameBoard, boolean bot)
    {
        Random random = new Random();
        int selected = random.nextInt(7) + 1;
        boolean loop = true;
        do {
                if(gameBoard.placeOnGameBoard(this,selected-1))
                {
                    System.out.println("Selected: " + selected);
                    loop = false;
                }
            selected = random.nextInt(7) + 1;

        } while (loop);
    }
}