package com.game.play;

import com.game.models.Brick;
import com.game.utils.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener, ActionListener{
    private boolean gameOver = false;

    private int score = 0;

    private int brickRows = 5;

    private int brickColumns = 10;


    private int totalBricks = brickColumns * brickRows;

    private Timer timer;


    Brick brick = new Brick(brickRows, brickColumns);
    public GamePanel() {
        addKeyListener((this));
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(2, this);
        timer.start();
    }

    public void paint(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, Constants.Dimension.BOARD_WIDTH, Constants.Dimension.BOARD_HEIGHT);
//        graphics.setColor(Color.WHITE);
//        graphics.fillRect(0, 0, 20, 20);
        brick.draw((Graphics2D) graphics);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
//    public void actionPerformed1(ActionEvent e) {
//        timer.start();
//
//        if (play) {
//            // implement logic and check for collisions
//            ballLogic();
//            ballBrickCollision();
//            ballPaddleCollision();
//        }
//
//        repaint();
//    }
}

