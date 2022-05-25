package com.game.utils;

public class Constants {
    public static class Dimension {
        public static int BOARD_WIDTH = 1000;
        public static int BOARD_HEIGHT = 1000;
    }

    public static class Position {
        public static int BRICK_AMT = 50;
        public static int BOTTOM_LINE = 900;

        public static int BAR_X = Dimension.BOARD_WIDTH / 2;
        public static int BAR_Y = 800;

        public static  int BALL_X = 0;
        public static  int BALL_Y = Dimension.BOARD_HEIGHT * 3 / 4;
    }

}
