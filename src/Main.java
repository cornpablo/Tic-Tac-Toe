import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class Main extends JFrame {

    public Main(String title) {
        super(title);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,3));


        setVisible(true);
    }

    public static void main(String[] args) {
        Main f = new Main("Tic Tac Toe");

        Player player_1 = new Player("AJ","X");
        Player player_2 = new Player("Sophie", "O");
        Board board = new Board();
    }
}
