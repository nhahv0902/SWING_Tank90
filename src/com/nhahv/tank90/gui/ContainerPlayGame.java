package com.nhahv.tank90.gui;

import com.nhahv.tank90.maps.ImagesMenu;
import com.nhahv.tank90.models.Models;

import java.awt.*;

/**
 * Created by Nhahv on 4/2/2016.
 */
public class ContainerPlayGame extends BaseContainer {

    private PlayGame mPlayGame;

    @Override
    protected void initContainer() {
        this.setSize(Models.WIDTH, Models.HEIGHT);
        this.setLayout(null);
        this.setVisible(true);
    }

    @Override
    protected void initComponents() {
        mPlayGame = new PlayGame();
        mPlayGame.setLocation(Models.WIDTH_GUIDE + Models.PADDING_LEFT, Models.PADDING_TOP);
        mPlayGame.setVisible(true);
        mPlayGame.requestFocus();
        mPlayGame.requestFocus(true);
        mPlayGame.requestFocusInWindow();
    }

    @Override
    protected void addComponents() {
        this.add(mPlayGame);
    }

    @Override
    protected void addEvents() {
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        drawGuideLeftRight(graphics2D);
    }


    private void drawGuideLeftRight(Graphics2D graphics2D) {
        ImagesMenu images = new ImagesMenu(0, 0, Models.ICONS_GUIDE_LEFT);
        images.setPaddingX(Models.PADDING_LEFT / 2);
        images.setY(Models.PADDING_TOP);
        images.setHeight(Models.SIZE_MAPS);
        images.draw(graphics2D);

        images = new ImagesMenu(0, 0, Models.ICONS_GUIDE_RIGHT);
        images.setPaddingX(Models.WIDTH - Models.WIDTH_GUIDE - Models.PADDING_LEFT / 2);
        images.setY(Models.PADDING_TOP);
        images.setHeight(Models.SIZE_MAPS);
        images.draw(graphics2D);
    }

    public PlayGame getPlayGame() {
        return mPlayGame;
    }
}
