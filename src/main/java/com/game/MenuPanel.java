package com.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MenuPanel extends JPanel implements KeyListener {
    Image background;
    public MenuPanel(){
        background = GameUtils.getImage("space.gif").getScaledInstance(Constants.Dimension.BOARD_WIDTH, Constants.Dimension.BOARD_HEIGHT, Image.SCALE_DEFAULT);

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.drawImage(background, 0, 0,this);

        graphics.setColor(Color.ORANGE);
        graphics.setFont(new Font("Courier", Font.BOLD, 75));
        graphics.drawString("Atari Breakout", Constants.Dimension.BOARD_WIDTH / 2 - 250,Constants.Dimension.BOARD_HEIGHT * 3 / 8);

        graphics.setColor(Color.MAGENTA);
        graphics.setFont(new Font("Courier", Font.PLAIN, 25));
        graphics.drawString("(the budget version)", Constants.Dimension.BOARD_WIDTH / 2 - 100,Constants.Dimension.BOARD_HEIGHT * 7 / 16);

        graphics.setColor(Color.YELLOW);
        graphics.setFont(new Font("Courier", Font.PLAIN, 25));
        graphics.drawString("Press space bar to start", Constants.Dimension.BOARD_WIDTH / 2 - 125,Constants.Dimension.BOARD_HEIGHT * 3 / 4);

        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font("Courier", Font.PLAIN, 10));
        graphics.drawString("Background from Gifer.com", Constants.Dimension.BOARD_WIDTH - 150,Constants.Dimension.BOARD_HEIGHT * 15 / 16);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            Main.repaintGamePanel(Main.menuPanel, true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

