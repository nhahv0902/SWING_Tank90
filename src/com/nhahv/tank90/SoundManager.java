package com.nhahv.tank90;

import com.nhahv.tank90.models.Models;

import javax.sound.sampled.Clip;

/**
 * Created by Nhahv on 4/9/2016.
 */
public class SoundManager {

   private SoundEffect runGame;
   private SoundEffect explosison;
   private SoundEffect levelUp;
   private SoundEffect life;
   private SoundEffect move;
   private SoundEffect shoot;
   private SoundEffect shootStone;
   private SoundEffect shootTank;

    public SoundManager() {
        runGame = new SoundEffect(Models.SOUND_RUN_GAME);
        runGame.loop(Clip.LOOP_CONTINUOUSLY);
        explosison = new SoundEffect(Models.SOUND_EXPLOSION);
        levelUp = new SoundEffect(Models.SOUND_LEVEL_UP);
        life = new SoundEffect(Models.SOUND_LIFE);
        move = new SoundEffect(Models.SOUND_MOVE);
        shoot = new SoundEffect(Models.SOUND_SHOOT);
        shootStone = new SoundEffect(Models.SOUND_SHOOT_STONE);
        shootTank = new SoundEffect(Models.SOUND_SHOOT_TANK);
    }

    public SoundEffect getRunGame() {
        return runGame;
    }

    public void setRunGame(SoundEffect runGame) {
        this.runGame = runGame;
    }

    public SoundEffect getExplosison() {
        return explosison;
    }

    public void setExplosison(SoundEffect explosison) {
        this.explosison = explosison;
    }

    public SoundEffect getLevelUp() {
        return levelUp;
    }

    public void setLevelUp(SoundEffect levelUp) {
        this.levelUp = levelUp;
    }

    public SoundEffect getLife() {
        return life;
    }

    public void setLife(SoundEffect life) {
        this.life = life;
    }

    public SoundEffect getMove() {
        return move;
    }

    public void setMove(SoundEffect move) {
        this.move = move;
    }

    public SoundEffect getShoot() {
        return shoot;
    }

    public void setShoot(SoundEffect shoot) {
        this.shoot = shoot;
    }

    public SoundEffect getShootStone() {
        return shootStone;
    }

    public void setShootStone(SoundEffect shootStone) {
        this.shootStone = shootStone;
    }

    public SoundEffect getShootTank() {
        return shootTank;
    }

    public void setShootTank(SoundEffect shootTank) {
        this.shootTank = shootTank;
    }
}