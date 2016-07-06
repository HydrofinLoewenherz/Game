package net.colorman.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import net.colorman.Game;
import net.colorman.enums.KeyAction;
import net.colorman.misc.Key;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul on 05.07.2016.
 */
public class SettingsMenu {

    private Group mainGroup;
    VBox vBox;
    private KeyBox keyBox;
    List<KeyBox> keyBoxes;
    private final Insets defaultButtonInsets = new Insets(40,150,40,150);

    public SettingsMenu() {
        mainGroup = new Group();
        vBox = new VBox(20);
        keyBoxes = new ArrayList<>();
        mainGroup.getChildren().add(vBox);

        loadKeyBoxes();

        vBox.setAlignment(Pos.CENTER);


        vBox.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        vBox.setPadding(new Insets(
                ((Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2) - defaultButtonInsets.getTop() * vBox.getChildren().size()) - (vBox.getSpacing() * (vBox.getChildren().size() - 1)),
                (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2),
                ((Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2) - defaultButtonInsets.getBottom()  * vBox.getChildren().size()) - (vBox.getSpacing() * (vBox.getChildren().size() - 1)),
                (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2) - keyBoxes.get(0).getBox().getPadding().getLeft() - defaultButtonInsets.getLeft() * 2)
        );
    }

    private void loadKeyBoxes() {
        KeyAction[] keyActions = {KeyAction.UP, KeyAction.DOWN, KeyAction.LEFT, KeyAction.RIGHT};
        for (KeyAction keyAction : keyActions) {
            keyBoxes.add(new KeyBox(keyAction, Game.getInstance().getSettingsHandler().getKeyByAction(keyAction).getKeyCode()));
        }
        keyBoxes.forEach(keyBox -> {
            vBox.getChildren().add(keyBox.getBox());
            keyBox.getBox().setMinWidth(Double.MIN_VALUE);
        });
    }

    protected void handelKeyPress(KeyEvent event) {
        if (event.getCode() == KeyCode.ESCAPE) {
            Game.getInstance().getWindow().setScene(Game.getInstance().getMainMenu().getScene());
            Game.getInstance().getWindow().setFullScreen(true);
        }
        else if (keyBox != null) {
            Key key = Game.getInstance().getSettingsHandler().getKeyByAction(keyBox.getKeyAction());
            if (key != null) {
                Game.getInstance().getSettingsHandler().getKeyByAction(keyBox.getKeyAction()).setKeyCode(event.getCode());
                keyBox.getButton().setText(key.getKeyCode().getName());
            }
            keyBox = null;

            Game.getInstance().getGameScene().getKeyboardHandler().loadKeys();
        }
    }

    public void setKeyBox(KeyBox keyBox) {
        keyBox.getButton().setText("Press a Key");
        this.keyBox = keyBox;
    }

    public KeyBox getKeyBox() {
        return keyBox;
    }

    public VBox getvBox() {
        return vBox;
    }

    public class KeyBox {

        private KeyAction keyAction;
        private HBox hBox;
        private Button button;
        private Label label;

        public KeyBox(KeyAction action, KeyCode code) {
            keyAction = action;

            label = new Label(action.getName(action));
            label.setStyle("-fx-border-width: 2px; -fx-border-color: #2e8b57");
            label.setPadding(defaultButtonInsets);
            button = new Button(code.getName());
            button.setPadding(defaultButtonInsets);
            button.setOnAction(event -> {
                if (getKeyBox() == null) {
                    setKeyBox(this);
                }
            });

            hBox = new HBox(10);
            hBox.setAlignment(Pos.CENTER);
            hBox.setMaxWidth(Double.MAX_VALUE);

            hBox.getChildren().addAll(label, button);
        }

        public KeyAction getKeyAction() {
            return keyAction;
        }

        public HBox getBox() {
            return hBox;
        }

        public Button getButton() {
            return button;
        }

        public Label getLabel() {
            return label;
        }
    }
}
