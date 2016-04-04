package com.nhahv.tank90.object;

import com.nhahv.tank90.maps.MapsManagers;
import com.nhahv.tank90.models.Models;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Nhahv on 3/30/2016.
 */
public class Tank extends CommonSize {

    private int type;
    private int orient;
    private int speedMode;
    private ArrayList<Bullet> mListBullets;
    private int timeFire;

    public Tank(int x, int y, int size, int type, int orient) {
        super(x, y, size);

        setSize(Models.SIZE_BOOS);
        this.speedMode = Models.SPEED_DEFAULT;
        this.type = type;
        this.orient = orient;
        this.timeFire = 0;
        this.mListBullets = new ArrayList<>();
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    public int getOrient() {
        return orient;
    }

    public void setOrient(int orient) {
        this.orient = orient;
    }

    public int getSpeedMode() {
        return speedMode;
    }

    public void setSpeedMode(int speedMode) {
        this.speedMode = speedMode;
    }

    public boolean isFire() {
        return timeFire <= 0;
    }

    public void setTimeFire() {
        this.timeFire = Models.TIME_OUT;
    }

    public void moveTimeFire() {
        if (timeFire > 0) {
            timeFire -= Models.TIME_SLEEP;
        }
    }

    public void tankFire() {

        if (isFire()) {
            int x = getX(), y = getY();
            if (getOrient() == Models.UP || getOrient() == Models.DOWN) {
                x = getX() + getSize() / 2 - Models.SIZE_BULLET / 2;
            } else if (getOrient() == Models.LEFT || getOrient() == Models.RIGHT) {
                y = getY() + getSize() / 2 - Models.SIZE_BULLET / 2;
            }

            if (getOrient() == Models.RIGHT) {
                x += getSize();
            }
            if (getOrient() == Models.DOWN) {
                y += getSize();
            }
            Bullet bullet = new Bullet(x, y, Models.SIZE_BULLET, getOrient(), Models.TYPE_BULLET_NORMAL);
            mListBullets.add(bullet);
            setTimeFire();
        }
    }

    public void moveBullet(MapsManagers mapsManagers) {
        for (int i = mListBullets.size() - 1; i >= 0; i--) {

            mListBullets.get(i).move(mapsManagers);
            if (mListBullets.get(i).getX() >= Models.WIDTH
                    || mListBullets.get(i).getX() <= 0
                    || mListBullets.get(i).getY() <= 0
                    || mListBullets.get(i).getY() >= Models.HEIGHT) {
                mListBullets.remove(i);
            }
        }
    }

    public ArrayList<Bullet> getListBullets() {
        return mListBullets;
    }

    public Rectangle getRectangle() {
        return new Rectangle(getX(), getY(), getSize(), getSize());
    }


}
