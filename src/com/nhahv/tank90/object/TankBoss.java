package com.nhahv.tank90.object;

import com.nhahv.tank90.images.ImagesManager;
import com.nhahv.tank90.models.Models;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

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

    public TankBoss(int x, int y, int size, int type, int orient) {
        super(x, y, size, type, orient);
        setAllListImage();

        int xRandom = new Random().nextInt(3);

        if (xRandom == 0) {
            setX(0);
        } else if (xRandom == 1) {
            setX((Models.NUMBER_COLUMN / 2 - 1) * Models.SIZE_ITEMS_MAPS);
        } else if (xRandom == 2) {
            setX(Models.SIZE_MAPS - Models.SIZE_BOOS);
        }
    }

    private void setAllListImage() {

        mListImageType1 = ImagesManager.getListBoss_1();
        mListImageType2 = ImagesManager.getListBoss_2();
        mListImageType3 = ImagesManager.getListBoss_3();
        mListImageType4 = ImagesManager.getListBoss_4();
        mListImageType5 = ImagesManager.getListBoss_5();
        mListImageType6 = ImagesManager.getListBoss_6();
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(getImages(), getX(), getY(), getSize(), getSize(), null);
    }

    private Image getImages() {

        setAllListImage();
        Image image = mListImageType1.get(Models.UP);

        if (getType() == Models.TYPE_BOSS_1) {
            switch (getOrient()) {
                case Models.UP:
                    image = mListImageType1.get(Models.UP);
                    break;
                case Models.DOWN:
                    image = mListImageType1.get(Models.DOWN);
                    break;
                case Models.LEFT:
                    image = mListImageType1.get(Models.LEFT);
                    break;
                case Models.RIGHT:
                    image = mListImageType1.get(Models.RIGHT);
                    break;
            }
        } else if (getType() == Models.TYPE_BOSS_2) {
            switch (getOrient()) {
                case Models.UP:
                    image = mListImageType2.get(Models.UP);
                    break;
                case Models.DOWN:
                    image = mListImageType2.get(Models.DOWN);
                    break;
                case Models.LEFT:
                    image = mListImageType2.get(Models.LEFT);
                    break;
                case Models.RIGHT:
                    image = mListImageType2.get(Models.RIGHT);
                    break;
            }
        } else if (getType() == Models.TYPE_BOSS_3) {
            switch (getOrient()) {
                case Models.UP:
                    image = mListImageType3.get(Models.UP);
                    break;
                case Models.DOWN:
                    image = mListImageType3.get(Models.DOWN);
                    break;
                case Models.LEFT:
                    image = mListImageType3.get(Models.LEFT);
                    break;
                case Models.RIGHT:
                    image = mListImageType3.get(Models.RIGHT);
                    break;
            }
        } else if (getType() == Models.TYPE_BOSS_4) {
            switch (getOrient()) {
                case Models.UP:
                    image = mListImageType4.get(Models.UP);
                    break;
                case Models.DOWN:
                    image = mListImageType4.get(Models.DOWN);
                    break;
                case Models.LEFT:
                    image = mListImageType4.get(Models.LEFT);
                    break;
                case Models.RIGHT:
                    image = mListImageType4.get(Models.RIGHT);
                    break;
            }
        } else if (getType() == Models.TYPE_BOSS_5) {
            switch (getOrient()) {
                case Models.UP:
                    image = mListImageType5.get(Models.UP);
                    break;
                case Models.DOWN:
                    image = mListImageType5.get(Models.DOWN);
                    break;
                case Models.LEFT:
                    image = mListImageType5.get(Models.LEFT);
                    break;
                case Models.RIGHT:
                    image = mListImageType5.get(Models.RIGHT);
                    break;
            }
        } else if (getType() == Models.TYPE_BOSS_6) {
            switch (getOrient()) {
                case Models.UP:
                    image = mListImageType6.get(Models.UP);
                    break;
                case Models.DOWN:
                    image = mListImageType6.get(Models.DOWN);
                    break;
                case Models.LEFT:
                    image = mListImageType6.get(Models.LEFT);
                    break;
                case Models.RIGHT:
                    image = mListImageType6.get(Models.RIGHT);
                    break;
            }
        }

        return image;
    }
}
