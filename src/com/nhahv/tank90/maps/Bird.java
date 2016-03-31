package com.nhahv.tank90.maps;


import com.nhahv.tank90.models.Models;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Nhahv on 3/31/2016.
 */
public class Bird {

    private int x, y;
    private int size;
    private Image image;

    public Bird() {

        setImages();
        x = (Models.WIDTH - Models.SIZE_BOOS) / 2;
        y = Models.HEIGHT - Models.SIZE_BOOS * 2 + Models.SIZE_ITEMS_MAPS;
        size = Models.SIZE_BOOS;
    }

    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(image, x, y, size, size, null);
    }

    private void setImages() {
        try {
            BufferedImage buff = ImageIO.read(getClass().getResourceAsStream(Models.ITEMS_BIRD));
            this.image = buff.getSubimage(0, 0, Models.SIZE_BOOS, Models.SIZE_BOOS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
