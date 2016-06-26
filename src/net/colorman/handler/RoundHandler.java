package net.colorman.handler;

import net.colorman.Game;
import net.colorman.objects.Object;
import net.colorman.objects.entitys.player.Player;
import net.colorman.objects.structure.Background;
import net.colorman.objects.structure.Platform;
import net.colorman.threads.ActThread;

import java.util.List;

/**
 * Created by Paul on 26.06.2016.
 */
public class RoundHandler {

    private static int round;
    private Player player;

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
        List<Object> temp = Game.getInstance().getObjectHandler().getObjectsAct();
        temp.stream().filter(object -> !(object instanceof Player))
                .filter(object -> !(object instanceof Background))
                .filter(object -> !(object instanceof Platform))
                .forEach(object -> Game.getInstance().getObjectHandler().removeObjectsAct(object));
    }

    private void setup() {
        switch (round) {
            default: setupRound1();
        }

        //player.setLocation(100,100);
    }

    private void setupRound1() {
        new Platform(200, 200, 2);
        new Platform(100, 100, 2);
    }
}
