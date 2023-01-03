package Console;

public class GameBoard {

    private static final int rows = 6;
    private static final int cols = 7;

    private char[][] gameBoard;

    public Players p1;
    public Players p2;

    public GameBoard(Players p1, Players p2)
    {
        this.p1 = p1;
        this.p2 = p2;
        this.gameBoard = new char[rows][cols];
    }

    //toDo Print Gameboard

    public boolean placeOnGameBoard(Players p, int col)
    {
        for(int i = rows-1; i >= 0; i--) //from Bottom-up, if space is available its used, else is sends back false
        {
            if(this.gameBoard[i][col] == '\0')
            {
                this.gameBoard[i][col] = p.getSymbol(); //setting symbol of player on the free spot
               return true;
            }
        }
        return false;
    }


    public boolean checkIfWon(Players p) //needs some testing
    {
        char playerSymbol = p.getSymbol();
        int agileCounter = 0;

        //horizontal checking
        for(int row = 0; row < rows; row++)
        {
            agileCounter = 0;

            for(int col = 0; col < cols; col++)
            {
                if (gameBoard[row][col] == playerSymbol)
                {
                    agileCounter++;
                }
                else
                {
                    agileCounter = 0;
                }

                if(agileCounter == 4)
                {
                    return true;
                }
            }
        }

        //vertical checking
        for(int col = 0; col < cols ; col++)
        {
            agileCounter = 0;

            for(int row = 0; row < rows; row++)
            {
                if (gameBoard[row][col] == playerSymbol)
                {
                    agileCounter++;
                }
                else
                {
                    agileCounter = 0;
                }

                if(agileCounter == 4)
                {
                    return true;
                }
            }
        }

        //region DIAGONAL CHECKING - PROPABLY WORKING BUT VERY HARDCODED - SO NOT FINISHED ;)
        //diagonal checking from left to right
        agileCounter = 0;
        for(int row = 0; row < rows; row ++) //gelb
        {
            if(gameBoard[row][row] == playerSymbol)
            {
                agileCounter++;
            }
            else
            {
                agileCounter = 0;
            }
            if(agileCounter == 4)
            {
                return true;
            }

        }

        agileCounter = 0;
        for(int row = 0; row < rows; row++) //grün unten
        {
            if(gameBoard[row][row+1] == playerSymbol)
            {
                agileCounter++;
            }
            else
            {
                agileCounter = 0;
            }
            if(agileCounter == 4)
            {
                return true;
            }
        }

        agileCounter = 0;
        for(int row = 0; row < rows-1; row++) //orange unten
        {
            if(gameBoard[row][row+2] == playerSymbol)
            {
                agileCounter++;
            }
            else
            {
                agileCounter = 0;
            }
            if(agileCounter == 4)
            {
                return true;
            }
        }

        agileCounter = 0;
        for(int row = 0; row < rows-2; row++) //pink
        {
            if(gameBoard[row][row+3] == playerSymbol)
            {
                agileCounter++;
            }
            else
            {
                agileCounter = 0;
            }
            if(agileCounter == 4)
            {
                return true;
            }
        }

        agileCounter = 0;
        for(int row = 1; row < rows; row++) //grün oben
        {
            if(gameBoard[row][row-1] == playerSymbol)
            {
                agileCounter++;
            }
            else
            {
                agileCounter = 0;
            }
            if(agileCounter == 4)
            {
                return true;
            }
        }

        agileCounter = 0;
        for(int row = 2; row < rows; row++) //orange oben
        {
            if(gameBoard[row][row-2] == playerSymbol)
            {
                agileCounter++;
            }
            else
            {
                agileCounter = 0;
            }
            if(agileCounter == 4)
            {
                return true;
            }
        }

        //diagonal checking from right to left
        agileCounter = 0;
        for(int row = 0; row < rows; row ++) //gelb
        {

            if(gameBoard[row][rows-row] == playerSymbol)
            {
                agileCounter++;
            }
            else
            {
                agileCounter = 0;
            }
            if(agileCounter == 4)
            {
                return true;
            }

        }
        for(int row = 0; row < rows-1; row ++) //grün unten
        {

            if(gameBoard[row][5-row] == playerSymbol)
            {
                agileCounter++;
            }
            else
            {
                agileCounter = 0;
            }
            if(agileCounter == 4)
            {
                return true;
            }

        }
        for(int row = 0; row < rows-2; row ++) //orange
        {

            if(gameBoard[row][4-row] == playerSymbol)
            {
                agileCounter++;
            }
            else
            {
                agileCounter = 0;
            }
            if(agileCounter == 4)
            {
                return true;
            }

        }
        for(int row = 0; row < rows-3; row ++) //pink
        {

            if(gameBoard[row][3-row] == playerSymbol)
            {
                agileCounter++;
            }
            else
            {
                agileCounter = 0;
            }
            if(agileCounter == 4)
            {
                return true;
            }

        }

        for(int row = 1; row < rows; row ++) //grün oben
        {

            if(gameBoard[row][6-row+1] == playerSymbol)
            {
                agileCounter++;
            }
            else
            {
                agileCounter = 0;
            }
            if(agileCounter == 4)
            {
                return true;
            }

        }

        for(int row = 2; row < rows; row ++) //orange oben
        {

            if(gameBoard[row][6-row+2] == playerSymbol)
            {
                agileCounter++;
            }
            else
            {
                agileCounter = 0;
            }
            if(agileCounter == 4)
            {
                return true;
            }

        }
        //endregion

        //region Diagonal checking AI generated -- not tested

        // check diagonals going from top-left to bottom-right
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                if (gameBoard[i][j] == gameBoard[i+1][j+1] && gameBoard[i+1][j+1] == gameBoard[i+2][j+2] && gameBoard[i+2][j+2] == gameBoard[i+3][j+3])
                {
                    return true;
                }
            }
        }

        // check diagonals going from top-right to bottom-left
        for (int i = 0; i < 3; i++)
        {
            for (int j = 3; j < 7; j++)
            {
                if (gameBoard[i][j] == gameBoard[i+1][j-1] && gameBoard[i+1][j-1] == gameBoard[i+2][j-2] && gameBoard[i+2][j-2] == gameBoard[i+3][j-3])
                {
                   return true;
                }
            }
        }

        //endregion

        return false;
    }

}
