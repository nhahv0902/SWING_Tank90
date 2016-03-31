package com.nhahv.tank90.gui;

import com.nhahv.tank90.images.ImageIcons;
import com.nhahv.tank90.maps.Bird;
import com.nhahv.tank90.maps.ImagesMenu;
import com.nhahv.tank90.maps.MapsManagers;
import com.nhahv.tank90.models.Models;

import java.awt.*;

/**
 * Created by Nhahv on 3/29/2016.
 */
public class PlayGame extends BaseContainer {

    private int mLevel_1 = 1;
    private MapsManagers mMapsManagers;
    private Bird mBird;

    @Override
    protected void initContainer() {

        this.setSize(Models.WIDTH, Models.HEIGHT);
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        this.setVisible(true);
    }

    @Override
    protected void initComponents() {
    }

    @Override
    protected void addComponents() {
    }

    @Override
    protected void addEvents() {
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

        graphics2D.drawImage(new ImageIcons(Models.PLAY_TWO_UP).getImage(), Models.START_PLAYER_TWO, Models.START_PLAYER_HEIGHT, Models.SIZE_BOOS, Models.SIZE_BOOS, this);
        graphics2D.drawImage(new ImageIcons(Models.PLAY_ONE_UP).getImage(), Models.START_PLAYER_ONE, Models.START_PLAYER_HEIGHT, Models.SIZE_BOOS, Models.SIZE_BOOS, this);

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
}
