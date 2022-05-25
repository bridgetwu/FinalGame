package com.game.models;

import com.game.utils.GameUtils;

import javax.swing.*;

public class Brick extends Dimensions {
    private boolean wasHit;

    public Brick(int x, int y) {
        this.x = x;
        this.y = y;

        wasHit = false;
        loadBrick();
    }

    private void loadBrick () {
        GameUtils.getImageIcon("brick.png");
        var m = new ImageIcon("C:\\Coding\\AP_CSA_Final\\icons\\brick.png");
        m.getImage();
    }
}

