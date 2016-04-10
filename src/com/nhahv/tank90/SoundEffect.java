package com.nhahv.tank90;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

/**
 * Created by Nhahv on 4/9/2016.
 */
public class SoundEffect implements LineListener {

    private Clip mClip;
    private boolean isDone;

    public SoundEffect(String name) {
        URL url = getClass().getResource(name);

        try {
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(url);
            mClip = AudioSystem.getClip();
            mClip.open(inputStream);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

    }

    public void play() {
        if (mClip != null) {
            mClip.start();
        }
    }

    public void playRun() {
        new Thread() {
            @Override
            public void run() {
                isDone = false;
                mClip.start();
                while (!isDone) {
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }


    public void stop() {
        if (mClip.isRunning()) {
            mClip.stop();
            mClip.close();
        }
    }


    public void loop(int count) {
        mClip.loop(count);
    }

    @Override
    public void update(LineEvent event) {
        if (event.getType() == LineEvent.Type.CLOSE
                || event.getType() == LineEvent.Type.STOP) {
            isDone = true;
        }
    }

}
