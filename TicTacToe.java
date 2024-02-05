import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe extends JFrame implements ActionListener {

    private JButton[][] buttons;
    private boolean PlayerX;

    public TicTacToe() {
        super("Tic Tac Toe");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));

        buttons = new JButton[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].addActionListener(this);
                buttons[i][j].setBackground(Color.BLUE);
                buttons[i][j].setForeground(Color.WHITE);
                buttons[i][j].setFont(new Font("poppins",Font.BOLD,30));
                panel.add(buttons[i][j]);
            }
        }
        add(panel);

        PlayerX = true;
        setLocation(600,300);
        setResizable(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();

        if (button.getText().equals("")) {
            if (PlayerX) {
                button.setText("X");
            } else {
                button.setText("O");
            }

            PlayerX = !PlayerX;

            checkWinner();
        }
    }

    private void checkWinner() {

        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(buttons[i][1].getText()) && buttons[i][1].getText().equals(buttons[i][2].getText()) && !buttons[i][0].getText().equals("")) {
                Winner(buttons[i][0].getText());
                return;
            }
        }


        for (int i = 0; i < 3; i++) {
            if (buttons[0][i].getText().equals(buttons[1][i].getText()) && buttons[1][i].getText().equals(buttons[2][i].getText()) && !buttons[0][i].getText().equals("")) {
                Winner(buttons[0][i].getText());
                return;
            }
        }


        if (buttons[0][0].getText().equals(buttons[1][1].getText()) && buttons[1][1].getText().equals(buttons[2][2].getText()) && !buttons[0][0].getText().equals("")) {
            Winner(buttons[0][0].getText());
            return;
        }

        if (buttons[0][2].getText().equals(buttons[1][1].getText()) && buttons[1][1].getText().equals(buttons[2][0].getText()) && !buttons[0][2].getText().equals("")) {
            Winner(buttons[0][2].getText());
            return;
        }


        boolean Tie = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().equals("")) {
                    Tie = false;
                    break;
                }
            }
        }

        if (Tie) {
            Tie();
        }
    }

    private void Winner(String winner) {
        JOptionPane.showMessageDialog(this, winner + " win");
        reset();
    }

    private void Tie() {
        JOptionPane.showMessageDialog(this, "Tie");
        reset();
    }

    private void reset() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }

        PlayerX = true;
    }

    public static void main(String[] args) {
        new TicTacToe().setVisible(true);
    }
}