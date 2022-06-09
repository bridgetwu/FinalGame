package com.game.menu;

import com.game.utils.Constants;
import com.game.utils.GameUtils;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel{
    Image background;
    public MenuPanel(){
        background = GameUtils.getImage("space.gif").getScaledInstance(Constants.Dimension.BOARD_WIDTH, Constants.Dimension.BOARD_HEIGHT, Image.SCALE_DEFAULT);

        this.setLayout(null);
        this.add(new Button());
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.drawImage(background, 0, 0,this);
    }
}

