package net.colorman.gui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Created by Paul on 12.06.2016.
 */
public class MainStage extends Application {

    Group mainGroup;

    @Override
    public void start(Stage window) throws Exception {
        mainGroup = new Group();
        mainGroup.getChildren().add(new Button("Hallo"));
        window.setScene(new Scene(mainGroup));
        window.show();
    }
}
