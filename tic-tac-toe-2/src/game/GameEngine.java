package game;

import java.util.ArrayList;

public class GameEngine {
    private GameFieldValue currentPlayer;
    private ArrayList<GameField> fields;

    public static GameEngine instance;

    public static void main(String[] args) {
        instance = new GameEngine();
    }

    public GameEngine() {
        new GameWindow(450, 460);
        initGame();
    }

    public void initGame() {
        //Player
        currentPlayer = GameFieldValue.X;

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
        if (currentPlayer == GameFieldValue.X) {
            currentPlayer = GameFieldValue.O;
        } else {
            currentPlayer = GameFieldValue.X;
        }
    }

    public GameFieldValue getCurrentPlayer() {
        return currentPlayer;
    }

    public ArrayList<GameField> getFields() {
        return fields;
    }

    public boolean hasWinner() {
        int[][] matrix = new int[3][3];
        matrix[0][0] = fields.get(0).getValue().getValue();
        matrix[0][1] = fields.get(1).getValue().getValue();
        matrix[0][2] = fields.get(2).getValue().getValue();
        matrix[1][0] = fields.get(3).getValue().getValue();
        matrix[1][1] = fields.get(4).getValue().getValue();
        matrix[1][2] = fields.get(5).getValue().getValue();
        matrix[2][0] = fields.get(6).getValue().getValue();
        matrix[2][1] = fields.get(7).getValue().getValue();
        matrix[2][2] = fields.get(8).getValue().getValue();

        return  //Rows
                        Math.abs(matrix[0][0] + matrix[0][1] + matrix[0][2]) == 3 ||
                        Math.abs(matrix[1][0] + matrix[1][1] + matrix[1][2]) == 3 ||
                        Math.abs(matrix[2][0] + matrix[2][1] + matrix[2][2]) == 3 ||
                        //Cols
                        Math.abs(matrix[0][0] + matrix[1][0] + matrix[2][0]) == 3 ||
                        Math.abs(matrix[0][1] + matrix[1][1] + matrix[2][1]) == 3 ||
                        Math.abs(matrix[0][2] + matrix[1][2] + matrix[2][2]) == 3 ||
                        // Diagonals
                        Math.abs(matrix[0][0] + matrix[1][1] + matrix[2][2]) == 3 ||
                        Math.abs(matrix[0][2] + matrix[1][1] + matrix[2][0]) == 3;
    }

    public boolean hasDraw() {
        for (GameField field : this.getFields()) {
            if (field.getValue() == GameFieldValue.EMPTY) {
                return false;
            }
        }
        return !hasWinner();
    }
}
