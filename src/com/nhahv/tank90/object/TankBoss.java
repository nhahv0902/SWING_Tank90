package com.nhahv.tank90.object;

import com.nhahv.tank90.images.ImageIcons;
import com.nhahv.tank90.maps.Bird;
import com.nhahv.tank90.maps.MapsManagers;
import com.nhahv.tank90.models.Models;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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

    private ArrayList<Image> mListImages;
    private Image mImage;

    private int hpTank;

    public TankBoss(int x, int y, int size, int type, int orient) {
        super(x, y, size, type, orient);

        setTankPlay(false);
        // tao list image boss
        setListImages();
        setListImageShow();

        int xRandom = new Random().nextInt(3);
        if (xRandom == 0) {
            setX(0);
        } else if (xRandom == 1) {
            setX((Models.NUMBER_COLUMN / 2 - 1) * Models.SIZE_ITEMS_MAPS);
        } else if (xRandom == 2) {
            setX(Models.SIZE_MAPS - Models.SIZE_BOOS);
        }
    }

    @Override
    public void remove() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    setImage(new ImageIcons("/IMAGES/bomb_wall.png").getImage());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        setX(-100);
        setY(-100);
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(getImages(), getX(), getY(), getSize(), getSize(), null);
    }

    private Image getImages() {

        setListImageShow();
        mImage = mListImages.get(Models.UP);

        switch (getOrient()) {
            case Models.UP:
                mImage = mListImages.get(Models.UP);
                break;
            case Models.DOWN:
                mImage = mListImages.get(Models.DOWN);
                break;
            case Models.LEFT:
                mImage = mListImages.get(Models.LEFT);
                break;
            case Models.RIGHT:
                mImage = mListImages.get(Models.RIGHT);
                break;
        }

        return mImage;
    }

    private void setListImageShow() {
        switch (getType()) {
            case Models.TYPE_BOSS_1:
                mListImages = mListImageType1;
                break;
            case Models.TYPE_BOSS_2:
                mListImages = mListImageType2;
                break;
            case Models.TYPE_BOSS_3:
                mListImages = mListImageType3;
                break;
            case Models.TYPE_BOSS_4:
                mListImages = mListImageType4;
                break;
            case Models.TYPE_BOSS_5:
                mListImages = mListImageType5;
                break;
            case Models.TYPE_BOSS_6:
                mListImages = mListImageType6;
                break;
        }
    }

    public void move(MapsManagers mapsManagers, Bird bird) {

        switch (getOrient()) {
            case Models.UP:
                if (getY() > 0) {
                    setY(getY() - getSpeedMode());
                    if (isIntersect(mapsManagers, bird)) {
                        setY(getY() + getSpeedMode());

                        this.setOrient(Models.DOWN);
                        this.mImage = mListImages.get(Models.DOWN);

                    }
                }
                if (getY() <= 0) {
                    this.setOrient(Models.DOWN);
                    this.mImage = mListImages.get(Models.DOWN);
                }
                break;
            case Models.DOWN:
                if (getY() < Models.SIZE_MAPS - getSize()) {
                    setY(getY() + getSpeedMode());
                    if (isIntersect(mapsManagers, bird)) {
                        setY(getY() - getSpeedMode());

                        this.setOrient(Models.UP);
                        this.mImage = mListImages.get(Models.UP);

                    }
                }
                if (getY() >= Models.SIZE_MAPS - getSize()) {
                    this.setOrient(Models.UP);
                    this.mImage = mListImages.get(Models.UP);
                }

                break;
            case Models.LEFT:
                if (getX() > 0) {
                    setX(getX() - getSpeedMode());
                    if (isIntersect(mapsManagers, bird)) {
                        setX(getX() + getSpeedMode());

                        this.setOrient(Models.RIGHT);
                        this.mImage = mListImages.get(Models.RIGHT);

                    }
                }
                if (getX() <= 0) {
                    this.setOrient(Models.RIGHT);
                    this.mImage = mListImages.get(Models.RIGHT);
                }

                break;
            case Models.RIGHT:
                if (getX() < Models.SIZE_MAPS - getSize()) {
                    setX(getX() + getSpeedMode());
                    if (isIntersect(mapsManagers, bird)) {
                        setX(getX() - getSpeedMode());

                        this.setOrient(Models.LEFT);
                        this.mImage = mListImages.get(Models.LEFT);

                    }
                }
                if (getX() >= Models.SIZE_MAPS - getSize()) {
                    this.setOrient(Models.LEFT);
                    this.mImage = mListImages.get(Models.LEFT);
                }

                break;
        }
    }

    private void setListImages() {
        mListImageType1 = getListImages(Models.BOSS_1);
        mListImageType2 = getListImages(Models.BOSS_2);
        mListImageType3 = getListImages(Models.BOSS_3);
        mListImageType4 = getListImages(Models.BOSS_4);
        mListImageType5 = getListImages(Models.BOSS_5);
        mListImageType6 = getListImages(Models.BOSS_6);
    }

    private ArrayList<Image> getListImages(String name) {
        ArrayList<Image> listImages = new ArrayList<>();
        try {
            BufferedImage buffReadImage = ImageIO.read(new File("src" + name));
            BufferedImage buffCutImage;
            for (int i = 0; i < Models.NUMBER_BOOS; i++) {
                buffCutImage = buffReadImage.getSubimage(0, i * getSize(), getSize(), getSize());
                listImages.add(buffCutImage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listImages;
    }
}
