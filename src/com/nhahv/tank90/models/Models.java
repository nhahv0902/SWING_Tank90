package com.nhahv.tank90.models;

import java.awt.*;

/**
 * Created by Nhahv on 3/28/2016.
 */
public class Models {

    public static final int UP = 0;
    public static final int DOWN = 1;
    public static final int LEFT = 2;
    public static final int RIGHT = 3;

    public static final int WIDTH = // 1366
            (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    public static final int HEIGHT = //768
            (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    public static final String MENU_GAME = "0";
    public static final String PLAY_GAME = "1";

    public static final String PLAY = "PLAY";
    public static final String EXIT = "EXIT";


    public static final String TITLE = "TANK 1990";
    public static final String ICONS_PLAY_ONE = "/IMAGES/icon_play_one.png";
    public static final String ICONS_PLAY_ONE_OFF = "/IMAGES/icon_play_one_off.png";
    public static final String ICONS_PLAY_TWO = "/IMAGES/icon_play_two.png";
    public static final String ICONS_PLAY_TWO_OFF = "/IMAGES/icon_play_two_off.png";
    public static final String ICON_BT_PLAY = "/IMAGES/icons.png";
    public static final String ICON_DOCUMENTS = "/IMAGES/icon_document.png";
    public static final String ICON_MENU = "/IMAGES/icon_guide_menu.png";

    public static final String ICON_RUN_UP = "/IMAGES/icons_run_up.png";
    public static final String ICON_RUN_DOWN = "/IMAGES/icons_run_down.png";
    public static final String ICON_RUN_LEFT = "/IMAGES/icons_run_left.png";
    public static final String ICON_RUN_RIGHT = "/IMAGES/icons_run_right.png";

    public static final String ICONS_GUIDE_LEFT = "/IMAGES/icon_guide_left.png";
    public static final String ICONS_GUIDE_RIGHT = "/IMAGES/icon_guide_right.png";
    public static final String ITEMS_BIRD = "/IMAGES/icons_bird.png";
    public static final String ICONS_FACE_MENU = "/IMAGES/icon_face_menu.png";

    public static final String ITEMS_MAPS = "/IMAGES/items_maps.png";
    public static final String ITEMS_HELP = "/IMAGES/items_help.png";

    public static final String BOSS_1 = "/IMAGES/boss_1.png";
    public static final String BOSS_2 = "/IMAGES/boss_2.png";
    public static final String BOSS_3 = "/IMAGES/boss_3.png";
    public static final String BOSS_4 = "/IMAGES/boss_4.png";
    public static final String BOSS_5 = "/IMAGES/boss_5.png";
    public static final String BOSS_6 = "/IMAGES/boss_6.png";

    public static final String CLOSE_WINDOWS = "Close Game";

    public static final String BULLET_NORMAL_UP = "/IMAGES/bullet_up.png";
    public static final String BULLET_NORMAL_DOWN = "/IMAGES/bullet_down.png";
    public static final String BULLET_NORMAL_LEFT = "/IMAGES/bullet_left.png";
    public static final String BULLET_NORMAL_RIGHT = "/IMAGES/bullet_right.png";
    public static final String BULLET_BIG = "/IMAGES/bullet_big.png";

    public static final String PLAY_TWO_UP = "/IMAGES/player_two_up.png";
    public static final String PLAY_TWO_DOWN = "/IMAGES/player_two_down.png";
    public static final String PLAY_TWO_LEFT = "/IMAGES/player_two_left.png";
    public static final String PLAY_TWO_RIGHT = "/IMAGES/player_two_right.png";

    public static final String PLAY_ONE_UP = "/IMAGES/player_one_up.png";
    public static final String PLAY_ONE_DOWN = "/IMAGES/player_one_down.png";
    public static final String PLAY_ONE_LEFT = "/IMAGES/player_one_left.png";
    public static final String PLAY_ONE_RIGHT = "/IMAGES/player_one_right.png";


    public static final String PLAY_ONE_ONE = "/IMAGES/player_one.png";
    public static final String PLAY_ONE_TWO = "/IMAGES/player_two.png";

    public static final int PADDING_TANK = 6;


    // type of player
    public static final int TYPE_PLAYER_1 = 0;
    public static final int TYPE_PLAYER_2 = 1;

    // type of boss
    public static final int TYPE_BOSS_1 = 0;
    public static final int TYPE_BOSS_2 = 1;
    public static final int TYPE_BOSS_3 = 2;
    public static final int TYPE_BOSS_4 = 3;
    public static final int TYPE_BOSS_5 = 4;
    public static final int TYPE_BOSS_6 = 5;

    public static final int SIZE_BOOS = 56;
    public static final int NUMBER_BOOS = 4;

    public static final int SIZE_ITEMS_MAPS = 28;
    public static final int NUMBER_ITEMS_MAPS = 6;
    public static final int NUMBER_COLUMN = 26;

    public static final int TYPE_ITEMS_1 = 0;
    public static final int TYPE_ITEMS_2 = 1;
    public static final int TYPE_ITEMS_3 = 2;
    public static final int TYPE_ITEMS_4 = 3;
    public static final int TYPE_ITEMS_5 = 4;
    public static final int TYPE_ITEMS_6 = 5;

    public static final int MAPS_CROSS = 0;
    public static final int MAPS_NO_CROSS = 1;
    public static final int MAPS_BREAK = 2;
//    public static final int MAPS_CROSS = 0;


    public static final int TYPE_HELP_1 = 0;
    public static final int TYPE_HELP_2 = 1;
    public static final int TYPE_HELP_3 = 2;
    public static final int TYPE_HELP_4 = 3;
    public static final int TYPE_HELP_5 = 4;
    public static final int TYPE_HELP_6 = 5;
    public static final int TYPE_HELP_7 = 6;


    //    public static final int SIZE_BULLET = 16;
    public static final int SIZE_BULLET = 14;
    public static final int NUMBER_BULLET = 4;
    public static final int TYPE_BULLET_NORMAL = 0;
    public static final int TYPE_BULLET_BIG = 1;

    public static final int PADDING_LEFT = 69;
    public static final int PADDING_TOP = 20;

    public static final int WIDTH_GUIDE = 250;
    public static final int SIZE_MAPS = 728;

    public static final int START_PLAYER_ONE = 8 * SIZE_ITEMS_MAPS;
    public static final int START_PLAYER_TWO = 16 * SIZE_ITEMS_MAPS;

    public static final int SPEED_DEFAULT = 1;
    public static final int SPEED_MAX = 2;
    public static final int TIME_SPEED_MAX = 15;

    public static final int TIME_FIRE_NORMAL = 2;
    public static final int TIME_FIRE_MAX = 1;
    public static final int SPEED_BULLET_NORMAL = 1;
    public static final int SPEED_BULLET_MAX = 2;

    public static final int TIME_OUT = 800;
    public static final int TIME_SLEEP = 6;

    public static final int SIZE_TANK_PLAYER = 56;
    public static final int SIZE_TANK_RUN = 70;

    public static final int SIZE_ITEMS = 28;

    public static final int PLAYER_11 = 0;
    public static final int PLAYER_12 = 1;
    public static final int PLAYER_21 = 2;
    public static final int PLAYER_22 = 3;
    public static final String BOMB_BIRD = "/IMAGES/bomb_bird.png";
}
