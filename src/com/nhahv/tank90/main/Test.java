package com.nhahv.tank90.main;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by Nhahv on 4/7/2016.
 */
public class Test {
    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle(0,0,100,100);
        Rectangle rectangle1 = new Rectangle(90,0,20,20);
        Rectangle rectangle2 = new Rectangle();
        Rectangle2D.intersect(rectangle1,rectangle,rectangle2);
        System.out.println(rectangle2.getHeight() + " " + rectangle2.getWidth());
    }
}
