package com.nhahv.tank90.images;

import com.nhahv.tank90.models.Models;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class ImagesManager {

    private static ArrayList<Image> mListPlayer_1;
    private static ArrayList<Image> mListPlayer_2;

    private static ArrayList<Image> mListBoss_1;
    private static ArrayList<Image> mListBoss_2;
    private static ArrayList<Image> mListBoss_3;
    private static ArrayList<Image> mListBoss_4;
    private static ArrayList<Image> mListBoss_5;
    private static ArrayList<Image> mListBoss_6;

    private static ArrayList<Image> mListBulletBig;
    private static ArrayList<Image> mListMaps;
    private static ArrayList<Image> mListItemsHelp;

    public ImagesManager() {

        mListMaps = getImage(Models.ITEMS_MAPS, Models.SIZE_ITEMS_MAPS, Models.SIZE_ITEMS_MAPS, Models.NUMBER_ITEMS_MAPS);
//        mListItemsHelp = getImage(Models.ITEMS_HELP, Models.SIZE_ITEMS_MAPS, Models.SIZE_ITEMS_MAPS, Models.NUMBER_ITEMS_HELP);


        mListPlayer_1 = getImage(Models.PLAY_ONE_ONE, Models.SIZE_TANK_PLAYER, Models.SIZE_TANK_PLAYER, Models.NUMBER_BOOS);
        mListBoss_1 = getImage(Models.BOSS_1, Models.SIZE_BOOS, Models.SIZE_BOOS, Models.NUMBER_BOOS);
        mListBoss_2 = getImage(Models.BOSS_2, Models.SIZE_BOOS, Models.SIZE_BOOS, Models.NUMBER_BOOS);
        mListBoss_3 = getImage(Models.BOSS_3, Models.SIZE_BOOS, Models.SIZE_BOOS, Models.NUMBER_BOOS);
        mListBoss_4 = getImage(Models.BOSS_4, Models.SIZE_BOOS, Models.SIZE_BOOS, Models.NUMBER_BOOS);
        mListBoss_5 = getImage(Models.BOSS_5, Models.SIZE_BOOS, Models.SIZE_BOOS, Models.NUMBER_BOOS);
        mListBoss_6 = getImage(Models.BOSS_6, Models.SIZE_BOOS, Models.SIZE_BOOS, Models.NUMBER_BOOS);

        mListBulletBig = getImage(Models.BULLET_NORMAL_BIG, Models.SIZE_BULLET, Models.SIZE_BULLET, Models.NUMBER_BULLET);
    }

    private ArrayList<Image> getImage(String imgName, int width, int height, int number) {
        ArrayList<Image> listImages = new ArrayList<>();
        try {
            BufferedImage buffReadImage = ImageIO.read(getClass().getResourceAsStream(imgName));
            BufferedImage buffCutImage;
            for (int i = 0; i < number; i++) {
                buffCutImage = buffReadImage.getSubimage(0, i * height, width, height);
                listImages.add(buffCutImage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listImages;
    }

    public static ArrayList<Image> getListMaps() {
        return mListMaps;
    }

    public static ArrayList<Image> getListBoss_6() {
        return mListBoss_6;
    }

    public static ArrayList<Image> getListBoss_5() {
        return mListBoss_5;
    }

    public static ArrayList<Image> getListBoss_4() {
        return mListBoss_4;
    }

    public static ArrayList<Image> getListBoss_3() {
        return mListBoss_3;
    }

    public static ArrayList<Image> getListBoss_2() {
        return mListBoss_2;
    }

    public static ArrayList<Image> getListBoss_1() {
        return mListBoss_1;
    }

    public static ArrayList<Image> getListBulletBig() {
        return mListBulletBig;
    }

    public static ArrayList<Image> getListItemsHelp() {
        return mListItemsHelp;
    }

    public static ArrayList<Image> getListPlayer_1() {
        return mListPlayer_1;
    }
}
