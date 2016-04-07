package com.nhahv.tank90.gui;

import com.nhahv.tank90.maps.Bird;
import com.nhahv.tank90.maps.MapsManagers;
import com.nhahv.tank90.models.Models;
import com.nhahv.tank90.object.ManagerTankBoss;
import com.nhahv.tank90.object.TankPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.BitSet;

/**
 * Created by Nhahv on 4/2/2016.
 */
public class PlayGame extends BaseContainer {

    private static int mLevel_1 = 1;
    private MapsManagers mMapsManagers;
    private Bird mBird;

    private TankPlayer mPlayerOne;
    private KeyAdapter mKeyAdapter;
    private BitSet mKeyValue;
    private Runnable mRunnable;
    private Thread mThreadPlayerOne;

    private Graphics2D mGraphics2D;
    private ManagerTankBoss mTankBoss;

    @Override
    protected void initContainer() {
        this.setSize(Models.SIZE_MAPS, Models.SIZE_MAPS);
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        this.setVisible(true);
    }

    @Override
    protected void initComponents() {
    }

    @Override
    protected void addComponents() {
        initObject();
    }

    private void initObject() {
        mKeyValue = new BitSet(256);
        mKeyValue.clear();
        mPlayerOne = new TankPlayer(0, 0, 0, 0, 0);
        mBird = new Bird();
        mMapsManagers = new MapsManagers(mLevel_1);
        mTankBoss = new ManagerTankBoss(24, 4);
    }

    @Override
    protected void addEvents() {
        mKeyAdapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                mKeyValue.set(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                mKeyValue.clear(e.getKeyCode());
            }
        };

        this.addKeyListener(mKeyAdapter);

        mRunnable = () -> {
            try {
                while (true) {

                    if (mBird != null && !mBird.getLive()) {
                        JOptionPane.showConfirmDialog(PlayGame.this, "message");
                        mThreadPlayerOne.stop();
                    }
                    Thread.sleep(Models.TIME_SLEEP);
                    moveTankPlayer();
                    mPlayerOne.moveBullet(mMapsManagers, mBird, mPlayerOne, mTankBoss);
                    mPlayerOne.moveTimeFire();
                    mTankBoss.tankFire();
                    mTankBoss.move(mMapsManagers, mBird, mTankBoss);
                    mTankBoss.moveBullet(mMapsManagers, mBird, mPlayerOne, mTankBoss);
                    mTankBoss.moveTime();


                    repaint();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        mThreadPlayerOne = new Thread(mRunnable);
        mThreadPlayerOne.start();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        mGraphics2D = (Graphics2D) g;
        mGraphics2D.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED);
        mGraphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        mGraphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        drawMaps(mGraphics2D);
        drawBird(mGraphics2D);
        mPlayerOne.draw(mGraphics2D);
        mTankBoss.draw(mGraphics2D);
    }

    private void drawMaps(Graphics2D graphics2D) {
        mMapsManagers.drawMaps(graphics2D);
    }

    private void drawBird(Graphics2D graphics2D) {
        mBird.draw(graphics2D);
    }

    private void moveTankPlayer() {

        if (mKeyValue.get(KeyEvent.VK_UP)) {
            mPlayerOne.setOrient(Models.UP);
            mPlayerOne.move(mMapsManagers, mBird, mTankBoss);
        } else if (mKeyValue.get(KeyEvent.VK_DOWN)) {
            mPlayerOne.setOrient(Models.DOWN);
            mPlayerOne.move(mMapsManagers, mBird, mTankBoss);
        } else if (mKeyValue.get(KeyEvent.VK_LEFT)) {
            mPlayerOne.setOrient(Models.LEFT);
            mPlayerOne.move(mMapsManagers, mBird, mTankBoss);
        } else if (mKeyValue.get(KeyEvent.VK_RIGHT)) {
            mPlayerOne.setOrient(Models.RIGHT);
            mPlayerOne.move(mMapsManagers, mBird, mTankBoss);
        }
        if (mKeyValue.get(KeyEvent.VK_ENTER)) {
            mPlayerOne.tankFire();
        }
    }

    @Override
    public void setVisible(boolean aFlag) {
        super.setVisible(aFlag);
        if (aFlag) {
            this.requestFocus();
            this.requestFocus(true);
            this.requestFocusInWindow();
        }
    }
}
