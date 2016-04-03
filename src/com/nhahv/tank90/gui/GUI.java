package com.nhahv.tank90.gui;

import com.nhahv.tank90.images.ImagesManager;
import com.nhahv.tank90.models.Models;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

/**
 * Created by Nhahv on 3/28/2016.
 */
public class GUI extends JFrame {

    private MyContainer mMyContainer;

    public GUI() throws HeadlessException {

        initGUI();
        initComponents();
        addComponents();
        addEvents();
    }

    private void initGUI() {

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.setTitle(Models.TITLE);
        this.setSize(Models.WIDTH, Models.HEIGHT);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(new CardLayout());
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        // hide mouse
        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
        this.getContentPane().setCursor(blankCursor);

        try {
            UIManager.setLookAndFeel(WindowsLookAndFeel.class.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    private void initComponents() {
        mMyContainer = new MyContainer();
        mMyContainer.setExitGUI(
                () -> stopGUI()
        );

        new ImagesManager();
        new Models();
    }

    private void stopGUI() {
        int result = JOptionPane.showConfirmDialog(GUI.this, Models.CLOSE_WINDOWS,
                Models.CLOSE_WINDOWS, JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            dispose();
            System.exit(0);
        }
    }

    private void addComponents() {
        this.add(mMyContainer);
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        if (b) {
            mMyContainer.requestFocus();
        }
    }

    private void addEvents() {
        WindowAdapter adapter = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                stopGUI();
            }
        };
        this.addWindowListener(adapter);
    }
}
