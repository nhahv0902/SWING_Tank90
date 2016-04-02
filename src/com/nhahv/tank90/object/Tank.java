package com.nhahv.tank90.object;

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


    public Tank(int x, int y, int width, int height, int type, int orient, int speedMode) {
        super(x, y, width, height);
        this.speedMode = speedMode;
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

//    public void move() {
//        switch (getOrient()) {
//            case Models.UP:
//                setY(getY() - getSpeedMode());
//                break;
//            case Models.DOWN:
//                setY(getY() + getSpeedMode());
//                break;
//            case Models.LEFT:
//                setX(getX() - getSpeedMode());
//                break;
//            case Models.RIGHT:
//                setX(getX() + getSpeedMode());
//                break;
//        }
//    }

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
            System.out.println("fire");
            int x = getX(), y = getY();
            if (getOrient() == Models.UP || getOrient() == Models.DOWN) {
                x = getX() + Models.SIZE_BULLET + 3;
            } else if (getOrient() == Models.LEFT || getOrient() == Models.RIGHT) {
                y = getY() + Models.SIZE_BULLET + 3;
            }

            if (getOrient() == Models.RIGHT) {
                x += Models.SIZE_BOOS;
            }
            if (getOrient() == Models.DOWN) {
                y += Models.SIZE_BOOS;
            }

            Bullet bullet = new Bullet(x, y, Models.SIZE_BULLET, Models.SIZE_BULLET, getOrient(), Models.TYPE_BULLET_NORMAL);
            mListBullets.add(bullet);
            setTimeFire();
        }
    }

    public void moveBullet() {
        for (int i = mListBullets.size() - 1; i >= 0; i--) {

            mListBullets.get(i).move();
            if (mListBullets.get(i).getX() >= Models.WIDTH
                    || mListBullets.get(i).getX() <= 0
                    || mListBullets.get(i).getY() <= 0
                    || mListBullets.get(i).getY() >= Models.HEIGHT) {
                mListBullets.remove(mListBullets.get(i));
            }
        }
    }

    public ArrayList<Bullet> getListBullets() {
        return mListBullets;
    }

    public Rectangle getRectangle() {
        Rectangle rectangle = null;
        if (orient == Models.UP || orient == Models.DOWN) {
            rectangle = new Rectangle(getX(), getY(), Models.SIZE_BOOS, Models.SIZE_BOOS);

        } else if (orient == Models.LEFT || orient == Models.RIGHT) {
            rectangle = new Rectangle(getX(), getY(), Models.SIZE_BOOS, Models.SIZE_BOOS);
        }

        return rectangle;
    }
}
