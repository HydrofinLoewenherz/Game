package net.colorman.misc;

import javafx.scene.input.KeyCode;
import net.colorman.enums.KeyAction;

/**
 * Created by Paul on 05.07.2016.
 */
public class Key {

    private KeyCode keyCode;
    private final KeyAction keyAction;

    public Key(KeyCode keyCode, KeyAction keyAction) {
        this.keyCode = keyCode;
        this.keyAction = keyAction;
    }

    public KeyAction getKeyAction() {
        return keyAction;
    }

    public KeyCode getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(KeyCode keyCode) {
        this.keyCode = keyCode;
    }
}
