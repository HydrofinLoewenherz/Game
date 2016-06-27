package net.colorman.handler;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import net.colorman.Game;
import net.colorman.misc.Vector;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul on 26.06.2016.
 */

public class KeyboardHandler {
    private List<KeyCode> keysDown;
    private double defaultSpeed = 5;

    private final Vector down = new Vector(0,1,defaultSpeed);
    private final Vector up = new Vector(0,-1,defaultSpeed);
    private final Vector left = new Vector(-1,0,defaultSpeed);
    private final Vector right = new Vector(1,0,defaultSpeed);

    public KeyboardHandler(Scene scene) {
        keysDown = new ArrayList<>();

        scene.setOnKeyPressed(this::add);
        scene.setOnKeyReleased(this::remove);
    }

    private void add(KeyEvent event) {
        keysDown.add(event.getCode());
        if (event.getCode() == KeyCode.ESCAPE) {
            Game.getInstance().getWindow().setMaximized(true);
            Game.getInstance().getMainHandler().handelPauseOn();
        }
    }

    private void remove(KeyEvent event) {
        keysDown.remove(event.getCode());
    }

    public Vector getMovementVector(boolean inAir) {
        Vector movementVector = new Vector(0,0,1);

        for (KeyCode code : keysDown) {
            switch (code) {
                case SPACE:
                    if (!inAir) movementVector.add(up);
                    break;
                case A:
                    if (!inAir) movementVector.add(left);
                    break;
                case S:
                    if (inAir) movementVector.add(down);
                    break;
                case D:
                    if (!inAir) movementVector.add(right);
                    break;
                default: //Nothing
                    break;
            }
        }

        return movementVector;
    }
}
