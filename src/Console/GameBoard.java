package Console;

public class GameBoard {

    private static final int rows = 6;
    private static final int cols = 7;

    private char[][] gameboard;

    public Players p1;
    public Players p2;

    public GameBoard(Players p1, Players p2)
    {
        this.p1 = p1;
        this.p2 = p2;
        this.gameboard = new char[rows][cols];
    }

    //toDo Print Gameboard

    public boolean placeOnGameBoard(Players p, int col)
    {
        for(int i = rows-1; i >= 0; i--) //from Bottom-up, if space is available its used, else is sends back false
        {
            if(this.gameboard[i][col] == '\0')
            {
                this.gameboard[i][col] = p.getSymbol(); //setting symbol of player on the free spot
               return true;
            }
        }
        return false;
    }
}
