package game;

public class WinResult {
    private boolean isWon;
    private GameField field1;
    private GameField field2;

    public WinResult(boolean isWon, GameField field1, GameField field2) {
        this.isWon = isWon;
        this.field1 = field1;
        this.field2 = field2;
    }

    public boolean isWon() {
        return isWon;
    }

    public void setWon(boolean won) {
        isWon = won;
    }

    public GameField getField1() {
        return field1;
    }

    public void setField1(GameField field1) {
        this.field1 = field1;
    }

    public GameField getField2() {
        return field2;
    }

    public void setField2(GameField field2) {
        this.field2 = field2;
    }
}
