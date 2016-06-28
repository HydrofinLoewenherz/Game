package net.colorman.handler;

import net.colorman.Game;
import net.colorman.level.LevelOne;
import net.colorman.objects.Object;
import net.colorman.threads.ActThread;

/**
 * Created by Paul on 26.06.2016.
 */
public class RoundHandler {

    private static int round;

    public RoundHandler() {
        round = 0;
        setup();
    }

    public void handelRoundWin() {
        round++;
        handelRoundEnd();
    }

    public void handelRoundEnd() {
        ActThread.WORK = false;
        clear();
        setup();
    }

    private void clear() {
        Game.getInstance().getObjectHandler().getObjectsAct().forEach(Object::remove);
    }

    private void setup() {
        switch (round) {
            default: new LevelOne();
        }
    }
}
