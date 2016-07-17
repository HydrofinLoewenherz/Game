package net.colorman.objects.entitys.player;

import net.colorman.Game;
import net.colorman.misc.Vector;
import net.colorman.objects.entitys.Entity;

import java.awt.*;

public class Player extends Entity {

    private double speed = 100;
    private double moveCounter;

    public Player() {
        super(Game.getInstance().getResourceLoader().getImage("player.png"), null);
        toFront();
        moveCounter = 0;
    }

    @Override
    public void act() {
        //Vector vector = Game.getInstance().getGameScene().getKeyboardHandler().getMainVector();
        if (moveCounter > 0) {
            moveCounter -= .2;
        }

        while (Game.getInstance().getCommandHandler().isKeyCommandAvailable()) {
            Point point = Game.getInstance().getCommandHandler().getCurrentCommand();
            if (++moveCounter < 5) {
                vector.add(new Vector(point.getX() - getTranslateX(), point.getY() - getTranslateY(), speed));
            }
        }

        vector.add(gravity);
        move(vector);
    }

    @Override
    public void slide(double speed) {
        super.slide(speed);
    }
}
