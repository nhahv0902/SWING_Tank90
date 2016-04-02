package com.nhahv.tank90.object;

import com.nhahv.tank90.images.ImageIcons;
import com.nhahv.tank90.images.ImagesManager;
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

    public Bullet(int x, int y, int width, int height, int orient, int type) {
        super(x, y, width, height);
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
        graphics2D.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);
    }

    public void setSpeedBullet(int x) {
        this.speedBullet = x;
    }

    public void move() {
        switch (orient) {
            case Models.UP:
                setY(getY() - speedBullet);
                break;
            case Models.DOWN:
                setY(getY() + speedBullet);
                break;
            case Models.LEFT:
                setX(getX() - speedBullet);
                break;
            case Models.RIGHT:
                setX(getX() + speedBullet);
                break;
        }
    }

}
