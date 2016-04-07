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

    public ArrayList<TankBoss> getListBoss() {
        return mListBoss;
    }

    public void moveTime() {
        for (TankBoss tankBoss : mListBoss) {
            tankBoss.moveTimeFire();
        }
    }

    public void initTankBoss() {

        TankBoss tankBoss;
        Random random = new Random();
        for (int i = 0; i < numberBoss && mListBoss.size() <= numberShow; i++) {
            tankBoss = new TankBoss(0, 0, 0, 0, random.nextInt(3));
            mListBoss.add(tankBoss);
        }
    }


    public void draw(Graphics2D graphics2D) {
        for (TankBoss tankBoss : mListBoss) {
            tankBoss.draw(graphics2D);
        }
    }

    public void tankFire() {
        for (TankBoss tankBoss : mListBoss) {
            tankBoss.tankFire();
        }
    }

    public void move(MapsManagers mMapsManagers, Bird mBird, ManagerTankBoss mTankBoss) {
        for (TankBoss tankBoss : mListBoss) {
            tankBoss.move(mMapsManagers, mBird, mTankBoss);
        }
    }

    public void moveBullet(MapsManagers mMapsManagers, Bird mBird, TankPlayer mPlayerOne, ManagerTankBoss mTankBoss) {
        for (TankBoss tankBoss : mListBoss) {
            tankBoss.moveBullet(mMapsManagers, mBird, mPlayerOne, mTankBoss);
        }
    }
}
