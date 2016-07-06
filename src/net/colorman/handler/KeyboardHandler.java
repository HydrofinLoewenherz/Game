package net.colorman.handler;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import net.colorman.Game;
import net.colorman.enums.KeyAction;
import net.colorman.misc.Vector;

import java.util.ArrayList;
import java.util.List;

public class KeyboardHandler {

    /**
     * A List of all the pressed Keys
     */
    List<KeyCode> keysDown;

    /**
     * The main Vector created by the directionKeys pressed (no gravityVector implemented)
     */
    Vector mainVector;

    /**
     * The KeyCodes for the directionKeys
     */
    KeyCode Up, Down, Left, Right;

    public KeyboardHandler(Scene scene) {
        keysDown = new ArrayList<>();
        mainVector = new Vector(0,0,1);

        scene.setOnKeyPressed(this::add);
        scene.setOnKeyReleased(this::remove);

        loadKeys();
    }

    /**
     * This Method triggers when a Key is pressed
     * The Method adds the pressed Key to the pressed Keys
     *
     * @see #keysDown
     *
     * @param event     The KeyEvent
     */
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

    /**
     * This Method triggers when a key is released
     * The Method removes the KeyCode from the Keys pressed
     *
     * @see #keysDown
     *
     * @param event     The KeyEvent
     */
    private void remove(KeyEvent event) {
        KeyCode code = event.getCode();
        if (keysDown.contains(code)) {
            keysDown.remove(code);
            remove(code);
        }
    }

    /**
     * This Method adds a direction Vector to the mainVector
     * specific to the KeyCode
     *
     * @see #getVector(KeyCode)
     *
     * @param code  The keyCode
     */
    private void add(KeyCode code) {
        Vector vector = getVector(code);

        if (vector != null) {
            mainVector.add(vector);
        }
    }

    /**
     * This Method removes a Vector from the mainVector
     * specific to the KeyCode
     *
     * @see #getVector(KeyCode)
     *
     * @param code  The keyCode
     */
    private void remove(KeyCode code) {
        Vector vector = getVector(code);

        if (vector != null) {
            mainVector.remove(vector);
        }
    }

    /**
     * This Method returns a Vector created from a KeyCode
     * The Method tests capability to one of the directionKeys
     *
     * @param code  The keyCode
     * @return
     */
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

    /**
     * This Method loads the directionKeys from the SettingsHandler
     *
     * @see SettingsHandler
     */
    public void loadKeys() {
        Up = Game.getInstance().getSettingsHandler().getKeyByAction(KeyAction.UP).getKeyCode();
        Down = Game.getInstance().getSettingsHandler().getKeyByAction(KeyAction.DOWN).getKeyCode();
        Left = Game.getInstance().getSettingsHandler().getKeyByAction(KeyAction.LEFT).getKeyCode();
        Right = Game.getInstance().getSettingsHandler().getKeyByAction(KeyAction.RIGHT).getKeyCode();
    }

    /**
     * Getter for the List of keysDown
     *
     * @return List</KeyCode>   The keys pressed
     */
    public List<KeyCode> getKeysDown() {
        return keysDown;
    }

    /**
     * Getter for the mainVector
     *
     * @return Vector   the mainVector
     */
    public Vector getMainVector() {
        return mainVector;
    }
}
