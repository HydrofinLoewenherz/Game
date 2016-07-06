package net.colorman.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import net.colorman.Game;
import net.colorman.threads.ActThread;

import java.awt.*;

public class MainMenu {

    /**
     * The MainGroup where all the other Nodes are placed on
     */
    private Group mainGroup;

    /**
     * The VBox where all of the buttons are placed on
     */
    private VBox vBox;

    /**
     * The Scene that represents the Menu
     */
    private Scene scene;

    /**
     * The SideMenu that will open when the Cursor is on the left side of the MainMenu
     */
    private SideMenu sideMenu;

    /**
     * The SettingsMenu to change the main keys
     */
    private SettingsMenu settingsMenu;

    /**
     * A boolean to see if the SideMenu is open
     */
    private boolean showedSideMenu;

    /**
     * The Insets for all the buttons
     */
    private final Insets defaultButtonInserts = new Insets(40, 300, 40, 300);

    public MainMenu() {
        mainGroup = new Group();
        vBox = new VBox(20);
        scene = new Scene(mainGroup);
        sideMenu = new SideMenu();
        settingsMenu = new SettingsMenu();

        scene.setOnKeyPressed(this::handelKeyPress);
        scene.setOnMouseMoved(this::handelMouseMotion);

        Button startButton = new Button("Start Game");
        startButton.setMaxWidth(Double.MAX_VALUE);
        startButton.setOnAction(event -> handelStartButtonPress());
        startButton.setPadding(defaultButtonInserts);

        Button pauseButton = new Button("Pause Game");
        pauseButton.setMaxWidth(Double.MAX_VALUE);
        pauseButton.setOnAction(event -> handelPauseButtonPress());
        pauseButton.setPadding(defaultButtonInserts);

        Button exitButton = new Button("Exit Game");
        exitButton.setMaxWidth(Double.MAX_VALUE);
        exitButton.setOnAction(event -> handelExitButtonPress());
        exitButton.setPadding(defaultButtonInserts);

        vBox.getChildren().addAll(startButton, pauseButton, exitButton);
        vBox.setAlignment(Pos.CENTER);
        vBox.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        vBox.setPadding(getVBoxInsets());

        mainGroup.getChildren().add(vBox);
    }

    /**
     * This Method handel's a press on the startButton
     *
     */
    private void handelStartButtonPress() {
        Game.getInstance().getWindow().setScene(Game.getInstance().getGameScene().getScene());
        Game.getInstance().getWindow().setFullScreen(true);
        ActThread.WORK = true;
    }

    /**
     * This Method handel's a press on the pauseButton
     *
     */
    private void handelPauseButtonPress() {
        Game.getInstance().getWindow().setIconified(true);
    }

    /**
     * This Method handel's a press on the exitButton
     *
     */
    private void handelExitButtonPress() {
        Game.getInstance().getMainHandler().handelGameEnd();
    }

    /**
     * This Method handel's the event when a key is pressed
     * When the main menu isn't on the scene, the event will be transferred to the SettingsMenu
     *
     * @param event     The KeyEvent
     */
    private void handelKeyPress(KeyEvent event) {
        if (event.getCode() == KeyCode.ESCAPE){
            if (mainGroup.getChildren().contains(vBox)) {
                Game.getInstance().getMainHandler().handelGameEnd();
            }
            else {
                sideMenu.switchMenu();
            }
        }
        else {
            settingsMenu.handelKeyPress(event);
        }
    }

    /**
     * This Method handel's the MouseMovement on this scene
     *
     * @param event     The MouseMovement
     */
    private void handelMouseMotion(MouseEvent event) {
        boolean showSideMenu = event.getSceneX() < sideMenu.getWidth();
        if (!showSideMenu && showedSideMenu) {
            mainGroup.getChildren().remove(sideMenu.get());
            showedSideMenu = false;
        }
        else if (showSideMenu && !showedSideMenu) {
            mainGroup.getChildren().add(sideMenu.get());
            showedSideMenu = true;
        }
    }

    /**
     * This Method calculates the Insets for the VBox, the box where the buttons are placed on
     *
     * @return Insets   The Insets for the VBox
     */
    private Insets getVBoxInsets() {
        return new Insets(
                ((Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2) - defaultButtonInserts.getTop() * vBox.getChildren().size()) - (vBox.getSpacing() * (vBox.getChildren().size() - 1)),
                (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2),
                ((Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2) - defaultButtonInserts.getBottom()  * vBox.getChildren().size()) - (vBox.getSpacing() * (vBox.getChildren().size() - 1)),
                (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2) - defaultButtonInserts.getLeft());
    }

    /**
     * Getter for the Scene the MainMenu is on
     *
     * @return Scene    The Scene
     */
    public Scene getScene() {
        return scene;
    }

    /**
     * Getter for the SideMenu
     *
     * @return SideMenu     The SideMenu
     */
    public SideMenu getSideMenu() {
        return sideMenu;
    }

    /**
     * Getter for the MainGroup
     *
     * @return The MainGroup
     */
    public Group getMainGroup() {
        return mainGroup;
    }

    /**
     * Getter for the SettingsMenu
     *
     * @return SettingsMenu     The SettingsMenu
     */
    public SettingsMenu getSettingsMenu() {
        return settingsMenu;
    }

    /**
     * Getter for the vBox
     *
     * @return VBox     The vBox
     */
    public VBox getvBox() {
        return vBox;
    }
}

