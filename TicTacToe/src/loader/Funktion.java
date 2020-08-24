package loader;

public class Funktion {
    public static void reset() {
        for (int i = 0; i < Gui.state.length; i++) {
            Gui.state[i] = 0;
        }

        Gui.player = 0;
        Gui.winner = 0;
    }
}
