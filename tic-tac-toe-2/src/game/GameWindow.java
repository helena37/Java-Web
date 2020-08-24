package game;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class GameWindow extends JFrame {
    public GameWindow(int width, int height) {
        setTitle("TicTacToe");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(0, 0, width, height);
        setLocale(null);
        setResizable(false);
        setLayout(new BorderLayout());

        GamePanel gamePanel = new GamePanel();
        getContentPane().add(gamePanel, BorderLayout.CENTER);

        setVisible(true);
    }
}
