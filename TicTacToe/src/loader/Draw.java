package loader;

import javax.swing.*;
import java.awt.*;

public class Draw extends JLabel {
    private static final long serialVersionUID = 1L;

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;

        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //Draw
        graphics.setColor(new Color(255, 230, 204));
        graphics.fillRect(0, 0, 800, 600);
        graphics.setColor(Color.BLACK);

        //Columns
        graphics.drawLine(325, 50, 325, 500);
        graphics.drawLine(475, 50, 475, 500);

        //Rows
        graphics.drawLine(175, 200, 625, 200);
        graphics.drawLine(175, 350, 625, 350);

        //Draw Player
        graphics.setColor(Color.BLACK);
        if (Gui.player == 0) {
            graphics.drawString("Player: X", 25, 50);
        } else if (Gui.player == 1) {
            graphics.drawString("Player: O", 25, 50);
        }

        //Draw Winner
        if (Gui.winner == 1) {
            graphics.drawString("The Winner is: X", 25, 100);
            graphics.setFont(new Font("Arial", Font.PLAIN, 24));
        } else if (Gui.winner == 2) {
            graphics.drawString("The Winner is: O", 25, 100);
        }

        //Row 1
        if (Gui.state[0] == 1) {
            graphics.drawImage(ImageLoader.imgX, 175, 50, 150, 150, null);
        } else if (Gui.state[0] == 2) {
            graphics.drawImage(ImageLoader.imgO, 175, 50, 150, 150, null);
        }

        if (Gui.state[1] == 1) {
            graphics.drawImage(ImageLoader.imgX, 325, 50, 150, 150, null);
        } else if (Gui.state[1] == 2) {
            graphics.drawImage(ImageLoader.imgO, 325, 50, 150, 150, null);
        }

        if (Gui.state[2] == 1) {
            graphics.drawImage(ImageLoader.imgX, 475, 50, 150, 150, null);
        } else if (Gui.state[2] == 2) {
            graphics.drawImage(ImageLoader.imgO, 475, 50, 150, 150, null);
        }

        //Row 2
        if (Gui.state[3] == 1) {
            graphics.drawImage(ImageLoader.imgX, 175, 200, 150, 150, null);
        } else if (Gui.state[3] == 2) {
            graphics.drawImage(ImageLoader.imgO, 175, 200, 150, 150, null);
        }

        if (Gui.state[4] == 1) {
            graphics.drawImage(ImageLoader.imgX, 325, 200, 150, 150, null);
        } else if (Gui.state[4] == 2) {
            graphics.drawImage(ImageLoader.imgO, 325, 200, 150, 150, null);
        }

        if (Gui.state[5] == 1) {
            graphics.drawImage(ImageLoader.imgX, 475, 200, 150, 150, null);
        } else if (Gui.state[5] == 2) {
            graphics.drawImage(ImageLoader.imgO, 475, 200, 150, 150, null);
        }

        //Row 3
        if (Gui.state[6] == 1) {
            graphics.drawImage(ImageLoader.imgX, 175, 350, 150, 150, null);
        } else if (Gui.state[6] == 2) {
            graphics.drawImage(ImageLoader.imgO, 175, 350, 150, 150, null);
        }

        if (Gui.state[7] == 1) {
            graphics.drawImage(ImageLoader.imgX, 325, 350, 150, 150, null);
        } else if (Gui.state[7] == 2) {
            graphics.drawImage(ImageLoader.imgO, 325, 350, 150, 150, null);
        }

        if (Gui.state[8] == 1) {
            graphics.drawImage(ImageLoader.imgX, 475, 350, 150, 150, null);
        } else if (Gui.state[8] == 2) {
            graphics.drawImage(ImageLoader.imgO, 475, 350, 150, 150, null);
        }

        repaint();
    }
}
