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
    List<KeyCode> keysDown;
    Vector mainVector;

    public KeyboardHandler(Scene scene) {
        keysDown = new ArrayList<>();
        mainVector = new Vector(0,0,1);

        scene.setOnKeyPressed(this::add);
        scene.setOnKeyReleased(this::remove);
    }

    private void add(KeyEvent event) {
        KeyCode code = event.getCode();

        if (!keysDown.contains(code)) {
            keysDown.add(code);
            add(code);
        }
        if (code == KeyCode.ESCAPE) {
            Game.getInstance().getWindow().setMaximized(true);
            Game.getInstance().getMainHandler().handelPauseOn();
        }
    }

    private void remove(KeyEvent event) {
        KeyCode code = event.getCode();
        if (keysDown.contains(code)) {
            keysDown.remove(code);
            remove(code);
        }
    }

    public List<KeyCode> getKeysDown() {
        return keysDown;
    }

    private void add(KeyCode code) {
        Vector vector = getVector(code);

        if (vector != null) {
            mainVector.add(vector);
        }
    }

    private void remove(KeyCode code) {
        Vector vector = getVector(code);

        if (vector != null) {
            mainVector.remove(vector);
        }
    }

    private Vector getVector(KeyCode code) {
        switch (code) {
            case A:
                return new Vector(-1,0,15);
            case D:
                return new Vector(1,0,15);
            case S:
                return new Vector(0,1,15);
            case SPACE:
                return new Vector(0,-1,50);
            default:
                return null;
        }
    }

    public Vector getMainVector() {
        return mainVector;
    }
}
