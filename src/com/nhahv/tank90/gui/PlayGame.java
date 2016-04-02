package com.nhahv.tank90.gui;

import com.nhahv.tank90.images.ImagesManager;
import com.nhahv.tank90.maps.Bird;
import com.nhahv.tank90.maps.ImagesMenu;
import com.nhahv.tank90.maps.MapsManagers;
import com.nhahv.tank90.models.Models;
import com.nhahv.tank90.object.TankBoss;
import com.nhahv.tank90.object.TankPlayer;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.BitSet;

/**
 * Created by Nhahv on 3/29/2016.
 */
public class PlayGame extends BaseContainer {

    private int mLevel_1 = 1;
    private MapsManagers mMapsManagers;
    private Bird mBird;

    private TankPlayer mPlayerOne;
    private KeyAdapter mKeyAdapter;
    private BitSet mKeyValue;
    private Runnable mRunnable;
    private Thread mThreadPlayerOne;

    private TankBoss mBoss;


    @Override
    protected void initContainer() {

        this.setSize(Models.WIDTH, Models.HEIGHT);
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        this.setVisible(true);
    }

    @Override
    protected void initComponents() {
        mPlayerOne = new TankPlayer(0, 0, 0, 0, 0, 0, 1);
        mBoss = new TankBoss(0, 0, 0, 0, 0, 0, 1);
        mKeyValue = new BitSet(256);
    }

    @Override
    protected void addComponents() {
    }

    @Override
    protected void addEvents() {
        mKeyAdapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                mKeyValue.set(e.getKeyCode());
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    System.out.println("enter");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                mKeyValue.clear(e.getKeyCode());
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    System.out.println("enter");
                }
            }
        };

        this.addKeyListener(mKeyAdapter);

        mRunnable = () -> {
            try {
                while (true) {
                    Thread.sleep(Models.TIME_SLEEP);
                    moveTankPlayer();
                    mPlayerOne.moveBullet();
                    mPlayerOne.moveTimeFire();

//                    mBoss.moveBullet();
//                    mBoss.moveTimeFire();
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

        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);

        drawMaps(graphics2D);
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawRect(Models.WIDTH_GUIDE, 0, Models.PADDING_LEFT, Models.HEIGHT);
        graphics2D.fillRect(Models.WIDTH_GUIDE, 0, Models.PADDING_LEFT, Models.HEIGHT);

        graphics2D.drawRect(Models.START_GUIDE_RIGHT - Models.PADDING_LEFT, 0, Models.PADDING_LEFT, Models.HEIGHT);
        graphics2D.fillRect(Models.START_GUIDE_RIGHT - Models.PADDING_LEFT, 0, Models.PADDING_LEFT, Models.HEIGHT);

        drawBird(graphics2D);

//        graphics2D.drawImage(new ImageIcons(Models.PLAY_TWO_UP).getImage(), Models.START_PLAYER_TWO, Models.START_PLAYER_HEIGHT, Models.SIZE_BOOS, Models.SIZE_BOOS, this);
//        graphics2D.drawImage(new ImageIcons(Models.PLAY_ONE_UP).getImage(), Models.START_PLAYER_ONE, Models.START_PLAYER_HEIGHT, Models.SIZE_BOOS, Models.SIZE_BOOS, this);
        mPlayerOne.draw(graphics2D);
        ArrayList<Image> images = ImagesManager.getListBoss_1();
//        graphics2D.drawImage(images.get(0), Models.START_PLAYER_ONE, Models.START_PLAYER_HEIGHT, Models.SIZE_BOOS, Models.SIZE_BOOS, this);

        mBoss.draw(graphics2D);
        drawGuideLeftRight(graphics2D);
    }

    private void drawMaps(Graphics2D graphics2D) {
        mMapsManagers = new MapsManagers(mLevel_1);
        mMapsManagers.drawMaps(graphics2D);
    }

    private void drawBird(Graphics2D graphics2D) {
        mBird = new Bird();
        mBird.draw(graphics2D);
    }

    private void drawGuideLeftRight(Graphics2D graphics2D) {
        ImagesMenu images = new ImagesMenu(0, 0, 0, 0, Models.ICONS_GUIDE_LEFT);
        images.setPaddingX(0);
        images.draw(graphics2D);

        images = new ImagesMenu(0, 0, 0, 0, Models.ICONS_GUIDE_RIGHT);
        images.setPaddingX(Models.WIDTH - 250);
        images.draw(graphics2D);
    }

    private void moveTankPlayer() {

        if (mKeyValue.get(KeyEvent.VK_UP)) {
            mPlayerOne.setOrient(Models.UP);
            mPlayerOne.move(mMapsManagers, mBird);
        } else if (mKeyValue.get(KeyEvent.VK_DOWN)) {
            mPlayerOne.setOrient(Models.DOWN);
            mPlayerOne.move(mMapsManagers, mBird);

        } else if (mKeyValue.get(KeyEvent.VK_LEFT)) {
            mPlayerOne.setOrient(Models.LEFT);
            mPlayerOne.move(mMapsManagers, mBird);

        } else if (mKeyValue.get(KeyEvent.VK_RIGHT)) {
            mPlayerOne.setOrient(Models.RIGHT);
            mPlayerOne.move(mMapsManagers, mBird);
        }
        if (mKeyValue.get(KeyEvent.VK_ENTER)) {
            mPlayerOne.tankFire();
        }
    }


}
