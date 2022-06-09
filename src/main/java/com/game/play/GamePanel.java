package com.game.play;

import com.game.models.Brick;
import com.game.utils.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GamePanel extends JPanel implements KeyListener, ActionListener {
    private boolean gameOver = false;

    private int score = 0;

    private int brickRows = 5;
    private int brickColumns = 10;
    private int totalBricks = brickColumns * brickRows;


    private Timer timer;

    private int player_x = Constants.Dimension.BOARD_WIDTH / 2;
    private int ball_x = Constants.Dimension.BOARD_WIDTH / 2;
    private int ball_y = Constants.Dimension.BOARD_HEIGHT * 3 / 4;

    private int ball_x_dir = -1;
    private int ball_y_dir = -2;

    private int player_x_move = 25;

    private Brick brick;

    public GamePanel() {
        brick = new Brick(brickRows, brickColumns);

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(2, this);
        timer.start();
    }

    public void paintComponent(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, Constants.Dimension.BOARD_WIDTH, Constants.Dimension.BOARD_HEIGHT);

        brick.draw((Graphics2D) graphics);

        graphics.setColor(Color.YELLOW);
        graphics.setFont(new Font("Courier", Font.BOLD, 25));
        graphics.drawString("" + score, Constants.Dimension.BOARD_WIDTH - 100, 50);

        graphics.setColor(Color.YELLOW);
        graphics.fillRect(player_x, Constants.Position.BAR_Y, 100, 10);

        graphics.setColor(Color.RED);
        graphics.fillOval(ball_x, ball_y, 20, 20);

        gameOver(graphics);
        levelComplete(graphics);

        graphics.dispose();
    }

    public void actionPerformed(ActionEvent e) {
        timer.start();

        if (!gameOver) {
            moveBall();
            ballBrickCollision();
            ballPaddleCollision();
        }

        repaint();
    }


    public void keyTyped(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (player_x >= Constants.Dimension.BOARD_WIDTH - 125) {
                player_x = Constants.Dimension.BOARD_WIDTH - 125;
            } else {
                moveRight();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (player_x < 10) {
                player_x = 10;
            } else {
                moveLeft();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (gameOver) {
                gameOver = false;
                ball_x = Constants.Dimension.BOARD_WIDTH / 2;
                ball_y = Constants.Dimension.BOARD_HEIGHT * 3 / 4;
                ball_x_dir = -1;
                ball_y_dir = -2;

                score = 0;
                totalBricks = brickRows * brickColumns;

                brick = new Brick(brickRows, brickColumns);
                repaint();
            }
        }
    }

    private void moveRight() {
        gameOver = false;
        player_x += player_x_move;

    }

    private void moveLeft() {
        gameOver = false;
        player_x -= player_x_move;
    }

    private void moveBall() {
        ball_x += ball_x_dir;
        ball_y += ball_y_dir;

        if (ball_x < 0 || ball_x > Constants.Dimension.BOARD_WIDTH) {
            ball_x_dir = -ball_x_dir;
        }

        if (ball_y < 0) {
            ball_y_dir = -ball_y_dir;
        }
    }

    private void ballPaddleCollision() {
        if ((new Rectangle(ball_x, ball_y, 20, 20).intersects(new Rectangle(player_x, Constants.Position.BAR_Y, 100, 8))) || new Rectangle(ball_x, ball_y, 20, 20).intersects(new Rectangle(player_x + 30, Constants.Position.BAR_Y, 40, 8))) {
            ball_y_dir = -ball_y_dir;
            speedUp();
        } else if (new Rectangle(ball_x, ball_y, 20, 20).intersects(new Rectangle(player_x + 70, Constants.Position.BAR_Y, 30, 8))) {
            ball_y_dir = -ball_y_dir;
            ball_x_dir += 1;
            speedUp();
        }
    }

    private void ballBrickCollision() {
        A:
        for (int i = 0; i < brick.map.length; i++) {
            for (int j = 0; j < brick.map[0].length; j++) {

                if (brick.map[i][j] > 0) {
                    int brickX = j * brick.brickWidth + 80;
                    int brickY = i * brick.brickHeight + 50;
                    int brickWidth = brick.brickWidth;
                    int brickHeight = brick.brickHeight;

                    Rectangle brickRect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
                    Rectangle ballHitBox = new Rectangle(ball_x, ball_y, 20, 20);

                    if (ballHitBox.intersects(brickRect)) {
                        brick.setBrickValue(0, i, j);
                        score += 1;
                        totalBricks--;

                        if (ball_x + 19 <= brickRect.x || ball_x + 1 >= brickRect.x + brickRect.width) {
                            ball_x_dir = -ball_x_dir;
                            speedUp();
                        } else {
                            ball_y_dir = -ball_y_dir;
                            speedUp();
                        }
                        break A;
                    }
                }
            }
        }
    }

    private void gameOver(Graphics graphics) {
        if (ball_y > Constants.Position.BOTTOM_LINE) {
            gameOver = true;
            ball_x_dir = 0;
            ball_y_dir = 0;

            graphics.setColor(Color.RED);
            graphics.setFont(new Font("Courier", Font.BOLD, 32));
            graphics.drawString("Game Over! Score: " + score, (Constants.Dimension.BOARD_WIDTH / 2) - 200, Constants.Dimension.BOARD_HEIGHT / 2);
            graphics.setColor(Color.WHITE);
            graphics.setFont(new Font("Courier", Font.PLAIN, 20));
            graphics.drawString("Press space bar to play again", (Constants.Dimension.BOARD_WIDTH / 2) - 150, Constants.Dimension.BOARD_HEIGHT * 3 / 4);

        }
    }

    private void levelComplete(Graphics graphics) {
        if (totalBricks == 0) {
            graphics.setColor(Color.WHITE);
            graphics.setFont(new Font("Courier", Font.BOLD, 32));
            graphics.drawString("Level Complete! Score: " + score, (Constants.Dimension.BOARD_WIDTH / 2) - 300, Constants.Dimension.BOARD_HEIGHT);
            gameOver = true;
        }
    }

    private void speedUp() {
        ball_x_dir *= 1.05;
        ball_y_dir *= 1.05;
    }
}