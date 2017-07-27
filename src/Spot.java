import javax.swing.JButton;

public class Spot extends JButton {

    private String symbol;
    private boolean isAvailable;

    public Spot() {
        super("");

        this.symbol = "";
        this.isAvailable = true;
    }

    public Spot(String symbol) {
        super(symbol);

        this.symbol = symbol;
        this.isAvailable = true;
    }

    void mark(Player player) {
        this.symbol = player.getSymbol();
        this.isAvailable = false;
    }

    void setSymbol(String symbol) { this.symbol = symbol; }

    String getSymbol() { return this.symbol; }
    boolean getAvailable() { return this.isAvailable; }
}
