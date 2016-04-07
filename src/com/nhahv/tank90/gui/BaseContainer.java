package com.nhahv.tank90.gui;

import javax.swing.*;

/**
 * Created by Nhahv on 3/28/2016.
 */
public abstract class BaseContainer extends JPanel {

    protected BaseContainer() {
        initContainer();
        initComponents();
        addComponents();
        addEvents();
    }

    protected abstract void initContainer();

    protected abstract void initComponents();

    protected abstract void addComponents();

    protected abstract void addEvents();
}
