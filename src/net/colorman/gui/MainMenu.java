package net.colorman.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import net.colorman.Game;
import net.colorman.threads.ActThread;

import java.awt.*;

/**
 * Created by Paul on 12.06.2016.
 */

public class MainMenu {

    private Group mainGroup;
    private VBox vBox;
    private Scene scene;
    private Button startButton, exitButton, pauseButton;
    private boolean showSideMenu, showedSideMenu;
    private SideMenu sideMenu;
    private SettingsMenu settingsMenu;

    private final Insets defaultButtonInserts = new Insets(40,300,40,300);

    public MainMenu() {
        mainGroup = new Group();
        vBox = new VBox(20);
        scene = new Scene(mainGroup);
        sideMenu = new SideMenu();
        settingsMenu = new SettingsMenu();

        scene.setOnKeyPressed(event -> {
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
        });
        scene.setOnMouseMoved(this::handelMouseMotion);

        startButton = new Button("Start Game");
        startButton.setMaxWidth(Double.MAX_VALUE);
        startButton.setOnAction(event -> {
            Game.getInstance().getWindow().setScene(Game.getInstance().getGameScene().getScene());
            Game.getInstance().getWindow().setFullScreen(true);
            ActThread.WORK = true;
        });
        startButton.setPadding(defaultButtonInserts);

        pauseButton = new Button("Pause Game");
        pauseButton.setMaxWidth(Double.MAX_VALUE);
        pauseButton.setOnAction(event -> Game.getInstance().getWindow().setIconified(true));
        pauseButton.setPadding(defaultButtonInserts);

        exitButton = new Button("Exit Game");
        exitButton.setMaxWidth(Double.MAX_VALUE);
        exitButton.setOnAction(event -> Game.getInstance().getMainHandler().handelGameEnd());
        exitButton.setPadding(defaultButtonInserts);

        vBox.getChildren().addAll(startButton, pauseButton, exitButton);
        vBox.setAlignment(Pos.CENTER);
        vBox.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        vBox.setPadding(new Insets(
                ((Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2) - defaultButtonInserts.getTop() * vBox.getChildren().size()) - (vBox.getSpacing() * (vBox.getChildren().size() - 1)),
                (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2),
                ((Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2) - defaultButtonInserts.getBottom()  * vBox.getChildren().size()) - (vBox.getSpacing() * (vBox.getChildren().size() - 1)),
                (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2) - defaultButtonInserts.getLeft())
        );

        mainGroup.getChildren().add(vBox);
    }

    public void handelMouseMotion(MouseEvent event) {
        showSideMenu = event.getSceneX() < sideMenu.getWidth();
        if (!showSideMenu && showedSideMenu) {
            mainGroup.getChildren().remove(sideMenu.get());
            showedSideMenu = false;
        }
        else if (showSideMenu && !showedSideMenu) {
            mainGroup.getChildren().add(sideMenu.get());
            showedSideMenu = true;
        }
    }

    //--Getter---

    public Scene getScene() {
        return scene;
    }

    public SideMenu getSideMenu() {
        return sideMenu;
    }

    public Group getMainGroup() {
        return mainGroup;
    }

    public SettingsMenu getSettingsMenu() {
        return settingsMenu;
    }

    public VBox getvBox() {
        return vBox;
    }
}

