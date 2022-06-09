package com.game;

import com.game.menu.MenuPanel;
import com.game.play.GamePanel;
import com.game.utils.Constants;

import javax.swing.*;

public class Main {

    public static JFrame jframe = new JFrame("GAME");
    public static MenuPanel menuPanel = new MenuPanel();
    public static GamePanel gamePanel = new GamePanel();

    public static void main(String[] args) {
        initialGameJFrame();
    }
    public static void initialGameJFrame() {
        jframe.setSize(Constants.Dimension.BOARD_WIDTH, Constants.Dimension.BOARD_HEIGHT);

        jframe.setTitle("Breakout Game");
        jframe.setResizable(false);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setVisible(true);
        jframe.setFocusTraversalKeysEnabled(true);

        jframe.getContentPane().add(menuPanel);
    }

    public static void repaintGamePanel(JPanel jpanel, boolean isVisable) {
        if(isVisable) {
            Main.jframe.remove(jpanel);
        }
        jframe.getContentPane().add(gamePanel);

        gamePanel.setFocusable(true);
        gamePanel.requestFocusInWindow();

        gamePanel.setVisible(isVisable);
        jframe.validate();
        jframe.repaint();
    }
}