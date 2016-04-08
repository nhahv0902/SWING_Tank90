package com.nhahv.tank90.object;

import com.nhahv.tank90.images.ImageIcons;
import com.nhahv.tank90.maps.Bird;
import com.nhahv.tank90.maps.MapsManagers;
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
    private boolean isLive;
    private int numberLive;

    public TankPlayer(int x, int y, int size, int type, int orient) {
        super(x, y, size, type, orient);

        setTankPlay(true);
        setY(Models.SIZE_MAPS - Models.SIZE_TANK_PLAYER);
        setListTankOne();
        setListTankTwo();
        mListTankOneBig = setListImages(Models.PLAY_ONE_ONE);
        mListTankTwoBig = setListImages(Models.PLAY_ONE_TWO);
        setListImagesShow();
        this.isLive = true;
        this.numberLive = Models.NUMBER_BOOS;

        if (type == Models.PLAYER_11 || type == Models.PLAYER_12) {
            setX(Models.START_PLAYER_ONE);
        } else {
            setX(Models.START_PLAYER_TWO);
        }
    }

    private void setListTankOne() {
        mListTankOne = new ArrayList<>();
        mListTankOne.add(new ImageIcons(Models.PLAY_ONE_UP).getImage());
        mListTankOne.add(new ImageIcons(Models.PLAY_ONE_DOWN).getImage());
        mListTankOne.add(new ImageIcons(Models.PLAY_ONE_LEFT).getImage());
        mListTankOne.add(new ImageIcons(Models.PLAY_ONE_RIGHT).getImage());
    }

    private void setListTankTwo() {
        mListTankTwo = new ArrayList<>();
        mListTankTwo.add(new ImageIcons(Models.PLAY_TWO_UP).getImage());
        mListTankTwo.add(new ImageIcons(Models.PLAY_TWO_DOWN).getImage());
        mListTankTwo.add(new ImageIcons(Models.PLAY_TWO_LEFT).getImage());
        mListTankTwo.add(new ImageIcons(Models.PLAY_TWO_RIGHT).getImage());
    }

    public void draw(Graphics2D graphics2D) {

        setImagesOrient();
        graphics2D.drawImage(getImage(), getX(), getY(), getSize(), getSize(), null);
        for (Bullet bullet : getListBullets()) {
            bullet.draw(graphics2D);
        }
    }

    public void setImagesOrient() {
        switch (getOrient()) {
            case Models.UP:
                setImage(getListTank().get(Models.UP));
                break;
            case Models.DOWN:
                setImage(getListTank().get(Models.DOWN));
                break;
            case Models.LEFT:
                setImage(getListTank().get(Models.LEFT));
                break;
            case Models.RIGHT:
                setImage(getListTank().get(Models.RIGHT));
                break;
        }
    }

    public void move(MapsManagers mapsManagers, Bird bird, ManagerTankBoss managerTankBoss) {

        switch (getOrient()) {
            case Models.UP:
                if (getY() > 0) {
                    setY(getY() - getSpeedMode());
                    if (isIntersect(mapsManagers, bird, managerTankBoss)) {
                        setY(getY() + getSpeedMode());
                    }
                }
                break;
            case Models.DOWN:
                if (getY() < Models.SIZE_MAPS - getSize()) {
                    setY(getY() + getSpeedMode());
                    if (isIntersect(mapsManagers, bird, managerTankBoss)) {
                        setY(getY() - getSpeedMode());
                    }
                }
                break;
            case Models.LEFT:
                if (getX() > 0) {
                    setX(getX() - getSpeedMode());
                    if (isIntersect(mapsManagers, bird, managerTankBoss)) {
                        setX(getX() + getSpeedMode());
                    }
                }
                break;
            case Models.RIGHT:
                if (getX() < Models.SIZE_MAPS - getSize()) {
                    setX(getX() + getSpeedMode());
                    if (isIntersect(mapsManagers, bird, managerTankBoss)) {
                        setX(getX() - getSpeedMode());
                    }
                }
                break;
        }
    }

    private void setListImagesShow() {
        switch (getType()) {
            case Models.PLAYER_11:
                setListTank(mListTankOne);
                break;
            case Models.PLAYER_12:
                setListTank(mListTankOneBig);
                break;
            case Models.PLAYER_21:
                setListTank(mListTankTwo);
                break;
            case Models.PLAYER_22:
                setListTank(mListTankTwoBig);
                break;
        }
    }

    public void remove() {
        setY(Models.SIZE_MAPS - Models.SIZE_TANK_PLAYER);
        setOrient(Models.UP);
        if (getType() == Models.PLAYER_11 || getType() == Models.PLAYER_12) {
            setX(Models.START_PLAYER_ONE);
        } else {
            setX(Models.START_PLAYER_TWO);
        }
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public void removeLive() {
        if (numberLive <= 0) {
            isLive = false;
            return;
        }
        numberLive--;
    }

    public void upLive() {
        numberLive++;
    }

    public void changeImageBomb() {
        setImage(new ImageIcons(Models.BOMB_BIRD).getImage());
    }

}
