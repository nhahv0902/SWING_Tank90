package com.nhahv.tank90.images;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nhahv on 3/30/2016.
 */
public class ImageIcons {

    private int width; // width of images
    private int height; // height of images
    private Image image;
    private ImageIcon imageIcon;

    public ImageIcons(String path) {

        imageIcon = new ImageIcon(getClass().getResource(path));
        image = imageIcon.getImage();
        width = imageIcon.getIconWidth();
        height = imageIcon.getIconHeight();
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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }
}
