package com.nhahv.tank90.maps;

import com.nhahv.tank90.images.ImagesManager;
import com.nhahv.tank90.models.Models;

import java.awt.*;

/**
 * Created by Nhahv on 3/30/2016.
 */
public class ItemsHelp extends Items {


    public ItemsHelp(int x, int y, int width, int height, int type) {
        super(x, y, width, height, type);
        setListImages(ImagesManager.getListItemsHelp());
    }

    @Override
    public void draw(Graphics2D graphics2D, int width) {
        Image image = getImages();
        graphics2D.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);
    }


    @Override
    protected Image getImages() {
        Image image = getmListImages().get(Models.TYPE_HELP_1);
        switch (getType()) {
            case Models.TYPE_HELP_1:
                image = getmListImages().get(Models.TYPE_HELP_1);
                break;
            case Models.TYPE_HELP_2:
                image = getmListImages().get(Models.TYPE_HELP_2);
                break;
            case Models.TYPE_HELP_3:
                image = getmListImages().get(Models.TYPE_HELP_3);
                break;
            case Models.TYPE_HELP_4:
                image = getmListImages().get(Models.TYPE_HELP_4);
                break;
            case Models.TYPE_HELP_5:
                image = getmListImages().get(Models.TYPE_HELP_5);
                break;
            case Models.TYPE_HELP_6:
                image = getmListImages().get(Models.TYPE_HELP_6);
                break;
            case Models.TYPE_HELP_7:
                image = getmListImages().get(Models.TYPE_HELP_7);
                break;
        }
        return image;
    }
}
