package net.colorman.objects.entitys.player;

import net.colorman.Game;
import net.colorman.misc.Vector;
import net.colorman.objects.entitys.Entity;

/**
 * Created by Paul on 13.06.2016.
 */
public class Player extends Entity {

    private double speed;

    public Player() {
        super(Game.getInstance().getObjectHandler().getResourceLoader().getImage("player.png"), null);
        toFront();
        speed = 10;
    }

    @Override
    public void act() {
        Vector vector = Game.getInstance().getGameScene().getKeyboardHandler().getMainVector();
        vector.add(gravity);
        this.vector = vector;

        move();
    }

    @Override
    public void slide(double speed) {
        super.slide(speed);
    }
}
