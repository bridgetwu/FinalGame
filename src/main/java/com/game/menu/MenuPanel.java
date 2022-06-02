package com.game.menu;

import com.game.play.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel{

    public MenuPanel(){
        JPanel menupanel = new JPanel();

        menupanel.setVisible(true);
        menupanel.setOpaque(false);

        JButton btn = new ImageBtn("start.png");
        menupanel.add(btn, BorderLayout.SOUTH);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GamePanel();
            }
        });


        menupanel.setBackground(Color.BLACK);
    }
}

