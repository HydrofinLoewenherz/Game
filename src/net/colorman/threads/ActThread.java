package net.colorman.threads;

/**
 * Created by Paul on 13.06.2016.
 */
public class ActThread extends Thread {

    public static boolean ACTIVE, WORK;
    public double waitTime;

    public ActThread(double time) {
        waitTime = time;
        ACTIVE = true;
        WORK = false;
    }

    @Override
    public void run() {
        while (ACTIVE) {
            if (WORK)
                ingameWork();
            meunWork();
            waitTime();
        }
    }

    private void ingameWork() {
        // All Objects act
    }

    private void meunWork() {
        //open Side Menu
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
