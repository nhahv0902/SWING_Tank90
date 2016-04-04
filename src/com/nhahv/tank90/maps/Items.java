package com.nhahv.tank90.maps;

import com.nhahv.tank90.models.Models;
import com.nhahv.tank90.object.CommonSize;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Nhahv on 3/30/2016.
 */
public abstract class Items extends CommonSize {

    private int type;
    private ArrayList<Image> mListImages;

    public Items(int x, int y, int size, int type) {
        super(x, y, size);
        this.type = type;
    }

    public abstract void draw(Graphics2D graphics2D);

    public abstract Image getImages();

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ArrayList<Image> getListImages() {
        return mListImages;
    }

    public void setListImages(ArrayList<Image> mListImages) {
        this.mListImages = mListImages;
    }

    public Rectangle getRectangle() {
        return new Rectangle(getX() * Models.SIZE_ITEMS_MAPS,
                getY() * Models.SIZE_ITEMS_MAPS, getSize(), getSize());
    }
}
