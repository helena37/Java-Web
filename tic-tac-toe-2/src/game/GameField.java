package game;

import java.awt.*;

public class GameField extends Rectangle {
    private GameFieldValue value;

    public GameField(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.value = GameFieldValue.EMPTY;
    }

    public void drawGameField(Graphics2D g2d) {
        //Draw game frame
        g2d.setColor(new Color(146, 43, 33));
        g2d.drawRect(x, y, width, height);

        //Draw players symbols
        switch (this.value) {
            case O -> g2d.drawOval(x + 5, y + 5, width - 10, height - 10);
            case X -> {
                g2d.drawLine(x + 5, y + 5, x + width - 5, y + height - 5);
                g2d.drawLine(x + width - 5, y + 5, x + 5, y + height - 5);
            }

        }
    }

    public GameFieldValue getValue() {
        return value;
    }

    public void setValue(GameFieldValue value) {
        this.value = value;
    }
}
