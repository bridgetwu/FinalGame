package com.game.menu;

import com.game.utils.GameUtils;

import javax.swing.*;

public class ImageBtn extends JButton {
    public ImageBtn(String imageName) {
        super(GameUtils.getImageIcon(imageName));
    }

}
