package com.nhahv.tank90.object;

import com.nhahv.tank90.images.ImageIcons;
import com.nhahv.tank90.images.ImagesManager;
import com.nhahv.tank90.maps.ItemsMaps;
import com.nhahv.tank90.maps.MapsManagers;
import com.nhahv.tank90.models.Models;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Nhahv on 3/30/2016.
 */
public class Bullet extends CommonSize {

    private ArrayList<Image> mListNormal;
    private ArrayList<Image> mListBig;
    private int speedBullet;
    private int orient;
    private int type;

    public Bullet(int x, int y, int width, int orient, int type) {
        super(x, y, width);
        this.speedBullet = Models.SPEED_BULLET_NORMAL;
        this.orient = orient;
        this.type = type;
        setImage();
        mListBig = ImagesManager.getListBulletBig();
    }

    private void setImage() {
        mListNormal = new ArrayList<>();
        Image image = new ImageIcons(Models.BULLET_NORMAL_UP).getImage();
        mListNormal.add(image);
        image = new ImageIcons(Models.BULLET_NORMAL_DOWN).getImage();
        mListNormal.add(image);

        image = new ImageIcons(Models.BULLET_NORMAL_LEFT).getImage();
        mListNormal.add(image);

        image = new ImageIcons(Models.BULLET_NORMAL_RIGHT).getImage();
        mListNormal.add(image);
    }

    public void draw(Graphics2D graphics2D) {

        Image image = mListNormal.get(Models.UP);
        if (type == Models.TYPE_BULLET_NORMAL) {
            switch (orient) {
                case Models.UP:
                    image = mListNormal.get(Models.UP);
                    break;
                case Models.DOWN:
                    image = mListNormal.get(Models.DOWN);
                    break;
                case Models.LEFT:
                    image = mListNormal.get(Models.LEFT);
                    break;
                case Models.RIGHT:
                    image = mListNormal.get(Models.RIGHT);
                    break;
            }
        } else if (type == Models.TYPE_BULLET_BIG) {
            switch (orient) {
                case Models.UP:
                    image = mListBig.get(Models.UP);
                    break;
                case Models.DOWN:
                    image = mListBig.get(Models.DOWN);
                    break;
                case Models.LEFT:
                    image = mListBig.get(Models.LEFT);
                    break;
                case Models.RIGHT:
                    image = mListBig.get(Models.RIGHT);
                    break;
            }
        }
        graphics2D.drawImage(image, getX(), getY(), getSize(), getSize(), null);
    }

    public void setSpeedBullet(int x) {
        this.speedBullet = x;
    }

    public void move(MapsManagers mapsManagers) {
        switch (orient) {
            case Models.UP:
                if (getY() > 0) {
                    setY(getY() - speedBullet);
                    isRemoveBullet(mapsManagers);

                    if (isIntersect(mapsManagers)) {
                        setY(getY() + speedBullet);
                    }

                }
                break;
            case Models.DOWN:
                if (getY() < Models.HEIGHT) {
                    setY(getY() + speedBullet);
                    isRemoveBullet(mapsManagers);
                    if (isIntersect(mapsManagers)) {
                        setY(getY() - speedBullet);
                    }

                }
                break;
            case Models.LEFT:
                if (getX() > 0) {
                    setX(getX() - speedBullet);
                    isRemoveBullet(mapsManagers);
                    if (isIntersect(mapsManagers)) {
                        setX(getX() + speedBullet);
                    }
                }
                break;
            case Models.RIGHT:
                if (getX() < Models.WIDTH) {
                    setX(getX() + speedBullet);
                    isRemoveBullet(mapsManagers);
                    if (isIntersect(mapsManagers)) {
                        setX(getX() - speedBullet);
                    }
                }
                break;
        }
    }

    private void isRemoveBullet(MapsManagers mapsManagers) {
        if (isKillWall(mapsManagers)) {
            setX(0);
            setY(0);
        }
    }

    public boolean isIntersect(MapsManagers mapsManagers) {

        for (ItemsMaps itemsMaps : mapsManagers.getListMaps()) {
            if (isIntersectItemMaps(itemsMaps)
                    && !itemsMaps.isBulletCross()) {
                return true;
            }
        }
        return false;
    }

    // check bullet have cross wall
    public boolean isKillWall(MapsManagers mapsManagers) {

//        int size = mapsManagers.getListMaps().size();
//        for (int i = size - 1; i >= 0; i--) {
//            ItemsMaps itemsMaps = mapsManagers.getListMaps().get(i);
//            if (isIntersectItemMaps(itemsMaps) && itemsMaps.isBulletCross()) {
//                itemsMaps.setType(Models.TYPE_ITEMS_1);
//                mapsManagers.getListMaps().remove(i);
//                return true;
//            }
//        }
        for (ItemsMaps itemsMaps : mapsManagers.getListMaps()) {
            if (isIntersectItemMaps(itemsMaps) && itemsMaps.isBreadWall()) {
                itemsMaps.setType(Models.TYPE_ITEMS_1);
//                mapsManagers.getListMaps().remove(itemsMaps);
                return true;
            }
        }
        return false;
    }

    private boolean isIntersectItemMaps(ItemsMaps itemsMaps) {
        return itemsMaps.getRectangle().intersects(getRectangle());
    }

    public Rectangle getRectangle() {
        return new Rectangle(getX(), getY(), getSize(), getSize());
    }
}
