package com.nhahv.tank90.maps;

import com.nhahv.tank90.images.ImagesManager;
import com.nhahv.tank90.models.Models;

import java.awt.*;

/**
 * Created by Nhahv on 3/30/2016.
 */
public class ItemsMaps extends Items {

    public ItemsMaps(int x, int y, int width, int height, int type) {
        super(x, y, width, height, type);
        setListImages(ImagesManager.getListMaps());
    }

    @Override
    public void draw(Graphics2D graphics2D, int width) {

        Image image = getImages();
        graphics2D.drawImage(image, width + getX() * Models.SIZE_ITEMS_MAPS, getY() * Models.SIZE_ITEMS_MAPS, getWidth(), getHeight(), null);
    }

    @Override
    public Image getImages() {

        Image image = getmListImages().get(Models.TYPE_ITEMS_1);
        switch (getType()) {
            case Models.TYPE_ITEMS_1:
                image = getmListImages().get(Models.TYPE_ITEMS_1);
                break;
            case Models.TYPE_ITEMS_2:
                image = getmListImages().get(Models.TYPE_ITEMS_2);
                break;
            case Models.TYPE_ITEMS_3:
                image = getmListImages().get(Models.TYPE_ITEMS_3);
                break;
            case Models.TYPE_ITEMS_4:
                image = getmListImages().get(Models.TYPE_ITEMS_4);
                break;
            case Models.TYPE_ITEMS_5:
                image = getmListImages().get(Models.TYPE_ITEMS_5);
                break;
            case Models.TYPE_ITEMS_6:
                image = getmListImages().get(Models.TYPE_ITEMS_6);
                break;
        }
        return image;
    }
}
