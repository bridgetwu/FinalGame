package com.game;

import com.game.menu.GameMenu;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame menuFrame = new JFrame("GAME");
        menuFrame.setSize(1000, 1000);
        menuFrame.setVisible(true);
        new GameMenu(menuFrame);
    }
}