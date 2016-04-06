package com.nhahv.tank90.object;

import com.nhahv.tank90.maps.Bird;
import com.nhahv.tank90.maps.MapsManagers;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Nhahv on 4/5/2016.
 */
public class ManagerTankBoss {

    private ArrayList<TankBoss> mListBoss;
    private int numberBoss;
    private int numberShow;

    public ManagerTankBoss(int numberBoss, int numberShow) {

        this.numberBoss = numberBoss;
        this.numberShow = numberShow;
        mListBoss = new ArrayList<>(numberBoss);
        initTankBoss();
    }

    public ArrayList<TankBoss> getmListBoss() {
        return mListBoss;
    }

    public void setmListBoss(ArrayList<TankBoss> mListBoss) {
        this.mListBoss = mListBoss;
    }

//    public void setmListBoss() {
//        TankBoss tankBoss;
//        for (int i = 0; i < numberBoss; i++) {
//            tankBoss = new TankBoss(0, 0, 0, 1, new Random().nextInt(3));
//            mListBoss.add(tankBoss);
//        }
//    }

    public void moveTankBoss(MapsManagers mapsManagers, Bird bird) {
        for (TankBoss tankBoss : mListBoss) {
            tankBoss.move(mapsManagers, bird);
        }
    }

    public void initTankBoss() {

        TankBoss tankBoss;
        Random random = new Random();
        for (int i = 0; i < numberBoss; i++) {
            tankBoss = new TankBoss(0, 0, 0, 0, random.nextInt(3));
            mListBoss.add(tankBoss);
        }
    }

    public void draw(Graphics2D graphics2D) {
        for (TankBoss tankBoss : mListBoss) {
            tankBoss.draw(graphics2D);
        }
    }
}