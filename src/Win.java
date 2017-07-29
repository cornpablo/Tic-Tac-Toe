import java.util.ArrayList;

public class Win {

    private ArrayList<Spot> board;

    public Win(Board board) {
        this.board = board.getBoard();
    }

    boolean checkForWin(Player player) {
        return rowWin(player) || colWin(player) || diagWin(player);
    }

    private boolean rowWin(Player player) {
        String pSym = player.getSymbol();
        for (int i = 0; i < 9; i += 3)
            if (this.board.get(i).getSymbol().equals(pSym)
                    && this.board.get(i + 1).getSymbol().equals(pSym)
                    && this.board.get(i + 2).getSymbol().equals(pSym))
                return true;

        return false;
    }

    private boolean colWin(Player player) {
        String pSym = player.getSymbol();
        for (int i = 0; i < 3; ++i)
            if (this.board.get(i).getSymbol().equals(pSym)
                    && this.board.get(i + 3).getSymbol().equals(pSym)
                    && this.board.get(i + 6).getSymbol().equals(pSym))
                return true;

        return false;
    }

    /*
     *   I don't know a way to find if there is a win diagonally other than hard coding it.
     *   If anyone knows how let me know pls.
     */
    private boolean diagWin(Player player) {
        String pSym = player.getSymbol();
        return (board.get(0).getSymbol().equals(pSym) && board.get(4).getSymbol().equals(pSym) && board.get(8).getSymbol().equals(pSym) ||
                board.get(2).getSymbol().equals(pSym) && board.get(4).getSymbol().equals(pSym) && board.get(6).getSymbol().equals(pSym));
    }
}
