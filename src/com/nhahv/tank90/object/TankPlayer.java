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

/**
 * Created by Nhahv on 3/30/2016.
 */
public class TankPlayer extends Tank {

    private ArrayList<Image> mListTankOne;
    private ArrayList<Image> mListTankTwo;
    private ArrayList<Image> mListTankOneBig;
    private ArrayList<Image> mListTankTwoBig;
    private ArrayList<Image> mListTank;

    //    private int speedMode;
    private int life;

    public TankPlayer(int x, int y, int size, int type, int orient) {
        super(x, y, size, type, orient);

        type = Models.TYPE_PLAYER_1;
        setTankPlay(true);
        setY(Models.SIZE_MAPS - Models.SIZE_TANK_PLAYER);

        mListTank = new ArrayList<>();
        setListTankOne();
        setListTankTwo();

        mListTankOneBig = setListImages(Models.PLAY_ONE_ONE);
        mListTankTwoBig = setListImages(Models.PLAY_ONE_TWO);
        setListImagesShow();

        if (type == Models.TYPE_PLAYER_1) {
            setX(Models.START_PLAYER_ONE);
        } else {
            setX(Models.START_PLAYER_TWO);
        }
    }

    private void setListTankOne() {
        mListTankOne = new ArrayList<>();
        Image image = new ImageIcons(Models.PLAY_ONE_UP).getImage();
        mListTankOne.add(image);

        image = new ImageIcons(Models.PLAY_ONE_DOWN).getImage();
        mListTankOne.add(image);

        image = new ImageIcons(Models.PLAY_ONE_LEFT).getImage();
        mListTankOne.add(image);

        image = new ImageIcons(Models.PLAY_ONE_RIGHT).getImage();
        mListTankOne.add(image);
    }

    private void setListTankTwo() {
        mListTankTwo = new ArrayList<>();
        Image image = new ImageIcons(Models.PLAY_TWO_UP).getImage();
        mListTankTwo.add(image);

        image = new ImageIcons(Models.PLAY_TWO_DOWN).getImage();
        mListTankTwo.add(image);

        image = new ImageIcons(Models.PLAY_TWO_LEFT).getImage();
        mListTankTwo.add(image);

        image = new ImageIcons(Models.PLAY_TWO_RIGHT).getImage();
        mListTankTwo.add(image);
    }

    public void draw(Graphics2D graphics2D) {

        setListImagesShow();
        Image image = mListTank.get(Models.UP);
        switch (getOrient()) {
            case Models.UP:
                image = mListTank.get(Models.UP);
                break;
            case Models.DOWN:
                image = mListTank.get(Models.DOWN);
                break;
            case Models.LEFT:
                image = mListTank.get(Models.LEFT);
                break;
            case Models.RIGHT:
                image = mListTank.get(Models.RIGHT);
                break;
        }

        setImage(image);
        graphics2D.drawImage(getImage(), getX(), getY(), getSize(), getSize(), null);
        for (Bullet bullet : getListBullets()) {
            bullet.draw(graphics2D);
        }
    }

    public void move(MapsManagers mapsManagers, Bird bird) {

        switch (getOrient()) {
            case Models.UP:
                if (getY() > 0) {
                    setY(getY() - getSpeedMode());
                    if (isIntersect(mapsManagers, bird)) {
                        setY(getY() + getSpeedMode());
                    }
                }
                break;
            case Models.DOWN:
                if (getY() < Models.SIZE_MAPS - getSize()) {
                    setY(getY() + getSpeedMode());
                    if (isIntersect(mapsManagers, bird)) {
                        setY(getY() - getSpeedMode());
                    }
                }
                break;
            case Models.LEFT:
                if (getX() > 0) {
                    setX(getX() - getSpeedMode());
                    if (isIntersect(mapsManagers, bird)) {
                        setX(getX() + getSpeedMode());
                    }
                }
                break;
            case Models.RIGHT:
                if (getX() < Models.SIZE_MAPS - getSize()) {
                    setX(getX() + getSpeedMode());
                    if (isIntersect(mapsManagers, bird)) {
                        setX(getX() - getSpeedMode());
                    }
                }
                break;
        }
    }

    private void setListImagesShow() {
        setType(Models.PLAYER_12);
        switch (getType()) {
            case Models.PLAYER_11:
                mListTank = mListTankOne;
                break;
            case Models.PLAYER_12:
                mListTank = mListTankOneBig;
                break;
            case Models.PLAYER_21:
                mListTank = mListTankTwo;
                break;
            case Models.PLAYER_22:
                mListTank = mListTankTwoBig;
                break;
        }
    }

    private ArrayList<Image> setListImages(String name) {
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

    @Override
    public void remove() {
        setY(Models.SIZE_MAPS - Models.SIZE_TANK_PLAYER);
        if (getType() == Models.TYPE_PLAYER_1) {
            setX(Models.START_PLAYER_ONE);
        } else {
            setX(Models.START_PLAYER_TWO);
        }
    }
}
