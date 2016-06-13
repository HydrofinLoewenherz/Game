package net.colorman.threads;

import net.colorman.Game;

/**
 * Created by Paul on 13.06.2016.
 */
public class ActThread extends Thread {

    public static boolean ACTIVE, WORK;
    public double waitTime;

    public ActThread(double time) {
        waitTime = time;
        ACTIVE = true;
        WORK = true;
    }

    @Override
    public void run() {
        while (ACTIVE) {
            if (WORK)
                work();
            waitTime();
        }
    }

    private void work() {

    }

    private void waitTime() {
        try {
            sleep( (long) waitTime);
        } catch (InterruptedException exception) {
            Game.getInstance().getExceptionHandler().addException("ActThread", "InterruptedExeption");
        }
    }
}
