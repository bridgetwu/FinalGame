package com.game.models;

import com.game.utils.GameUtils;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Brick {
    int [][] map;
    int brickWidth;
    int brickHeight;

    private Color[] color = {Color.GREEN, Color.CYAN, Color.YELLOW, Color.ORANGE, Color.PINK, Color.PINK, Color.CYAN, Color.YELLOW, Color.WHITE, Color.BLUE};

    private List<Color> colorList = new LinkedList();

    public Brick(int row, int col) {
        map = new int[row][col];
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[0].length; y++) {
                map [x][y] = 1;
            }
        }

        brickWidth = 750/col;
        brickHeight = 250/row;
    }

    public void draw(Graphics2D graphics2D) {
        randomColor();
        for (int i=0; i < map.length; i++) {
            for (int j=0; j < map[0].length; j++) {
                if (map[i][j] > 0) {
                    graphics2D.setColor(colorList.get(i+j));
                    graphics2D.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);

                    graphics2D.setStroke(new BasicStroke(3));
                    graphics2D.setColor(Color.black);
                    graphics2D.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
                }
            }
        }
    }

    public void setBrickValue(int value, int row, int col) {
        map[row][col] = value;
    }
    private void randomColor() {
        for (int i = 0; i < 48; i++) {
            int index = new Random().nextInt(color.length);
            colorList.add(color[index]);
        }
    }

}

