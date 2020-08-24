package game;

public enum GameFieldValue {
    X(1), O(-1), EMPTY(0);

    int value;

    GameFieldValue(int value) {
        this.value = value;
    }

    int getValue() {
        return value;
    }
}
