package com.nhahv.tank90.gui;

import com.nhahv.tank90.maps.ImagesMenu;
import com.nhahv.tank90.models.Models;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Nhahv on 4/2/2016.
 */
public class ContainerPlayGame extends BaseContainer {

    private PlayGameTank mPlayGameTank;

    @Override
    protected void initContainer() {
        this.setSize(Models.WIDTH, Models.HEIGHT);
        this.setLayout(null);
        this.setVisible(true);
    }

    @Override
    protected void initComponents() {

        mPlayGameTank = new PlayGameTank();
        mPlayGameTank.setLocation(Models.WIDTH_GUIDE + Models.PADDING_LEFT, 0);
        mPlayGameTank.setVisible(true);
        mPlayGameTank.requestFocus();
        mPlayGameTank.requestFocus(true);
        mPlayGameTank.requestFocusInWindow();
    }

    @Override
    protected void addComponents() {
        this.add(mPlayGameTank);
    }

    @Override
    protected void addEvents() {
        KeyAdapter keyAdapter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    System.out.println("Enter");
                }
            }
        };
        this.addKeyListener(keyAdapter);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        drawGuideLeftRight(graphics2D);
    }


    private void drawGuideLeftRight(Graphics2D graphics2D) {
        ImagesMenu images = new ImagesMenu(0, 0, 0, 0, Models.ICONS_GUIDE_LEFT);
        images.setPaddingX(0);
        images.draw(graphics2D);

        images = new ImagesMenu(0, 0, 0, 0, Models.ICONS_GUIDE_RIGHT);
        images.setPaddingX(Models.WIDTH - 250);
        images.draw(graphics2D);
    }

    public PlayGameTank getPlayGame(){
        return mPlayGameTank;
    }
}
