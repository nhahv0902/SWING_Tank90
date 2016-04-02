package com.nhahv.tank90.maps;

import com.nhahv.tank90.images.ImagesManager;
import com.nhahv.tank90.models.Models;

import java.awt.*;

/**
 * Created by Nhahv on 3/30/2016.
 */
public class ItemsMaps extends Items {

    private int propertyTankCross; // tank can cross
    private int propertyBulletCross; // bullet can cross

    public ItemsMaps(int x, int y, int width, int height, int type) {
        super(x, y, width, height, type);
        setListImages(ImagesManager.getListMaps());

        if (type == Models.TYPE_ITEMS_1 || type == Models.TYPE_ITEMS_4
                || type == Models.TYPE_ITEMS_6) {
            propertyTankCross = Models.MAPS_CROSS;
        } else {
            propertyTankCross = Models.MAPS_NO_CROSS;
        }

        if (type == Models.TYPE_ITEMS_1 || type == Models.TYPE_ITEMS_4
                || type == Models.TYPE_ITEMS_5 || type == Models.TYPE_ITEMS_6) {
            propertyBulletCross = Models.MAPS_CROSS;
        } else if (type == Models.TYPE_ITEMS_3) {
            propertyBulletCross = Models.MAPS_NO_CROSS;
        } else if (type == Models.TYPE_ITEMS_2) {
            propertyBulletCross = Models.MAPS_BREAK;
        }
    }

    @Override
    public void draw(Graphics2D graphics2D) {

        Image image = getImages();
//        graphics2D.drawImage(image, Models.START_MAPS + getX() * Models.SIZE_ITEMS_MAPS, getY() * Models.SIZE_ITEMS_MAPS, getWidth(), getHeight(), null);
        graphics2D.drawImage(image, getX() * Models.SIZE_ITEMS_MAPS, getY() * Models.SIZE_ITEMS_MAPS, getWidth(), getHeight(), null);
    }

    @Override
    public Image getImages() {

        Image image = getListImages().get(Models.TYPE_ITEMS_1);
        switch (getType()) {
            case Models.TYPE_ITEMS_1:
                image = getListImages().get(Models.TYPE_ITEMS_1);
                break;
            case Models.TYPE_ITEMS_2:
                image = getListImages().get(Models.TYPE_ITEMS_2);
                break;
            case Models.TYPE_ITEMS_3:
                image = getListImages().get(Models.TYPE_ITEMS_3);
                break;
            case Models.TYPE_ITEMS_4:
                image = getListImages().get(Models.TYPE_ITEMS_4);
                break;
            case Models.TYPE_ITEMS_5:
                image = getListImages().get(Models.TYPE_ITEMS_5);
                break;
            case Models.TYPE_ITEMS_6:
                image = getListImages().get(Models.TYPE_ITEMS_6);
                break;
        }
        return image;
    }

    public Rectangle getRectangle() {
//        return new Rectangle(Models.START_MAPS + getX() * Models.SIZE_ITEMS_MAPS,
//                getY() * Models.SIZE_ITEMS_MAPS, getWidth(), getHeight());
        return new Rectangle(getX() * Models.SIZE_ITEMS_MAPS,
                getY() * Models.SIZE_ITEMS_MAPS, getWidth(), getHeight());
    }

    public int getPropertyBulletCross() {
        return propertyBulletCross;
    }

    public int getPropertyTankCross() {
        return propertyTankCross;
    }
}
