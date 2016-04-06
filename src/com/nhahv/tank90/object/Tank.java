package com.nhahv.tank90.object;

import com.nhahv.tank90.maps.Bird;
import com.nhahv.tank90.maps.ItemsMaps;
import com.nhahv.tank90.maps.MapsManagers;
import com.nhahv.tank90.models.Models;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Nhahv on 3/30/2016.
 */
public abstract class Tank extends CommonSize {

    private int type;
    private int orient;
    private int speedMode;
    private ArrayList<Bullet> mListBullets;
    private int timeFire;
    private Image image;
    private boolean isTankPlay;

    public Tank(int x, int y, int size, int type, int orient) {
        super(x, y, size);

        setSize(Models.SIZE_BOOS);
        this.speedMode = Models.SPEED_DEFAULT;
        this.type = type;
        this.orient = orient;
        this.timeFire = 0;
        this.mListBullets = new ArrayList<>();
        this.isTankPlay = false;

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
            bullet.setTankPlay(isTankPlay());
            mListBullets.add(bullet);
            setTimeFire();
        }
    }

    public void moveBullet(MapsManagers mapsManagers, Bird bird, TankPlayer tankPlayer, ManagerTankBoss managerTankBoss) {
        for (int i = mListBullets.size() - 1; i >= 0; i--) {

            mListBullets.get(i).move(mapsManagers, bird, tankPlayer, managerTankBoss);
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

    protected boolean isIntersect(MapsManagers mapsManagers, Bird bird) {

        for (ItemsMaps itemsMaps : mapsManagers.getListMaps()) {
//            Rectangle rectangle = new Rectangle();
//            Rectangle2D.intersect(itemsMaps.getRectangle(), getRectangle(), rectangle);
            Rectangle rectangle = new Rectangle(getX() + 3, getY() + 3, getSize() - 8, getSize() - 8);
            if (itemsMaps.getRectangle().intersects(rectangle)
                    && !itemsMaps.isTankCross()) {
                return true;
            }
//            if (rectangle.getHeight() > 10 && rectangle.getWidth() >= 10)
//                System.out.println(rectangle.getWidth() + " " + rectangle.getHeight() + "");
//            if (rectangle.getWidth() >= 20 || rectangle.getHeight() >= 20
//                    && !itemsMaps.isTankCross()) {
//                return true;
//            }
        }
        if (bird.getRectangle().intersects(this.getRectangle())) {
            return true;
        }
        return false;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public boolean isTankPlay() {
        return isTankPlay;
    }

    public void setTankPlay(boolean tankPlay) {
        isTankPlay = tankPlay;
    }


    public abstract void remove();
}
