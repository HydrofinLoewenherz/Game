package net.colorman.threads;

import net.colorman.Game;
import net.colorman.objects.Object;
import net.colorman.objects.entitys.player.Player;

/**
 * Created by Paul on 13.06.2016.
 */
public class ActThread extends Thread {

    public static boolean ACTIVE, WORK;
    public double waitTime;
    public double slideSpeed = 2;
    public boolean slide = false;

    public ActThread(double time) {
        waitTime = time;
        ACTIVE = true;
        WORK = false;
    }

    @Override
    public void run() {
        while (ACTIVE) {
            if (WORK) {
                ingameWork();
                testEnd();
            }
            waitTime();
        }
    }

    private void ingameWork() {
        Game.getInstance().getObjectHandler().getObjectsAct().forEach(Object::act);
        if (slide) slideAll();
    }

    private void testEnd() {

    }

    public void slideAll() {
        Game.getInstance().getObjectHandler().getObjectsAct().forEach(object -> {
            if (!(object instanceof Player)) object.slide(slideSpeed);
        });
    }

    private void waitTime() {
        try {
            sleep( (long) waitTime);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    public void stopThread() {
        ACTIVE = false;
    }
}
