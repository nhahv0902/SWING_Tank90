package com.nhahv.tank90.object;

import com.nhahv.tank90.images.ImageIcons;
import com.nhahv.tank90.maps.Bird;
import com.nhahv.tank90.maps.ItemsMaps;
import com.nhahv.tank90.maps.MapsManagers;
import com.nhahv.tank90.models.Models;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Nhahv on 3/30/2016.
 */
public class Bullet extends CommonSize {

    private int speedBullet;
    private int orient;
    private int type;
    private Image imageBullet;
    private ArrayList<Image> mListBullet;
    private boolean isTankPlay;

    public Bullet(int x, int y, int width, int orient, int type) {
        super(x, y, width);

        this.speedBullet = Models.SPEED_BULLET_NORMAL;
        this.orient = orient;
        this.type = Models.TYPE_BULLET_NORMAL;
        isTankPlay = false;
        mListBullet = setListImages(Models.BULLET_BIG);
    }

    public void draw(Graphics2D graphics2D) {

        switch (orient) {
            case Models.UP:
                imageBullet = mListBullet.get(Models.UP);
                break;
            case Models.DOWN:
                imageBullet = mListBullet.get(Models.DOWN);
                break;
            case Models.LEFT:
                imageBullet = mListBullet.get(Models.LEFT);
                break;
            case Models.RIGHT:
                imageBullet = mListBullet.get(Models.RIGHT);
                break;
        }

        graphics2D.drawImage(imageBullet, getX(), getY(), getSize(), getSize(), null);
    }


    public void move(MapsManagers mapsManagers, Bird bird, TankPlayer tankPlayer, ManagerTankBoss managerTankBoss) {

        if (bird.getLive()) {
            switch (orient) {
                case Models.UP:
                    if (getY() > 0) {
                        setY(getY() - speedBullet);
                        removeBullets(mapsManagers);
                        if (isIntersect(mapsManagers)) {
                            setY(getY() + speedBullet);
                        }
                    }
                    break;
                case Models.DOWN:
                    if (getY() < Models.HEIGHT) {
                        setY(getY() + speedBullet);
                        removeBullets(mapsManagers);
                        if (isIntersect(mapsManagers)) {
                            setY(getY() - speedBullet);
                        }
                    }
                    break;
                case Models.LEFT:
                    if (getX() > 0) {
                        setX(getX() - speedBullet);
                        removeBullets(mapsManagers);
                        if (isIntersect(mapsManagers)) {
                            setX(getX() + speedBullet);
                        }
                    }
                    break;
                case Models.RIGHT:
                    if (getX() < Models.WIDTH) {
                        setX(getX() + speedBullet);
                        removeBullets(mapsManagers);
                        if (isIntersect(mapsManagers)) {
                            setX(getX() - speedBullet);
                        }
                    }
                    break;
            }
            isKillBird(bird);
            isKillBullet(managerTankBoss, tankPlayer);
            isKillTank(tankPlayer, managerTankBoss);
        }
    }

    private void removeBullets(MapsManagers mapsManagers) {
        if (isKillWall(mapsManagers)) {
            removeBullet();
        }
    }

    private void removeBullet() {
        setX(0);
        setY(0);
    }

    public boolean isIntersect(MapsManagers mapsManagers) {

        for (ItemsMaps itemsMaps : mapsManagers.getListMaps()) {
            if (isIntersectItemMaps(itemsMaps)
                    && !itemsMaps.isBulletCross()) {
                removeBullet();
                return true;
            }
        }
        return false;
    }

    // check bullet have cross wall
    public boolean isKillWall(MapsManagers mapsManagers) {

        int size = mapsManagers.size();
        for (int i = size - 1; i >= 0; i--) {

            if (isIntersectItemMaps(mapsManagers.getItems(i))
                    && mapsManagers.getItems(i).isBreadWall()) {
                mapsManagers.getItems(i).setType(Models.TYPE_ITEMS_1);
                if (i > 26 && (orient == Models.LEFT || orient == Models.RIGHT)) {
                    mapsManagers.getItems(i - 26).setType(Models.TYPE_ITEMS_1);
                } else if (i > 1 && (orient == Models.UP || orient == Models.DOWN)) {
                    mapsManagers.getItems(i - 1).setType(Models.TYPE_ITEMS_1);
                }
                return true;
            }
        }
        return false;
    }

    public boolean isKillBird(Bird bird) {
        if (getRectangle().intersects(bird.getRectangle())) {
            bird.setLive(false);
            setY(0);
            setX(0);
            return true;
        }
        return false;
    }

    // check bullet have destructively
    public boolean isKillBullet(ManagerTankBoss managerTankBoss, TankPlayer tankPlayer) {
        if (isTankPlay) {
            // if is bullet tank play  then check with bullet tank boss
            for (TankBoss tankBoss : managerTankBoss.getListBoss()) {
                for (Bullet bullet : tankBoss.getListBullets()) {
                    if (getRectangle().intersects(bullet.getRectangle())) {
                        bullet.removeBullet();
                        removeBullet();
                        return true;
                    }
                }
            }
        } else {
            for (Bullet bullet : tankPlayer.getListBullets()) {
                if (bullet.getRectangle().intersects(getRectangle())) {
                    bullet.removeBullet();
                    removeBullet();
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isKillTank(TankPlayer tankPlayer, ManagerTankBoss managerTankBoss) {

        if (!isTankPlay) {
            if (tankPlayer.getRectangle().intersects(getRectangle())) {
                tankPlayer.removeLive();
                if (tankPlayer.isLive())
                    tankPlayer.remove();
                removeBullet();
                return true;
            }
        } else if (isTankPlay) {
            int size = managerTankBoss.getListBoss().size();
            for (int i = size - 1; i >= 0; i--) {
                TankBoss tankBoss = managerTankBoss.getListBoss().get(i);
                if (tankBoss.getRectangle().intersects(getRectangle())) {
                    managerTankBoss.getListBoss().remove(i);
                    managerTankBoss.moveNumberBulletCurrent();
                    removeBullet();
                    return true;
                }
            }
        }
        return true;
    }

    private boolean isIntersectItemMaps(ItemsMaps itemsMaps) {
        return itemsMaps.getRectangle().intersects(getRectangle());
    }

    public void setImageBullet() {
        imageBullet = new ImageIcons(Models.BOMB).getImage();
    }

    public boolean isTankPlay() {
        return isTankPlay;
    }

    public void setTankPlay(boolean tankPlay) {
        isTankPlay = tankPlay;
    }

    public Rectangle getRectangle() {
        return new Rectangle(getX(), getY(), getSize(), getSize());
    }
}
