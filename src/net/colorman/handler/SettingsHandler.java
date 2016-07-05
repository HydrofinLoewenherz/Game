package net.colorman.handler;

import javafx.scene.input.KeyCode;
import net.colorman.enums.KeyAction;
import net.colorman.misc.Key;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul on 05.07.2016.
 */
public class SettingsHandler {

       List<Key> keys;

    public SettingsHandler() {
        keys = new ArrayList<>();
        loadDefaultKeys();
    }

    public void loadDefaultKeys() {
        keys.clear();

        keys.add(new Key(KeyCode.SPACE, KeyAction.UP));
        keys.add(new Key(KeyCode.A, KeyAction.LEFT));
        keys.add(new Key(KeyCode.D, KeyAction.RIGHT));
        keys.add(new Key(KeyCode.S, KeyAction.DOWN));
    }

    public void changeKey(KeyAction action, KeyCode code) {
        getKeyByAction(action).setKeyCode(code);
    }

    public Key getKeyByCode(KeyCode code) {
        for (Key key : keys) {
            if (key.getKeyCode() == code) {
                return key;
            }
        }

        return null;
    }

    public Key getKeyByAction(KeyAction action) {
        for (Key key : keys) {
            if (key.getKeyAction() == action) {
                return key;
            }
        }

        return null;
    }
}
