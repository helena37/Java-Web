package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GamePanel extends JPanel implements MouseListener {
    private WinResult winResult;

    public GamePanel() {
        this.winResult = null;
        setBackground(new Color(253, 235, 208));
        requestFocus();
        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //Draw game
        Graphics2D g2d = (Graphics2D) g;

        //Draw Fields
        for (GameField field : GameEngine.instance.getFields()) {
            field.drawGameField(g2d);
        }

        //Draw winner line
        if (winResult != null) {
            g2d.setColor(new Color(211, 84, 0));
            g2d.setStroke(new BasicStroke(10));
            g2d.drawLine((int) (winResult.getField1().getX() + winResult.getField1().getWidth() / 2),
                    (int) (winResult.getField1().getY() + winResult.getField1().getHeight() / 2),
                    (int) (winResult.getField2().getX() + winResult.getField2().getWidth() / 2),
                    (int) (winResult.getField2().getY() + winResult.getField2().getHeight() / 2));

            winResult = null;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        checkField(e.getX(), e.getY());
        checkWin();
    }

    private void checkWin() {
        WinResult tempResult = GameEngine.instance.hasWinner();

        if (tempResult.isWon()) {
            winResult = tempResult;
            repaint();
            JOptionPane.showMessageDialog(this,
                    "Player " + GameEngine.instance.getCurrentPlayer().name() + " is the Winner!",
                    "GAME OVER!",
                    JOptionPane.INFORMATION_MESSAGE);
            GameEngine.instance.initGame();
            repaint();
        } else if (GameEngine.instance.hasDraw()) {
            JOptionPane.showMessageDialog(this,
                    "DRAW",
                    "GAME OVER!",
                    JOptionPane.INFORMATION_MESSAGE);
            GameEngine.instance.initGame();
            repaint();
        }
    }

    private void checkField(int x, int y) {
        Rectangle cursorPosition = new Rectangle(x, y, 1, 1);

        for (GameField field : GameEngine.instance.getFields()) {
            if (cursorPosition.intersects(field)) {
                if (field.getValue() == GameFieldValue.EMPTY) {
                    field.setValue(GameEngine.instance.getNextPlayer());
                    repaint();

                    GameEngine.instance.nextPlayerTurn();
                }
                break;
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
