package net.colorman.handler;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.List;

/**
 * Created by Paul on 26.06.2016.
 */

public class KeyboardHandler {
    private List<KeyCode> keysDown;


    public KeyboardHandler(Scene scene) {
        scene.setOnKeyPressed(this::add);
        scene.setOnKeyReleased(this::remove);
    }

    private void add(KeyEvent event) {
        KeyCode code = event.getCode();
        synchronized (keysDown) {
            if (!keysDown.contains(code))
                keysDown.add(code);
        }
    }

    private void remove(KeyEvent event) {
        synchronized (keysDown) {
            keysDown.remove(event.getCode());
        }
    }

    public List<KeyCode> getKeysDown() {
        synchronized (keysDown) {
            return keysDown;
        }
    }
}
