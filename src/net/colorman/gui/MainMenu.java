package net.colorman.gui;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import net.colorman.Game;
import javafx.scene.input.MouseEvent;

/**
 * Created by Paul on 12.06.2016.
 */
public class MainMenu {

    private Group mainGroup;
    private Scene scene;
    private Button startButton, stopButton;
    private boolean showSideMeun;

    public MainMenu() {
        mainGroup = new Group();
        scene = new Scene(mainGroup);

        stopButton = new Button("Exit Game");
        stopButton.setOnAction(event -> Game.getInstance().getMainHandler().handelGameEnd());
        mainGroup.getChildren().add(stopButton);


        scene.setOnMouseMoved(this::handelMouseMotion);
    }

    private void handelMouseMotion(MouseEvent event) {
        showSideMeun = event.getSceneX() < scene.getWidth() / 10;
    }

    //--Getter---

    public Scene getScene() {
        return scene;
    }
}
