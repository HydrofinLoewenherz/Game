package net.colorman.handler;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import net.colorman.Game;
import net.colorman.enums.KeyAction;
import net.colorman.misc.Vector;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul on 26.06.2016.
 */

public class KeyboardHandler {
    List<KeyCode> keysDown;
    Vector mainVector;
    KeyCode Up, Down, Left, Right;

    public KeyboardHandler(Scene scene) {
        keysDown = new ArrayList<>();
        mainVector = new Vector(0,0,1);

        scene.setOnKeyPressed(this::add);
        scene.setOnKeyReleased(this::remove);

        loadKeys();
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
        if (code == Left)
            return new Vector(-1,0,15);
        else if (code == Right)
            return new Vector(1,0,15);
        else if (code == Down)
            return new Vector(0,1,15);
        else if (code == Up)
            return new Vector(0,-1,50);
        else
            return null;
    }

    public void loadKeys() {
        Up = Game.getInstance().getSettingsHandler().getKeyByAction(KeyAction.UP).getKeyCode();
        Down = Game.getInstance().getSettingsHandler().getKeyByAction(KeyAction.DOWN).getKeyCode();
        Left = Game.getInstance().getSettingsHandler().getKeyByAction(KeyAction.LEFT).getKeyCode();
        Right = Game.getInstance().getSettingsHandler().getKeyByAction(KeyAction.RIGHT).getKeyCode();
    }

    public Vector getMainVector() {
        return mainVector;
    }
}
