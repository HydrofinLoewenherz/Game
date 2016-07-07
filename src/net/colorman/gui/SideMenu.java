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

public class SideMenu {

    /**
     * The MainGroup all other Nodes are located on
     */
    private Group mainGroup;

    /**
     * The VBox the Buttons are placed on
     */
    private VBox vBox;

    /**
     * The width calculated from the left side of the Scene as a indicator when to show this Menu
     */
    private final int width = 300;

    /**
     * The Insets for the Buttons
     */
    private Insets defaultInsets = new Insets(10, 100, 10, 100);

    public SideMenu() {

        mainGroup = new Group();
        vBox = new VBox(20);

        Button homeButton = new Button("Home");
        homeButton.setMaxWidth(Double.MAX_VALUE);
        homeButton.setOnAction(event -> handelHomeButtonPress());
        homeButton.setPadding(defaultInsets);

        Button settingsButton = new Button("Settings");
        settingsButton.setMaxWidth(Double.MAX_VALUE);
        settingsButton.setOnAction(event -> handelSettingsButtonPress());
        settingsButton.setPadding(defaultInsets);

        Button levelsButton = new Button("Levels");
        levelsButton.setMaxWidth(Double.MAX_VALUE);
        levelsButton.setOnAction(event -> handelLevelsButtonPress());
        levelsButton.setPadding(defaultInsets);

        vBox.getChildren().addAll(homeButton, levelsButton, settingsButton);
        vBox.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        vBox.setPadding(getVBoxInsets());
        vBox.setAlignment(Pos.CENTER);

        mainGroup.getChildren().add(vBox);
    }

    /**
     * This Method handel's a press on the homeButton
     *
     */
    private void handelHomeButtonPress() {
        Game.getInstance().getMainMenu().getMainGroup().getChildren().remove(mainGroup);
        if (!Game.getInstance().getMainMenu().getMainGroup().getChildren().contains(Game.getInstance().getMainMenu().getvBox())) {
            switchMenu(1);
            Game.getInstance().getWindow().setFullScreen(true);
        }
    }

    /**
     * This Method handel's a press on the levelsButton
     *
     */
    private void handelLevelsButtonPress() {
        if (!Game.getInstance().getMainMenu().getMainGroup().getChildren().contains(Game.getInstance().getMainMenu().getLevelMenu().gethBox())) {
            switchMenu(2);
            Game.getInstance().getWindow().setFullScreen(true);
        }
    }

    /**
     * This Method handel's a press on the settingsButton
     *
     */
    private void handelSettingsButtonPress() {
        if (!Game.getInstance().getMainMenu().getMainGroup().getChildren().contains(Game.getInstance().getMainMenu().getSettingsMenu().getVBox())) {
            switchMenu(3);
            Game.getInstance().getWindow().setFullScreen(true);
        }
    }

    /**
     * This Method switches the Main and SideMenu between another
     *
     */
    public void switchMenu(int menu) {
        removeGUIfromMain();

        if (menu == 1) {
            Game.getInstance().getMainMenu().getMainGroup().getChildren().add(Game.getInstance().getMainMenu().getvBox());
        }
        else if (menu == 2) {
            Game.getInstance().getMainMenu().getMainGroup().getChildren().add(Game.getInstance().getMainMenu().getLevelMenu().gethBox());
        }
        else if (menu == 3) {
            Game.getInstance().getMainMenu().getMainGroup().getChildren().add(Game.getInstance().getMainMenu().getSettingsMenu().getVBox());
        }

        if (!Game.getInstance().getWindow().isFullScreen()) {
            Game.getInstance().getWindow().setFullScreen(true);
        }
    }

    private void removeGUIfromMain() {
        Game.getInstance().getMainMenu().remove();
        Game.getInstance().getMainMenu().getSettingsMenu().remove();
        Game.getInstance().getMainMenu().getLevelMenu().remove();
    }

    /**
     * This Method returns the calculated Insets for the vBox
     *
     * @return Insets   Insets for the vBox
     */
    private Insets getVBoxInsets() {
        return new Insets(((Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2) - defaultInsets.getTop() * vBox.getChildren().size()) - (vBox.getSpacing() * (vBox.getChildren().size() - 1)),
                (width / 2) - defaultInsets.getRight(),
                ((Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2) - defaultInsets.getBottom()  * vBox.getChildren().size()) - (vBox.getSpacing() * (vBox.getChildren().size() - 1)),
                (width / 2) - defaultInsets.getLeft());
    }

    /**
     * Getter for the mainGroup all of the Nodes are located on
     *
     * @return Group    the mainGroup
     */
    public Group get() {
        return mainGroup;
    }

    /**
     * Getter for the Width of this Menu
     *
     * @return double   the width
     */
    public double getWidth() {
        return width;
    }
}
