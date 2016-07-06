package net.colorman.handler;

import net.colorman.Game;
import net.colorman.level.Level_1;
import net.colorman.level.Level_2;
import net.colorman.level.Level_3;
import net.colorman.level.Level_R;
import net.colorman.objects.Object;
import net.colorman.threads.ActThread;

public class RoundHandler {

    /**
     * The round to be loaded
     */
    private static int round;

    public RoundHandler() {
        round = 1;
        setup();
    }

    /**
     * This Method handel's a round Win
     *
     */
    public void handelRoundWin() {
        round++;
        handelRoundEnd();
    }

    /**
     * This Method handel's the end of a Round and starts the setup of the next
     *
     */
    public void handelRoundEnd() {
        ActThread.WORK = false;
        clear();
        setup();
        ActThread.WORK = true;
    }

    /**
     * This Method clears the clears the Scene by all Objects
     *
     */
    private void clear() {
        Game.getInstance().getObjectHandler().getObjectsAct().forEach(Object::remove);
    }

    /**
     * This Method switches the Round and setup one
     *
     */
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
