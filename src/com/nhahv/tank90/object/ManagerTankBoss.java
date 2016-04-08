package com.nhahv.tank90.object;

import com.nhahv.tank90.maps.Bird;
import com.nhahv.tank90.maps.MapsManagers;
import com.nhahv.tank90.models.Models;

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
    private int numberBossCurrent;

    public ManagerTankBoss() {

        this.numberBoss = Models.NUMBER_TANK_BOSS;
        this.numberShow = Models.NUMBER_BOOS_SHOW;
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
        for (int i = 0; i < numberShow; i++) {
            tankBoss = new TankBoss(0, 0, 0, 0, random.nextInt(3));
            mListBoss.add(tankBoss);
        }
        numberBoss -= mListBoss.size();
        numberBossCurrent = mListBoss.size();
    }

    public void addListTankBoss() {
        Random random = new Random();
        int x = random.nextInt(3);
        TankBoss tankBoss;
        if (numberBossCurrent < numberShow && numberBoss > 0) {

            if (numberBoss < x) {
                x = x - numberBoss;
            }

            for (int i = 0; i < x; i++) {
                tankBoss = new TankBoss(0, 0, 0, 0, random.nextInt(3));
                mListBoss.add(tankBoss);
            }
            numberBossCurrent += x;
            numberBoss -= x;
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

    public void moveNumberBulletCurrent() {
        numberBossCurrent--;
    }
}
