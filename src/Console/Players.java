package Console;

import java.util.Scanner;

public class Players {
    public String name; //change to private?
    public char symbol; //change to private?


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

    public void place(GameBoard gameBoard)
    {
        Scanner sc = new Scanner(System.in);
        int selected = 0;
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
}