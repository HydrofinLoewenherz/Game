package net.colorman.handler;

import net.colorman.Game;
import net.colorman.threads.ActThread;

/**
 * Created by Paul on 12.06.2016.
 */
public class GameHandler {

    public GameHandler() {

    }

    public void handelGameStart() {
        Game.getInstance().getActThread().start();
    }

    public void handelGameEnd() {
        Game.getInstance().getWindow().close();
        Game.getInstance().getActThread().stopThread();
    }

    public void handelPauseOn() {
        Game.getInstance().getWindow().setFullScreen(true);
        if (!Game.getInstance().getGameScene().pause) Game.getInstance().getGameScene().getMainGroup().getChildren().add(Game.getInstance().getGameScene().getPauseMenu().get());
        Game.getInstance().getGameScene().pause = true;
        ActThread.WORK = false;
    }

    public void handelPauseOff() {
        Game.getInstance().getWindow().setFullScreen(true);
        if (Game.getInstance().getGameScene().pause) Game.getInstance().getGameScene().getMainGroup().getChildren().remove(Game.getInstance().getGameScene().getPauseMenu().get());
        Game.getInstance().getGameScene().pause = false;
        ActThread.WORK = true;
    }
}
