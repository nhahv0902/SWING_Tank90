package com.nhahv.tank90.object;

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
public class CommonSize {

    private int x, y, size;

    public CommonSize(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
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

    public int getSize() {
        return size;
    }

    public void setSize(int width) {
        this.size = width;
    }

    protected ArrayList<Image> setListImages(String name) {
        ArrayList<Image> listImages = new ArrayList<>();
        try {
            BufferedImage buffReadImage = ImageIO.read(new File("src" + name));
            BufferedImage buffCutImage;
            for (int i = 0; i < Models.NUMBER_BOOS; i++) {
                buffCutImage = buffReadImage.getSubimage(0, i * size, size, size);
                listImages.add(buffCutImage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listImages;
    }
}
