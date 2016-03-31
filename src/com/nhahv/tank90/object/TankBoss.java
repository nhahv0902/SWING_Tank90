package com.nhahv.tank90.object;

import com.nhahv.tank90.images.ImagesManager;
import com.nhahv.tank90.models.Models;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Nhahv on 3/30/2016.
 */
public class TankBoss extends Tank {

    private ArrayList<Image> mListImageType1;
    private ArrayList<Image> mListImageType2;
    private ArrayList<Image> mListImageType3;
    private ArrayList<Image> mListImageType4;
    private ArrayList<Image> mListImageType5;
    private ArrayList<Image> mListImageType6;

    private int hpTank;


    public TankBoss(int x, int y, int width, int height, int type, int orient, int timeSpeed) {
        super(x, y, width, height, type, orient, timeSpeed);


        mListImageType1 = ImagesManager.getListBoss_1();
        mListImageType2 = ImagesManager.getListBoss_2();
        mListImageType3 = ImagesManager.getListBoss_3();
        mListImageType4 = ImagesManager.getListBoss_4();
        mListImageType5 = ImagesManager.getListBoss_5();
        mListImageType6 = ImagesManager.getListBoss_6();
//        setImagesBossType1();
//        setImagesBossType2();
//        setImagesBossType3();
//        setImagesBossType4();
//        setImagesBossType5();
    }

    public void draw(Graphics2D graphics2D) {

        Image image = getImages();
        graphics2D.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);
    }

    private Image getImages() {
        Image image = mListImageType1.get(Models.TYPE_BOSS_1);

        if (getType() == Models.TYPE_BOSS_1) {
            switch (getOrient()) {
                case Models.UP:
                    image = mListImageType1.get(Models.TYPE_BOSS_1);
                    break;
                case Models.DOWN:
                    image = mListImageType1.get(Models.TYPE_BOSS_2);
                    break;
                case Models.LEFT:
                    image = mListImageType1.get(Models.TYPE_BOSS_3);
                    break;
                case Models.RIGHT:
                    image = mListImageType1.get(Models.TYPE_BOSS_4);
                    break;
            }
        } else if (getType() == Models.TYPE_BOSS_2) {
            switch (getOrient()) {
                case Models.UP:
                    image = mListImageType2.get(Models.TYPE_BOSS_1);
                    break;
                case Models.DOWN:
                    image = mListImageType2.get(Models.TYPE_BOSS_2);
                    break;
                case Models.LEFT:
                    image = mListImageType2.get(Models.TYPE_BOSS_3);
                    break;
                case Models.RIGHT:
                    image = mListImageType2.get(Models.TYPE_BOSS_4);
                    break;
            }
        } else if (getType() == Models.TYPE_BOSS_3) {
            switch (getOrient()) {
                case Models.UP:
                    image = mListImageType3.get(Models.TYPE_BOSS_1);
                    break;
                case Models.DOWN:
                    image = mListImageType3.get(Models.TYPE_BOSS_2);
                    break;
                case Models.LEFT:
                    image = mListImageType3.get(Models.TYPE_BOSS_3);
                    break;
                case Models.RIGHT:
                    image = mListImageType3.get(Models.TYPE_BOSS_4);
                    break;
            }
        } else if (getType() == Models.TYPE_BOSS_4) {
            switch (getOrient()) {
                case Models.UP:
                    image = mListImageType4.get(Models.TYPE_BOSS_1);
                    break;
                case Models.DOWN:
                    image = mListImageType4.get(Models.TYPE_BOSS_2);
                    break;
                case Models.LEFT:
                    image = mListImageType4.get(Models.TYPE_BOSS_3);
                    break;
                case Models.RIGHT:
                    image = mListImageType4.get(Models.TYPE_BOSS_4);
                    break;
            }
        } else if (getType() == Models.TYPE_BOSS_5) {
            switch (getOrient()) {
                case Models.UP:
                    image = mListImageType5.get(Models.TYPE_BOSS_1);
                    break;
                case Models.DOWN:
                    image = mListImageType5.get(Models.TYPE_BOSS_2);
                    break;
                case Models.LEFT:
                    image = mListImageType5.get(Models.TYPE_BOSS_3);
                    break;
                case Models.RIGHT:
                    image = mListImageType5.get(Models.TYPE_BOSS_4);
                    break;
            }
        } else if (getType() == Models.TYPE_BOSS_6) {
            switch (getOrient()) {
                case Models.UP:
                    image = mListImageType6.get(Models.TYPE_BOSS_1);
                    break;
                case Models.DOWN:
                    image = mListImageType6.get(Models.TYPE_BOSS_2);
                    break;
                case Models.LEFT:
                    image = mListImageType6.get(Models.TYPE_BOSS_3);
                    break;
                case Models.RIGHT:
                    image = mListImageType6.get(Models.TYPE_BOSS_4);
                    break;
            }
        }
        return image;
    }

}
