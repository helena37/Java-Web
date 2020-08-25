package game;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class GameWindow extends JFrame {
    private JLabel currentPlayerLable;

    public GameWindow(int width, int height) {
        setTitle("TicTacToe");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(0, 0, width, height);
        setLocale(null);
        setResizable(false);
        setLayout(new BorderLayout());

        GamePanel gamePanel = new GamePanel();
        getContentPane().add(gamePanel, BorderLayout.CENTER);
        currentPlayerLable = new JLabel("Tic Tac Toe");
        currentPlayerLable.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(currentPlayerLable, BorderLayout.NORTH);

        setVisible(true);
    }

    public void setCurrentPlayerName(String name) {
        currentPlayerLable.setText(name);
    }
}
