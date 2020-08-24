package loader;

import java.util.Timer;
import java.util.TimerTask;

public class Winner {
    Timer time;

    public Winner() {
        this.time = new Timer();
        setWinner();
    }

    private void setWinner() {
        this.time.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (Gui.winner == 0) {
                    //row 1 for X
                    if (Gui.state[0] == 1 && Gui.state[1] == 1 && Gui.state[2] == 1) {
                        Gui.winner = 1;
                    } else if (Gui.state[3] == 1 && Gui.state[4] == 1 && Gui.state[5] == 1) {
                        Gui.winner = 1;
                    } else if (Gui.state[6] == 1 && Gui.state[7] == 1 && Gui.state[8] == 1) {
                        Gui.winner = 1;
                    } else if (Gui.state[0] == 1 && Gui.state[3] == 1 && Gui.state[6] == 1) {
                        Gui.winner = 1;
                    } else if (Gui.state[1] == 1 && Gui.state[4] == 1 && Gui.state[7] == 1) {
                        Gui.winner = 1;
                    } else if (Gui.state[2] == 1 && Gui.state[5] == 1 && Gui.state[8] == 1) {
                        Gui.winner = 1;
                    } else if (Gui.state[0] == 1 && Gui.state[4] == 1 && Gui.state[8] ==1) {
                        Gui.winner = 1;
                    } else if (Gui.state[2] == 1 && Gui.state[4] == 1 && Gui.state[6] == 1) {
                        Gui.winner = 1;
                    } else if (Gui.state[0] == 2 && Gui.state[1] == 2 && Gui.state[2] == 2) {
                        Gui.winner = 2;
                    } else if (Gui.state[3] == 2 && Gui.state[4] == 2 && Gui.state[5] == 2) {
                        Gui.winner = 2;
                    } else if (Gui.state[6] == 2 && Gui.state[7] == 2 && Gui.state[8] == 2) {
                        Gui.winner = 2;
                    } else if (Gui.state[0] == 2 && Gui.state[3] == 2 && Gui.state[6] == 2) {
                        Gui.winner = 2;
                    } else if (Gui.state[1] == 2 && Gui.state[4] == 2 && Gui.state[7] == 2) {
                        Gui.winner = 2;
                    } else if (Gui.state[2] == 2 && Gui.state[5] == 2 && Gui.state[8] == 2) {
                        Gui.winner = 2;
                    } else if (Gui.state[0] == 2 && Gui.state[4] == 2 && Gui.state[8] == 2) {
                        Gui.winner = 2;
                    } else if (Gui.state[2] == 2 && Gui.state[4] == 2 && Gui.state[6] == 2) {
                        Gui.winner = 2;
                    }
                }
            }
        }, 0, 150);
    }
}
