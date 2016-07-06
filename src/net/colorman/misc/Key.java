package net.colorman.misc;

import javafx.scene.input.KeyCode;
import net.colorman.enums.KeyAction;

public class Key {

    /**
     * The specific KeyCode of this Key
     */
    private KeyCode keyCode;

    /**
     * The KeyAction related to the KeyCode
     */
    private final KeyAction keyAction;

    public Key(KeyCode keyCode, KeyAction keyAction) {
        this.keyCode = keyCode;
        this.keyAction = keyAction;
    }

    /**
     * A Getter for the KeyAction
     *
     * @return KeyAction
     */
    public KeyAction getKeyAction() {
        return keyAction;
    }

    /**
     * A Getter for the KeyCode
     *
     * @return KeyCode
     */
    public KeyCode getKeyCode() {
        return keyCode;
    }

    /**
     * A Setter of the KeyCode
     *
     * @param keyCode   a KeyCode
     */
    public void setKeyCode(KeyCode keyCode) {
        this.keyCode = keyCode;
    }
}
