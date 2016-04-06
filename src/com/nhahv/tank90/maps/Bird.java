package com.nhahv.tank90.maps;


import com.nhahv.tank90.images.ImageIcons;
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
    private boolean isLive;

    public Bird() {

        setImages();
        x = (Models.SIZE_MAPS - Models.SIZE_BOOS) / 2;
        y = Models.SIZE_MAPS - Models.SIZE_BOOS;
        size = Models.SIZE_BOOS;
        isLive = true;
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

    public void setLive(boolean isLive) {
        this.isLive = isLive;
        if (!isLive) {
            image = new ImageIcons(Models.BOMB_BIRD).getImage();
        }
    }

    public boolean getLive() {
        return isLive;
    }

    public Rectangle getRectangle() {
        return new Rectangle(x, y, size, size);
    }
}
