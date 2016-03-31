package com.nhahv.tank90.gui;

import com.nhahv.tank90.interfaces.ExitGUI;
import com.nhahv.tank90.interfaces.Interfaces;
import com.nhahv.tank90.models.Models;

import java.awt.*;

/**
 * Created by Nhahv on 3/29/2016.
 */
public class MyContainer extends BaseContainer {

    private MenuGame mMenuGame;
    private CardLayout mCardLayout;

    private PlayGame mPlayGame;
    private ExitGUI mExitGUI;
    private Interfaces mInterface;

    @Override
    protected void initContainer() {

        this.setSize(Models.WIDTH, Models.HEIGHT);
        mInterface = new Interfaces() {
            public void showPlayGame() {
                mCardLayout.show(MyContainer.this, Models.PLAY_GAME);
                mPlayGame.requestFocus();
            }

            public void exitGUI() {
                mExitGUI.exitGUI();
            }
        };
        mCardLayout = new CardLayout();
        mCardLayout.invalidateLayout(this);
        this.setLayout(mCardLayout);
    }

    @Override
    protected void initComponents() {

        mMenuGame = new MenuGame();
        mMenuGame.setExitGUI(mInterface);
        mPlayGame = new PlayGame();
    }

    @Override
    protected void addComponents() {
        this.add(mMenuGame, Models.MENU_GAME);
        this.add(mPlayGame, Models.PLAY_GAME);
    }

    @Override
    protected void addEvents() {

    }

    @Override
    public void requestFocus() {
        super.requestFocus();
        if (mMenuGame != null) {
            mMenuGame.requestFocus();
        }
    }

    public void setExitGUI(ExitGUI interfaces) {
        this.mExitGUI = interfaces;
    }
}
