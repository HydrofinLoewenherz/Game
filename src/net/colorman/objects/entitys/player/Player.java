package net.colorman.objects.entitys.player;

import net.colorman.Game;
import net.colorman.misc.Vector;
import net.colorman.objects.entitys.Entity;

public class Player extends Entity {

    public Player() {
        super(Game.getInstance().getObjectHandler().getResourceLoader().getImage("player.png"), null);
        toFront();
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
