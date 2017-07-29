import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Main extends JFrame{

    private static JPanel panel = new JPanel();

    private static Player player_1 = new Player("AJ","X");
    private static Player player_2 = new Player("Mom", "O");
    private static Board board = new Board(player_1);
    private static Win win = new Win(board);

    private static JLabel playerOneLabel = new JLabel(formatLabel(player_1));
    private static JLabel playerTwoLabel = new JLabel(formatLabel(player_2));
    private static JLabel currentPlayerLabel = new JLabel(formatCurrentPlayerLabel());

    private static String formatLabel(Player player) {
        return  player.getName() + " (" + player.getSymbol() + "): " + Integer.toString(player.getScore());
    }

    private static String formatCurrentPlayerLabel() { return  "Current Player's Turn: " + board.getPlayerTurn().getName(); }

    public Main(String title, Board board) {
        super(title);

        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

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
        currentPlayerLabel.setText(formatCurrentPlayerLabel());
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

                    if (win.checkForWin(board.getPlayerTurn())) {
                        //System.out.println(board.getPlayerTurn().getName() + " won!!!!");
                        board.getPlayerTurn().addOneToScore();

                        JOptionPane.showMessageDialog(new JFrame(), board.getPlayerTurn().getName() + " won!");

                        board.resetBoard();
                        board.changeTurn(player_1);
                    } else {
                        //Switches Players
                        if (player_1 == board.getPlayerTurn()) {
                            board.changeTurn(player_2);
                        } else {
                            board.changeTurn(player_1);
                        }
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