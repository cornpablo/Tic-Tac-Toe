import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame{

    private static Player player_1 = new Player("AJ","X");
    private static Player player_2 = new Player("Sophie", "O");
    private static Board board = new Board(player_1);

    private static JLabel playerOneLabel = new JLabel(formatLabel(player_1));
    private static JLabel playerTwoLabel = new JLabel(formatLabel(player_2));
    private static JLabel currentPlayerLabel = new JLabel(formatCurrentPlayerLabel(board.getPlayerTurn()));

    private static String formatLabel(Player player) {
        return  player.getName() + " (" + player.getSymbol() + "): " + Integer.toString(player.getScore());
    }

    //I don't need to even get inputs honestly might remove it later on.
    private static String formatCurrentPlayerLabel(Player player) {
        return  "Current Player's Turn: " + player.getName();
    }

    public Main(String title, Board board) {
        super(title);

        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,3));
        for (int i = 0; i < 9; ++i) {
            panel.add(board.getBoard().get(i));
            board.getBoard().get(i).addActionListener(new spotClicked());
        }

        panel.add(currentPlayerLabel);
        panel.add(playerOneLabel);
        panel.add(playerTwoLabel);

        add(panel);
        setVisible(true);
    }

    void update() {
        currentPlayerLabel.setText(formatCurrentPlayerLabel(board.getPlayerTurn()));
        playerOneLabel.setText(formatLabel(player_1));
        playerTwoLabel.setText(formatLabel(player_2));
    }

    public static void main(String[] args) {

        Main f = new Main("Tic Tac Toe", board);

    }


    public class spotClicked implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if (source instanceof Spot) {
                Spot spot = (Spot) source;
                if (spot.getAvailable()) {
                    spot.mark(board.getPlayerTurn());

                    //Switches Players
                    if (player_1 == board.getPlayerTurn()) {
                        board.changeTurn(player_2);
                    } else {
                        board.changeTurn(player_1);
                    }

                    update();
                } else {
                    System.out.println("Spot has already been used!");
                }
            } else {
                System.out.println("Error: Object was not a Spot.");
            }
        }
    }
}