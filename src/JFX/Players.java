package JFX;
public class Players {
    public String name;
    public char symbol;


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
}