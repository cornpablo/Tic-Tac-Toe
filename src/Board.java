import java.util.ArrayList;

public class Board {

    private ArrayList<Spot> board = new ArrayList<Spot>();

    public Board() {
        for (int i = 0; i < 9; ++i)
            board.add(new Spot());
    }

    void markSpot(Player player, int index) { board.get(index).mark(player); }

    ArrayList<Spot> getBoard() { return this.board; }

    //DEBUG TOOLS

    void printBoard() {
        for (int i = 0; i < 9; ++i)
            System.out.println(board.get(i).getSymbol() + ", ");
    }
}
