package net.colorman.handler;

import net.colorman.Game;
import net.colorman.level.LevelOne;
import net.colorman.level.LevelTwo;
import net.colorman.objects.Object;
import net.colorman.threads.ActThread;

/**
 * Created by Paul on 26.06.2016.
 */
public class RoundHandler {

    private static int round;

    public RoundHandler() {
        round = 1;
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
        ActThread.WORK = true;
    }

    private void clear() {
        Game.getInstance().getObjectHandler().getObjectsAct().forEach(Object::remove);
    }

    private void setup() {
        switch (round) {
            case 1:
                new LevelOne();
                break;
            case 2:
                new LevelTwo();
                break;

            default: new LevelOne();
        }
    }
}
