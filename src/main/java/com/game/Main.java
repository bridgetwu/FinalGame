package com.game;

import com.game.menu.ImageBtn;
import com.game.menu.MenuPanel;
import com.game.play.GamePanel;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame jframe = new JFrame("GAME");
        jframe.setSize(1000, 1000);

        jframe.setBounds(10, 10, 700, 600);
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
        jframe.setTitle("Breakout Game");
        jframe.setResizable(false);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //jframe.add(new MenuPanel());
        jframe.getContentPane().add(new GamePanel());
    }
}