package com.game.play;

import com.game.models.Ball;
import com.game.models.Bar;
import com.game.models.Brick;
import com.game.utils.Constants;

import javax.swing.*;

public class GamePlay extends JFrame {
    private Ball ball;
    private Bar bar;
    private Brick[] bricks;
    private boolean gameOver = false;

    public GamePlay() {
        JPanel menuPanel = new JPanel();
    }

    private void startGame() {
        ball = new Ball();
        bar = new Bar();

        bricks = new Brick[Constants.Position.BRICK_AMT];

        int k = 0;

        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 6; j++) {

                bricks[k] = new Brick(j * 40 + 30, i * 10 + 50);
                k++;
            }
        }
    }

    private void drawObjects() {

    }
}

