package net.colorman.threads;

import net.colorman.Game;
import net.colorman.objects.Object;
import net.colorman.objects.entitys.player.Player;

import java.awt.*;

/**
 * Created by Paul on 13.06.2016.
 */
public class ActThread extends Thread {

    /**
     * Booleans to see if the Thread is ACTIVE or/and at WORK
     */
    public static boolean ACTIVE, WORK;

    /**
     * A double for the waitTime - defines the FPS Maximum
     */
    public double waitTime;

    /**
     * A Boolean to if the Game has to Slide
     */
    public boolean slide = false;

    public ActThread(double time) {
        waitTime = time;
        ACTIVE = true;
        WORK = false;

        slide = true;
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

    /**
     * This Method dose the work for the playable Game
     *
     */
    private void ingameWork() {

        Game.getInstance().getObjectHandler().getObjectsActTemp().forEach(object -> Game.getInstance().getObjectHandler().addObjectAct(object));
        Game.getInstance().getObjectHandler().getObjectsActTemp().clear();

        Game.getInstance().getObjectHandler().getObjectsToRemove().forEach(object -> Game.getInstance().getObjectHandler().getObjectsAct().remove(object));
        Game.getInstance().getObjectHandler().getObjectsToRemove().clear();

        Game.getInstance().getObjectHandler().getObjectsAct().forEach(Object::act);
        slideAll();
    }

    /**
     * This Method reacts is the Player is outOfBounds
     *
     * @see #isPlayerOutOfBounds(Player)
     *
     */
    private void testEnd() {
        Player player = Game.getInstance().getObjectHandler().getPlayer();
        if (isPlayerOutOfBounds(player)) Game.getInstance().getRoundHandler().handelRoundEnd();

    }

    /**
     * This Method tests if the Player is outOfBounds (the Player has fallen out of the Game at the Bottom or the left Side)
     *
     * @param player    Player
     * @return Boolean  isOutOfBounds
     */
    private boolean isPlayerOutOfBounds(Player player) {
        return (player.getTranslateY() > Toolkit.getDefaultToolkit().getScreenSize().getHeight() || player.getTranslateX() + player.getImage().getWidth() < 0);
    }

    /**
     * This Method calculates the SlideSpeed
     *
     * @return Double   SlideSpeed
     */
    private double mathSlideSpeed() {
        double temp = Game.getInstance().getObjectHandler().getPlayer().getTranslateX() - Toolkit.getDefaultToolkit().getScreenSize().getWidth() * .5;
        if (temp < 0) return 0;
        else return temp;
    }

    /**
     * This Method slides All Objects by the SlideSpeed
     *
     * @see #mathSlideSpeed()
     *
     */
    public void slideAll() {
        double speed = mathSlideSpeed();
        Game.getInstance().getObjectHandler().getObjectsAct().forEach(object -> object.slide(speed));
    }

    /**
     * This Method is a timer that waits the waitingTime
     *
     * @see #waitTime()
     *
     */
    private void waitTime() {
        try {
            sleep( (long) waitTime);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * This Method stops the Thread
     *
     */
    public void stopThread() {
        ACTIVE = false;
    }
}
