package com.game.utils;

import com.game.Main;
import com.game.play.GamePanel;

import javax.swing.*;
import java.awt.*;

public class GameUtils {
    public static ImageIcon getImageIcon(String imageName) {
        return new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameUtils.class.getResource("/"+ imageName)));
    }

    public static Image getImage(String imageName) {
        return Toolkit.getDefaultToolkit().getImage(GameUtils.class.getResource("/"+ imageName));
    }

}
