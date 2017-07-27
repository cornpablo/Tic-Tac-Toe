public class Player {

    private String name, symbol;
    private int score;

    public Player() {
        this.name  = "N/a";
        this.symbol = "";

        this.score = 0;
    }

    public Player(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;

        this.score = 0;
    }

    void setName(String name) { this.name = name; }
    void setSymbol(String symbol) { this.symbol = symbol; }
    void addOneToScore() { ++score; }

    String getName() { return this.name; }
    String getSymbol() { return this.symbol; }
    int getScore() { return this.score; }

}
