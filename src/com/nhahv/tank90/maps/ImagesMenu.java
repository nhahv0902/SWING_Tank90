package com.nhahv.tank90.maps;

import com.nhahv.tank90.images.ImageIcons;
import com.nhahv.tank90.models.Models;

import java.awt.*;

/**
 * Created by Nhahv on 3/31/2016.
 */
public class ImagesMenu {

    private Image mImage;
    private int x, y, width, height;

    public ImagesMenu(int x, int y, String path) {
        this.x = x;
        this.y = y;
        setImage(path);
    }

    public void setPaddingX(int x) {
        setX(x);
    }

    private void setImage(String path) {
        ImageIcons imageIcons = new ImageIcons(path);
        mImage = imageIcons.getImage();
        setWidth(imageIcons.getWidth());
        setHeight(imageIcons.getHeight());
        setX((Models.WIDTH - getWidth()) / 2);
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(this.mImage, getX(), getY(), getWidth(), getHeight(), null);
    }

    public void move() {
        if (getY() < Models.HEIGHT - Models.SIZE_TANK_RUN && getX() == 0) {
            moveDown();
        }
        if ((getY() >= Models.HEIGHT - Models.SIZE_TANK_RUN)
                && (getX() < Models.WIDTH - Models.SIZE_TANK_RUN)) {
            moveRight();
        }
        if (getX() >= Models.WIDTH - Models.SIZE_TANK_RUN) {
            moveUp();
        }
        if (getY() <= 0 && getX() > 0) {
            moveLeft();
        }
    }

    private void moveDown() {
        mImage = new ImageIcons(Models.ICON_RUN_DOWN).getImage();
        setY(getY() + 1);
    }

    private void moveUp() {
        mImage = new ImageIcons(Models.ICON_RUN_UP).getImage();
        setY(getY() - 1);
    }

    private void moveLeft() {
        mImage = new ImageIcons(Models.ICON_RUN_LEFT).getImage();
        setX(getX() - 1);
    }

    private void moveRight() {
        mImage = new ImageIcons(Models.ICON_RUN_RIGHT).getImage();
        setX(getX() + 1);
    }

    public void changeImage(Image image) {
        this.mImage = image;
    }

    public void moveOneTwo(boolean isOne) {
        if (isOne) {
            setY(getY() + 40);
        } else {
            setY(getY() - 40);
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
