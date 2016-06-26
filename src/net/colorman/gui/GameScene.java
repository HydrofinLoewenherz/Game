package net.colorman.gui;

import javafx.scene.Group;
import javafx.scene.Scene;
import net.colorman.handler.KeyboardHandler;

/**
 * Created by Paul on 13.06.2016.
 */
public class GameScene {

    private Scene scene;
    private Group mainGroup;
    private KeyboardHandler keyboardHandler;
    private PauseMenu pauseMenu;
    public boolean pause = false;

    public GameScene() {
        mainGroup = new Group();
        scene = new Scene(mainGroup);
        keyboardHandler = new KeyboardHandler(scene);
        pauseMenu = new PauseMenu();
    }

    //--Getter--

    public Scene getScene() {
        return scene;
    }

    public Group getMainGroup() {
        return mainGroup;
    }

    public KeyboardHandler getKeyboardHandler() {
        return keyboardHandler;
    }

    public PauseMenu getPauseMenu() {
        return pauseMenu;
    }
}
