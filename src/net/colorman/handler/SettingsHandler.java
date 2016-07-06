package net.colorman.handler;

import javafx.scene.input.KeyCode;
import net.colorman.enums.KeyAction;
import net.colorman.misc.Key;

import java.util.ArrayList;
import java.util.List;

public class SettingsHandler {

    /**
     * A List of Keys that can be changed in the SettingsMenu
     *
     */
    private List<Key> keys;

    public SettingsHandler() {
        keys = new ArrayList<>();
        loadDefaultKeys();
    }

    /**
     * This Method loads the default Keys
     *
     */
    public void loadDefaultKeys() {
        keys.clear();

        keys.add(new Key(KeyCode.SPACE, KeyAction.UP));
        keys.add(new Key(KeyCode.A, KeyAction.LEFT));
        keys.add(new Key(KeyCode.D, KeyAction.RIGHT));
        keys.add(new Key(KeyCode.S, KeyAction.DOWN));
    }

    /**
     * This Method changes the Key by an keyAction to an KeyCode
     *
     * @param action    the Key to be changed
     * @param code      the code to be changed to
     */
    public void changeKey(KeyAction action, KeyCode code) {
        getKeyByAction(action).setKeyCode(code);
    }

    /**
     * Getter to get a Key by a keyCode
     *
     * @param code      a KeyCode
     * @return          the Key using the Code
     */
    public Key getKeyByCode(KeyCode code) {
        for (Key key : keys) {
            if (key.getKeyCode() == code) {
                return key;
            }
        }

        return null;
    }

    /**
     * Getter to get a Key by a KeyAction
     *
     * @param action    a KeyAction
     * @return          the Key found
     */
    public Key getKeyByAction(KeyAction action) {
        for (Key key : keys) {
            if (key.getKeyAction() == action) {
                return key;
            }
        }

        return null;
    }
}
