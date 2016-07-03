package net.colorman.threads;

import net.colorman.Game;
import net.colorman.objects.Object;
import net.colorman.objects.entitys.player.Player;

import java.awt.*;

/**
 * Created by Paul on 13.06.2016.
 */
public class ActThread extends Thread {

    public static boolean ACTIVE, WORK;
    public double waitTime;
    public double slideSpeed = 20;
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

    private void ingameWork() {

        Game.getInstance().getObjectHandler().getObjectsActTemp().forEach(object -> Game.getInstance().getObjectHandler().addObjectAct(object));
        Game.getInstance().getObjectHandler().getObjectsActTemp().clear();

        Game.getInstance().getObjectHandler().getObjectsToRemove().forEach(object -> Game.getInstance().getObjectHandler().getObjectsAct().remove(object));
        Game.getInstance().getObjectHandler().getObjectsToRemove().clear();

        Game.getInstance().getObjectHandler().getObjectsAct().forEach(Object::act);
        slideAll();
    }

    private void testEnd() {
        Player player = Game.getInstance().getObjectHandler().getPlayer();
        if (isPlayerOutOfBounds(player)) Game.getInstance().getRoundHandler().handelRoundEnd();

    }

    private boolean isPlayerOutOfBounds(Player player) {
        return (player.getTranslateY() > Toolkit.getDefaultToolkit().getScreenSize().getHeight() || player.getTranslateX() + player.getImage().getWidth() < 0);
    }

    private double mathSlideSpeed() {
        double temp = Game.getInstance().getObjectHandler().getPlayer().getTranslateX() - Toolkit.getDefaultToolkit().getScreenSize().getWidth() * .75;
        if (temp < 0) return 0;
        else return temp;
    }

    public void slideAll() {
        double speed = mathSlideSpeed();
        Game.getInstance().getObjectHandler().getObjectsAct().forEach(object -> object.slide(speed));
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
