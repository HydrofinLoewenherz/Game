package net.colorman.gui;

import javafx.scene.Group;
import javafx.scene.Scene;

/**
 * Created by Paul on 13.06.2016.
 */
public class GameScene {

    private Scene scene;
    private Group mainGroup;

    public GameScene() {
        mainGroup = new Group();
        scene = new Scene(mainGroup);
    }

    //--Getter--

    public Scene getScene() {
        return scene;
    }

    public Group getMainGroup() {
        return mainGroup;
    }
}
