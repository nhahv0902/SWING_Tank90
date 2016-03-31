package com.nhahv.tank90.object;

import com.nhahv.tank90.images.ImageIcons;
import com.nhahv.tank90.models.Models;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Nhahv on 3/30/2016.
 */
public class TankPlayer extends Tank {

    private ArrayList<Image> mListTankOne;
    private ArrayList<Image> mListTankTwo;
    private ArrayList<Image> mListTankOneBig;
    private ArrayList<Image> mListTankTwoBig;

    public TankPlayer(int x, int y, int width, int height, int type, int orient, int timeSpeed) {
        super(x, y, width, height, type, orient, timeSpeed);
        setListTankOne();
        setListTankTwo();
        type = Models.TYPE_PLAYER_1;


        setY(Models.START_PLAYER_HEIGHT);
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

    private void setListTankOneBig() {
        mListTankOneBig = new ArrayList<>();
        Image image = new ImageIcons(Models.PLAY_ONE_UP_BIG).getImage();

        mListTankOneBig.add(image);
        image = new ImageIcons(Models.PLAY_ONE_DOWN_BIG).getImage();
        mListTankOneBig.add(image);

        image = new ImageIcons(Models.PLAY_ONE_LEFT_BIG).getImage();
        mListTankOneBig.add(image);

        image = new ImageIcons(Models.PLAY_ONE_RIGHT_BIG).getImage();
        mListTankOneBig.add(image);
    }

    private void setListTankTwoBig() {
        mListTankTwoBig = new ArrayList<>();
        Image image = new ImageIcons(Models.PLAY_TWO_UP_BIG).getImage();

        mListTankTwoBig.add(image);
        image = new ImageIcons(Models.PLAY_TWO_DOWN_BIG).getImage();
        mListTankTwoBig.add(image);

        image = new ImageIcons(Models.PLAY_TWO_LEFT_BIG).getImage();
        mListTankTwoBig.add(image);

        image = new ImageIcons(Models.PLAY_TWO_RIGHT_BIG).getImage();
        mListTankTwoBig.add(image);
    }

    public void draw(Graphics2D graphics2D) {

        Image image = mListTankOne.get(0);
        if (getType() == Models.TYPE_PLAYER_1) {
            switch (getOrient()) {
                case Models.UP:
                    image = mListTankOne.get(Models.UP);
                    break;
                case Models.DOWN:
                    image = mListTankOne.get(Models.DOWN);
                    break;
                case Models.LEFT:
                    image = mListTankOne.get(Models.LEFT);
                    break;
                case Models.RIGHT:
                    image = mListTankOne.get(Models.RIGHT);
                    break;
            }
        } else if (getType() == Models.TYPE_PLAYER_2) {
            switch (getOrient()) {
                case Models.UP:
                    image = mListTankTwo.get(Models.UP);
                    break;
                case Models.DOWN:
                    image = mListTankTwo.get(Models.DOWN);
                    break;
                case Models.LEFT:
                    image = mListTankTwo.get(Models.LEFT);
                    break;
                case Models.RIGHT:
                    image = mListTankTwo.get(Models.RIGHT);
                    break;
            }
        }

        graphics2D.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);
    }
}
