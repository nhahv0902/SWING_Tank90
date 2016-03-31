package com.nhahv.tank90.gui;

import javax.swing.*;

/**
 * Created by Nhahv on 3/28/2016.
 */
public abstract class BaseContainer extends JPanel {

    public BaseContainer() {

        initContainer();
        initComponents();
        addComponents();
        addEvents();
    }

    protected abstract void initContainer();

    protected abstract void initComponents();

    protected abstract void addComponents();

    protected abstract void addEvents();

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
