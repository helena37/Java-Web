package game;

import java.util.ArrayList;

public class GameEngine {
    private GameFieldValue nextPlayer;
    private GameFieldValue currentPlayer;
    private ArrayList<GameField> fields;
    private int[] winningConstellations = new int[] {
            //rows
            0, 1, 2,
            3, 4, 5,
            6, 7, 8,
            //cols
            0, 3, 6,
            1, 4, 7,
            2, 5, 8,
            //diagonals
            0, 4, 8,
            6, 4, 2
    };


    private GameWindow window;

    public static GameEngine instance;

    public static void main(String[] args) {
        instance = new GameEngine();
    }

    public GameEngine() {
        window = new GameWindow(450, 465);
        initGame();
    }

    public void initGame() {
//        //Player
        nextPlayer = GameFieldValue.X;
        nextPlayerTurn();
        //Game Fields
        int fieldsMarginLeft = 20;
        int fieldsMarginTop = 5;
        int fieldWidth = 411 / 3;
        int fieldHeight = 411 / 3;

        fields = new ArrayList<>();
        fields.add(new GameField(fieldsMarginLeft, fieldsMarginTop, fieldWidth, fieldHeight));
        fields.add(new GameField(fieldsMarginLeft + fieldWidth, fieldsMarginTop, fieldWidth, fieldHeight));
        fields.add(new GameField(fieldsMarginLeft + 2 * fieldWidth, fieldsMarginTop, fieldWidth, fieldHeight));
        fields.add(new GameField(fieldsMarginLeft, fieldsMarginTop + fieldHeight, fieldWidth, fieldHeight));
        fields.add(new GameField(fieldsMarginLeft + fieldWidth, fieldsMarginTop + fieldHeight, fieldWidth, fieldHeight));
        fields.add(new GameField(fieldsMarginLeft + 2 * fieldWidth, fieldsMarginTop + fieldHeight, fieldWidth, fieldHeight));
        fields.add(new GameField(fieldsMarginLeft, fieldsMarginTop + 2 * fieldHeight, fieldWidth, fieldHeight));
        fields.add(new GameField(fieldsMarginLeft + fieldWidth, fieldsMarginTop + 2 * fieldHeight, fieldWidth, fieldHeight));
        fields.add(new GameField(fieldsMarginLeft + 2 * fieldWidth, fieldsMarginTop + 2 * fieldHeight, fieldWidth, fieldHeight));
    }

    public void nextPlayerTurn() {

        if (nextPlayer == GameFieldValue.X) {
            nextPlayer = GameFieldValue.O;
            currentPlayer = GameFieldValue.X;
        } else {
            nextPlayer = GameFieldValue.X;
            currentPlayer = GameFieldValue.O;
        }

        window.setCurrentPlayerName("Player " + nextPlayer.name() + " turn!");
    }

    public GameFieldValue getNextPlayer() {
        return nextPlayer;
    }

    public GameFieldValue getCurrentPlayer() {
        return currentPlayer;
    }

    public ArrayList<GameField> getFields() {
        return fields;
    }

    public WinResult hasWinner() {
        for (int i = 0; i < winningConstellations.length; i+= 3) {
            int currentValue1 = winningConstellations[i];
            int currentValue2 = winningConstellations[i + 1];
            int currentValue3 = winningConstellations[i + 2];
            if (Math.abs(fields.get(currentValue1).getValue().getValue() +
                    fields.get(currentValue2).getValue().getValue() +
                    fields.get(currentValue3).getValue().getValue()) == 3) {

                return new WinResult(true, fields.get(currentValue1), fields.get(currentValue3));
            }
        }
        return new WinResult(false, null, null);
    }

    public boolean hasDraw() {
        for (GameField field : this.getFields()) {
            if (field.getValue() == GameFieldValue.EMPTY) {
                return false;
            }
        }
        return !hasWinner().isWon();
    }
}
