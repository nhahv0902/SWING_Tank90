package com.nhahv.tank90.object;

import com.nhahv.tank90.images.ImageIcons;
import com.nhahv.tank90.maps.Bird;
import com.nhahv.tank90.maps.ItemsMaps;
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
public class Bullet extends CommonSize {

    private ArrayList<Image> mListNormal;
    private ArrayList<Image> mListBig;
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
//        this.type = type;
        this.type = Models.TYPE_BULLET_NORMAL;
        isTankPlay = false;
        setImageNormal();
        setListImageBig(Models.BULLET_BIG);
        setImagesBulletShow();
    }

    private void setImagesBulletShow() {
        if (type == Models.TYPE_BULLET_BIG) {
            mListBullet = mListNormal;
        } else {
            mListBullet = mListBig;
        }
    }

    private void setImageNormal() {
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

    private void setListImageBig(String imgName) {

        mListBig = new ArrayList<>();
        try {
            BufferedImage buffReadImage = ImageIO.read(new File("src" + imgName));
            BufferedImage buffCutImage;
            for (int i = 0; i < Models.NUMBER_BOOS; i++) {
                buffCutImage = buffReadImage.getSubimage(0, i * getSize(), getSize(), getSize());
                mListBig.add(buffCutImage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D graphics2D) {

        setImagesBulletShow();

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

    public void setSpeedBullet(int x) {
        this.speedBullet = x;
    }

    // init images bullet big

    public void move(MapsManagers mapsManagers, Bird bird, TankPlayer tankPlayer, ManagerTankBoss managerTankBoss) {

        if (bird.getLive()) {
            switch (orient) {
                case Models.UP:
                    if (getY() > 0) {
                        setY(getY() - speedBullet);
                        isKillTank(tankPlayer, managerTankBoss);
                        removeBullets(mapsManagers);
                        if (isIntersect(mapsManagers)) {
                            setY(getY() + speedBullet);
                        }
                    }
                    break;
                case Models.DOWN:
                    if (getY() < Models.HEIGHT) {
                        isKillTank(tankPlayer, managerTankBoss);
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
                        isKillTank(tankPlayer, managerTankBoss);
                        removeBullets(mapsManagers);
                        if (isIntersect(mapsManagers)) {
                            setX(getX() + speedBullet);
                        }
                    }
                    break;
                case Models.RIGHT:
                    if (getX() < Models.WIDTH) {
                        setX(getX() + speedBullet);
                        isKillTank(tankPlayer, managerTankBoss);
                        removeBullets(mapsManagers);
                        if (isIntersect(mapsManagers)) {
                            setX(getX() - speedBullet);
                        }
                    }
                    break;
            }
            isKillBird(bird);
            System.out.println(bird.getLive() + "");
        }

    }

    private void removeBullets(MapsManagers mapsManagers) {
        if (isKillWall(mapsManagers)) {
            setX(0);
            setY(0);
        }
    }

    private void removeBullet() {
        setX(0);
        setY(0);
    }

    private void removeBullets() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    imageBullet = new ImageIcons("/IMAGES/bomb_wall.png").getImage();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setX(0);
                setY(0);
            }
        }.start();

    }

    public boolean isIntersect(MapsManagers mapsManagers) {

        for (ItemsMaps itemsMaps : mapsManagers.getListMaps()) {
            if (isIntersectItemMaps(itemsMaps)
                    && !itemsMaps.isBulletCross()) {
                removeBullets();
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

    public boolean isKillTank(TankPlayer tankPlayer, ManagerTankBoss managerTankBoss) {

        if (!isTankPlay) {
            // kiem tra tank play
            if (tankPlayer.getRectangle().intersects(getRectangle())) {
                tankPlayer.remove();
                removeBullet();
                System.out.println("" + isTankPlay);
            }
        } else if (isTankPlay) {
            // kiem tra manager boss
            int size = managerTankBoss.getmListBoss().size();
            for (int i = size - 1; i >= 0; i--) {
                TankBoss tankBoss = managerTankBoss.getmListBoss().get(i);
                if (tankBoss.getRectangle().intersects(getRectangle())) {
                    managerTankBoss.getmListBoss().remove(i);
                    removeBullet();
                    System.out.println("" + isTankPlay);
                }
            }
        }

        return true;
    }

    private boolean isIntersectItemMaps(ItemsMaps itemsMaps) {
        return itemsMaps.getRectangle().intersects(getRectangle());
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
