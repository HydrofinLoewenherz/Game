package net.colorman.handler;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import net.colorman.Game;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul on 26.06.2016.
 */

public class KeyboardHandler {
    private List<KeyCode> keysDown;


    public KeyboardHandler(Scene scene) {
        keysDown = new ArrayList<>();
        scene.setOnKeyPressed(this::add);
        scene.setOnKeyReleased(this::remove);
    }

    private void add(KeyEvent event) {
        KeyCode code = event.getCode();
        synchronized (keysDown) {
            if (!keysDown.contains(code))
                keysDown.add(code);
        }
        react();
    }

    private void remove(KeyEvent event) {
        synchronized (keysDown) {
            keysDown.remove(event.getCode());
        }
        react();
    }

    public List<KeyCode> getKeysDown() {
        synchronized (keysDown) {
            return keysDown;
        }
    }

    private void react() {
        if (keysDown.contains(KeyCode.ESCAPE)) {
            Game.getInstance().getMainHandler().handelPauseOn();
        }
    }
}
