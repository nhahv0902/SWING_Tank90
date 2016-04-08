package com.nhahv.tank90.object;

import com.nhahv.tank90.maps.Bird;
import com.nhahv.tank90.maps.MapsManagers;
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

    public TankBoss(int x, int y, int size, int type, int orient) {
        super(x, y, size, type, orient);

        setTankPlay(false);
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

    public void draw(Graphics2D graphics2D) {
        getImages();
        graphics2D.drawImage(getImage(), getX(), getY(), getSize(), getSize(), null);
        for (Bullet bullet : getListBullets()) {
            bullet.draw(graphics2D);
        }
    }

    private void getImages() {

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

    private void setListImageShow() {
        switch (getType()) {
            case Models.TYPE_BOSS_1:
                setListTank(mListImageType1);
                break;
            case Models.TYPE_BOSS_2:
                setListTank(mListImageType2);
                break;
            case Models.TYPE_BOSS_3:
                setListTank(mListImageType3);
                break;
            case Models.TYPE_BOSS_4:
                setListTank(mListImageType4);
                break;
            case Models.TYPE_BOSS_5:
                setListTank(mListImageType5);
                break;
            case Models.TYPE_BOSS_6:
                setListTank(mListImageType6);
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
                        setOrientTankBoss();
                    }
                } else if (getY() <= 0) {
                    this.setOrient(Models.DOWN);
                    setImage(getListTank().get(Models.DOWN));
                }
                break;
            case Models.DOWN:
                if (getY() < Models.SIZE_MAPS - getSize()) {
                    setY(getY() + getSpeedMode());
                    if (isIntersect(mapsManagers, bird, managerTankBoss)) {
                        setY(getY() - getSpeedMode());
                        setOrientTankBoss();

                    }
                } else if (getY() >= Models.SIZE_MAPS - getSize()) {
                    this.setOrient(Models.UP);
                    setImage(getListTank().get(Models.UP));
                }
                break;
            case Models.LEFT:
                if (getX() > 0) {
                    setX(getX() - getSpeedMode());
                    if (isIntersect(mapsManagers, bird, managerTankBoss)) {
                        setX(getX() + getSpeedMode());
                        setOrientTankBoss();
                    }
                } else if (getX() <= 0) {
                    this.setOrient(Models.RIGHT);
                    setImage(getListTank().get(Models.RIGHT));
                }

                break;
            case Models.RIGHT:
                if (getX() < Models.SIZE_MAPS - getSize()) {
                    setX(getX() + getSpeedMode());
                    if (isIntersect(mapsManagers, bird, managerTankBoss)) {
                        setX(getX() - getSpeedMode());
                        setOrientTankBoss();
                    }
                } else if (getX() >= Models.SIZE_MAPS - getSize()) {
                    this.setOrient(Models.LEFT);
                    setImage(getListTank().get(Models.LEFT));
                }
                break;
        }
    }

    private void setListImages() {
        mListImageType1 = setListImages(Models.BOSS_1);
        mListImageType2 = setListImages(Models.BOSS_2);
        mListImageType3 = setListImages(Models.BOSS_3);
        mListImageType4 = setListImages(Models.BOSS_4);
        mListImageType5 = setListImages(Models.BOSS_5);
        mListImageType6 = setListImages(Models.BOSS_6);
    }

    private void setOrientTankBoss() {
        int random = new Random().nextInt(4);
        if (random == getOrient()) {
            if (getOrient() > 0) {
                setOrient(random--);
            } else {
                setOrient(random++);
            }
        } else {
            setOrient(random);
        }
        setImage(getListTank().get(random));
    }
}
