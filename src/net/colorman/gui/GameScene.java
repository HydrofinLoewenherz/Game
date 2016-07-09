package net.colorman.gui;

import javafx.scene.Group;
import javafx.scene.Scene;
import net.colorman.handler.CommandHandler;
import net.colorman.handler.KeyboardHandler;

public class GameScene {

    /**
     * The Scene the InGame is on
     */
    private Scene scene;

    /**
     * The MainGroup all the other Nodes are on
     */
    private Group mainGroup;

    /**
     * The KeyboardHandler
     */
    private KeyboardHandler keyboardHandler;
    private CommandHandler commandHandler;

    /**
     * The PauseMenu
     */
    private PauseMenu pauseMenu;

    /**
     * A Boolean to see if the Game is paused
     */
    public boolean pause = false;

    public GameScene() {
        mainGroup = new Group();
        scene = new Scene(mainGroup);
        keyboardHandler = new KeyboardHandler(scene);
        commandHandler = new CommandHandler(scene);
        pauseMenu = new PauseMenu();
    }

    /**
     * A Getter for the Scene
     *
     * @return Scene
     */
    public Scene getScene() {
        return scene;
    }

    /**
     * A Getter for the MainGroup
     *
     * @return Group
     */
    public Group getMainGroup() {
        return mainGroup;
    }

    /**
     * A Getter for the KeyboardHandler
     *
     * @return KeyboardHandler
     */
    public KeyboardHandler getKeyboardHandler() {
        return keyboardHandler;
    }

    public CommandHandler getCommandHandler() {
        return commandHandler;
    }

    /**
     * A Getter for the PauseMenu
     *
     * @return PauseMenu
     */
    public PauseMenu getPauseMenu() {
        return pauseMenu;
    }
}
