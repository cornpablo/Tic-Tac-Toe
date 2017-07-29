import java.util.ArrayList;

public class Board {

    private ArrayList<Spot> board = new ArrayList<Spot>();
    private Player player_turn;

    public Board(Player first_player) {
        for (int i = 0; i < 9; ++i)
            board.add(new Spot());

        this.player_turn = first_player;
    }

    //markSpot is never used, might remove it later
    void markSpot(Player player, int index) { board.get(index).mark(player); }
    void changeTurn(Player player) {this.player_turn = player; }
    void resetBoard() {
        for (int i = 0; i < board.size(); ++i)
            board.get(i).resetSpot();
    }

    ArrayList<Spot> getBoard() { return this.board; }
    Player getPlayerTurn() { return this.player_turn; }

    //DEBUG TOOLS

    void printBoard() {
        for (int i = 0; i < 9; ++i)
            System.out.println(board.get(i).getSymbol() + ", ");
    }
}
