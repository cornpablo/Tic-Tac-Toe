import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame{

    private static Player player_1 = new Player("AJ","X");
    private static Player player_2 = new Player("Sophie", "O");
    private static Board board = new Board(player_1);

    public Main(String title, Board board) {
        super(title);

        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,3));
        for (int i = 0; i < 9; ++i) {
            panel.add(board.getBoard().get(i));
        }

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {

        Main f = new Main("Tic Tac Toe", board);

        board.markSpot(player_1, 0);
    }


    public class spotClicked implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //board.getPlayerTurn();
        }
    }
}