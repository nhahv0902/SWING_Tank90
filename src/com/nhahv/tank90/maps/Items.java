package com.nhahv.tank90.maps;

import com.nhahv.tank90.object.CommonSize;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Nhahv on 3/30/2016.
 */
public abstract class Items extends CommonSize {

    private int type;
    private ArrayList<Image> mListImages;

    public Items(int x, int y, int width, int height, int type) {
        super(x, y, width, height);
        this.type = type;
    }

    public abstract void draw(Graphics2D graphics2D, int width);


    protected abstract Image getImages();

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ArrayList<Image> getmListImages() {
        return mListImages;
    }

    public void setListImages(ArrayList<Image> mListImages) {
        this.mListImages = mListImages;
    }
}
