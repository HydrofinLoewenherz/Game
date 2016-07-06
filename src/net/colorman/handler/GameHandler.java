package net.colorman.handler;

import net.colorman.Game;
import net.colorman.threads.ActThread;

public class GameHandler {

    /**
     * This Method handel's the first start end setup of the Game
     *
     */
    public void handelGameStart() {
        Game.getInstance().getActThread().start();
    }

    /**
     * This Method handel's the end and close of the Game
     *
     */
    public void handelGameEnd() {
        Game.getInstance().getWindow().close();
        Game.getInstance().getActThread().stopThread();
    }

    /**
     * This Method handel's the activation a pause event
     *
     */
    public void handelPauseOn() {
        Game.getInstance().getWindow().setFullScreen(true);
        if (!Game.getInstance().getGameScene().pause) Game.getInstance().getGameScene().getMainGroup().getChildren().add(Game.getInstance().getGameScene().getPauseMenu().get());
        Game.getInstance().getGameScene().pause = true;
        ActThread.WORK = false;
    }

    /**
     * This Method handel's the negation of an pause event
     *
     */
    public void handelPauseOff() {
        Game.getInstance().getWindow().setFullScreen(true);
        if (Game.getInstance().getGameScene().pause) Game.getInstance().getGameScene().getMainGroup().getChildren().remove(Game.getInstance().getGameScene().getPauseMenu().get());
        Game.getInstance().getGameScene().pause = false;
        ActThread.WORK = true;
    }
}
