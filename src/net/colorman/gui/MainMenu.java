package net.colorman.gui;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import net.colorman.Game;

/**
 * Created by Paul on 12.06.2016.
 */
public class MainMenu {

    private Group mainGroup;
    private Scene scene;
    private Button startButton, stopButton;

    public MainMenu() {
        mainGroup = new Group();
        scene = new Scene(mainGroup);

        stopButton = new Button("Exit Game");
        stopButton.setOnAction(event -> Game.getInstance().getMainHandler().handelGameEnd());
        mainGroup.getChildren().add(stopButton);
    }

    //--Getter---

    public Scene getScene() {
        return scene;
    }
}
