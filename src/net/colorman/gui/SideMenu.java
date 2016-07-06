package net.colorman.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import net.colorman.Game;

import java.awt.*;

/**
 * Created by Paul on 14.06.2016.
 */
public class SideMenu {

    private Group mainGroup;
    private Button homeButton, settingsButton;
    private final Insets defaultInsets = new Insets(10, 100, 10 ,100);
    private final int width = 300;

    public SideMenu() {

        mainGroup = new Group();
        VBox vBox = new VBox(20);

        homeButton = new Button("Home");
        homeButton.setMaxWidth(Double.MAX_VALUE);
        homeButton.setOnAction(event -> {
            Game.getInstance().getMainMenu().getMainGroup().getChildren().remove(mainGroup);
            if (!Game.getInstance().getMainMenu().getMainGroup().getChildren().contains(Game.getInstance().getMainMenu().getvBox())) {
                switchMenu();
                Game.getInstance().getWindow().setFullScreen(true);
            }
        });
        homeButton.setPadding(defaultInsets);
        settingsButton = new Button("Settings");
        settingsButton.setMaxWidth(Double.MAX_VALUE);
        settingsButton.setOnAction(event -> {
            if (Game.getInstance().getMainMenu().getMainGroup().getChildren().contains(Game.getInstance().getMainMenu().getvBox())) {
                switchMenu();
                Game.getInstance().getWindow().setFullScreen(true);
            }
        });
        settingsButton.setPadding(defaultInsets);

        vBox.getChildren().addAll(homeButton, settingsButton);

        vBox.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        vBox.setPadding(new Insets(
            ((Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2) - defaultInsets.getTop() * vBox.getChildren().size()) - (vBox.getSpacing() * (vBox.getChildren().size() - 1)),
            (width / 2) - defaultInsets.getRight(),
            ((Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2) - defaultInsets.getBottom()  * vBox.getChildren().size()) - (vBox.getSpacing() * (vBox.getChildren().size() - 1)),
            (width / 2) - defaultInsets.getLeft())
        );
        vBox.setAlignment(Pos.CENTER);

        mainGroup.getChildren().add(vBox);
    }

    public void switchMenu() {
        if (Game.getInstance().getMainMenu().getMainGroup().getChildren().contains(Game.getInstance().getMainMenu().getvBox())) {
            Game.getInstance().getMainMenu().getMainGroup().getChildren().remove(Game.getInstance().getMainMenu().getvBox());
            Game.getInstance().getMainMenu().getMainGroup().getChildren().add(Game.getInstance().getMainMenu().getSettingsMenu().getvBox());
        }
        else {
            Game.getInstance().getMainMenu().getMainGroup().getChildren().add(Game.getInstance().getMainMenu().getvBox());
            Game.getInstance().getMainMenu().getMainGroup().getChildren().remove(Game.getInstance().getMainMenu().getSettingsMenu().getvBox());
        }

        Game.getInstance().getWindow().setFullScreen(true);
    }

    public Group get() {
        return mainGroup;
    }

    public double getWidth() {
        return width;
    }
}
