package com.game.menu;

import com.game.Main;
import com.game.play.GamePanel;
import com.game.utils.Constants;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {

    public Button() {
        super("START");
        this.setFont(new Font("Courier", Font.PLAIN, 25));
        this.setFocusable(false);

        this.setBounds((Constants.Dimension.BOARD_WIDTH - Constants.Dimension.BTN_WIDTH) / 2,Constants.Dimension.BOARD_HEIGHT * 3 / 4, Constants.Dimension.BTN_WIDTH, Constants.Dimension.BTN_HEIGHT);
        this.addActionListener(e -> {
            switchPanel();
        });
    }

    public void switchPanel(){
        Main.jframe.remove(Main.menuPanel);
        Main.jframe.add(new GamePanel());
        Main.jframe.validate();
        Main.jframe.repaint();
    }

}
