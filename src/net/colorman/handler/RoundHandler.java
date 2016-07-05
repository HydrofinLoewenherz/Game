package net.colorman.handler;

import net.colorman.Game;
import net.colorman.level.Level_1;
import net.colorman.level.Level_2;
import net.colorman.level.Level_3;
import net.colorman.level.Level_R;
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
        ActThread.WORK = true;
    }

    private void clear() {
        Game.getInstance().getObjectHandler().getObjectsAct().forEach(Object::remove);
    }

    private void setup() {
        switch (round) {
            case 1:
                new Level_1();
                break;
            case 2:
                new Level_2();
                break;
            case 3:
                new Level_3();
                break;

            default: new Level_R();
        }
    }
}
