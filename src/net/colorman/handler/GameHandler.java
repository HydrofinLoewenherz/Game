package net.colorman.handler;

import net.colorman.Game;

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
}
