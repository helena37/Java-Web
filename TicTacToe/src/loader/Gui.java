package loader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui {
   private JFrame jFrame;
   private Draw draw;
   private JButton resetBtn;

   static JButton btn [] = new JButton[9];
   static int state[] = new int[9];
   static int player = 0;
   static int winner = 0;

    public Gui() {
        jFrame = new JFrame();
        jFrame.setSize(800, 600);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.setTitle("Tic Tac Toe");

        for (int i = 0; i < btn.length; i++) {
            btn[i] = new JButton();
            btn[i].setVisible(true);
            btn[i].addActionListener(new ActionHandler());
            btn[i].setFocusPainted(false);
            btn[i].setContentAreaFilled(false);
            btn[i].setBorder(null);
            jFrame.add(btn[i]);
        }

        ButtonPlacement.placeButton();

        resetBtn = new JButton("RESET");
        resetBtn.setBounds(675, 500, 100, 40);
        resetBtn.setVisible(true);
        resetBtn.setForeground(new Color(196, 98, 16));
        resetBtn.setFocusPainted(false);
        resetBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Funktion.reset();
            }
        });

        jFrame.add(resetBtn);

        draw = new Draw();
        draw.setBounds(0,0,800,600);
        draw.setVisible(true);
        jFrame.add(draw);
        jFrame.setVisible(true);
    }
}
