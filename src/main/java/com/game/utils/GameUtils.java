package com.game.utils;

import javax.swing.*;
import java.awt.*;

public class GameUtils {
    public static ImageIcon getImageIcon(String imageName) {
        return new ImageIcon(Toolkit.getDefaultToolkit().getImage(GameUtils.class.getResource("/"+ imageName)));
    }
}
