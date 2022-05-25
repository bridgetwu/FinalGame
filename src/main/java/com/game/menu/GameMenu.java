package com.game.menu;

import javax.swing.*;
import java.awt.*;

public class GameMenu {
    private JFrame menuFrame;
    public GameMenu(JFrame jframe){
        this.menuFrame = jframe;

        JPanel menuPanel = new JPanel();
        this.menuFrame.getContentPane().add(menuPanel, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel();
        JButton btn = new ImageBtn("start.png");
        btnPanel.add(btn);
        this.menuFrame.getContentPane().add(btnPanel, BorderLayout.SOUTH);
        btn.addActionListener(e -> {
            System.out.print("it work");
        });

        this.menuFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.menuFrame.setVisible(true);
    }
}

