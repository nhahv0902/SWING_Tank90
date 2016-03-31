package com.nhahv.tank90.gui;

import com.nhahv.tank90.images.ImageIcons;
import com.nhahv.tank90.interfaces.Interfaces;
import com.nhahv.tank90.maps.ImagesMenu;
import com.nhahv.tank90.models.Models;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Nhahv on 3/29/2016.
 */
public class MenuGame extends BaseContainer {

    private Interfaces mInterface;
    private boolean isOne = true;
    private ImagesMenu mIconPlayOne, mPlayOne, mPlayTwo, mTankRun;
    private Thread mThread;

    @Override
    public void initContainer() {

        this.setSize(Models.WIDTH, Models.HEIGHT);
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        this.setVisible(true);
        this.requestFocus();
    }

    @Override
    public void initComponents() {

        mTankRun = new ImagesMenu(0, 0, 0, 0, Models.ICON_RUN_DOWN);
        mTankRun.setPaddingX(0);

        mPlayOne = new ImagesMenu(0, 400, 0, 0, Models.ICONS_PLAY_ONE);
        mPlayOne.setPaddingX(500);
        mPlayTwo = new ImagesMenu(0, 400 + 40, 0, 0, Models.ICONS_PLAY_TWO);
        mPlayTwo.setPaddingX(500);

        mIconPlayOne = new ImagesMenu(0, 400, 0, 0, Models.ICON_BT_PLAY);
        mIconPlayOne.setPaddingX(450);
    }

    @Override
    public void addComponents() {
    }

    public void addEvents() {

        startThreadPlay();
        KeyAdapter mKeyAdapter = new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);

                if (e.getKeyCode() == KeyEvent.VK_UP
                        || e.getKeyCode() == KeyEvent.VK_DOWN) {
                    mIconPlayOne.moveOneTwo(isOne);
                    if (isOne) {
                        isOne = false;
                    } else {
                        isOne = true;
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    mInterface.exitGUI();
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    mInterface.showPlayGame();
                    if (mThread.isAlive()) {
                        mThread.stop();
                    }
                }
            }
        };
        this.addKeyListener(mKeyAdapter);
    }

    private void startThreadPlay() {

        mThread = new Thread(() -> {
            while (true) {
                try {
                    mPlayOne.changeImage(new ImageIcons(Models.ICONS_PLAY_ONE).getImage());
                    mPlayTwo.changeImage(new ImageIcons(Models.ICONS_PLAY_TWO).getImage());
                    mTankRun.move();
                    Thread.sleep(3);
                    if (isOne) {
                        mPlayOne.changeImage(new ImageIcons(Models.ICONS_PLAY_ONE_OFF).getImage());
                    } else {
                        mPlayTwo.changeImage(new ImageIcons(Models.ICONS_PLAY_TWO_OFF).getImage());
                    }

                    repaint();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        mThread.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;

        ImagesMenu images = new ImagesMenu(0, 100, 0, 0, Models.ICONS_FACE_MENU);
        images.draw(graphics2D);

        images = new ImagesMenu(0, 600, 0, 0, Models.ICON_DOCUMENTS);
        images.draw(graphics2D);

        images = new ImagesMenu(0, 500, 0, 0, Models.ICON_MENU);
        images.draw(graphics2D);

        mTankRun.draw(graphics2D);
        mPlayOne.draw(graphics2D);
        mPlayTwo.draw(graphics2D);

        mIconPlayOne.draw(graphics2D);
    }

    public void setExitGUI(Interfaces interfaces) {
        this.mInterface = interfaces;
    }
}
