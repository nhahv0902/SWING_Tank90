package com.nhahv.tank90.object;

/**
 * Created by Nhahv on 3/30/2016.
 */
public class Tank extends CommonSize {

    private int type;
    private int orient;
    private int timeSpeed;

    public Tank(int x, int y, int width, int height, int type, int orient, int timeSpeed) {
        super(x, y, width, height);
        this.timeSpeed = timeSpeed;
        this.type = type;
        this.orient = orient;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


    public int getOrient() {
        return orient;
    }

    public void setOrient(int orient) {
        this.orient = orient;
    }
}
