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

public class SettingsMenu {

    /**
     * The VBox for the buttons
     */
    private VBox vBox;

    /**
     * A temp value for the clicked keyBox
     */
    private KeyBox keyBox;

    /**
     * A List of all the KeyBoxes on the vBox
     */
    private List<KeyBox> keyBoxes;

    /**
     * the Insets for all the Buttons and Labels
     */
    private final Insets defaultButtonInsets = new Insets(40,150,40,150);


    public SettingsMenu() {
        Group mainGroup = new Group();
        vBox = new VBox(20);
        keyBoxes = new ArrayList<>();
        mainGroup.getChildren().add(vBox);

        loadKeyBoxes();

        vBox.setAlignment(Pos.CENTER);


        vBox.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        vBox.setPadding(getVBoxInsets());
    }

    /**
     * This Method creates the KeyBoxes at the Game Start
     *
     */
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

    /**
     * This Method handel's the press of a Key
     *
     * @param event
     */
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

    /**
     * This Method saves the KeyBox last clicked on
     *
     * @param keyBox
     */
    public void setKeyBox(KeyBox keyBox) {
        keyBox.getButton().setText("Press a Key");
        this.keyBox = keyBox;
    }

    /**
     * This Method calculates the Insets for the VBox
     *
     * @return Insets   calculated with the buttons and labels
     */
    private Insets getVBoxInsets() {
        return new Insets(
                ((Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2) - defaultButtonInsets.getTop() * vBox.getChildren().size()) - (vBox.getSpacing() * (vBox.getChildren().size() - 1)),
                (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2),
                ((Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2) - defaultButtonInsets.getBottom()  * vBox.getChildren().size()) - (vBox.getSpacing() * (vBox.getChildren().size() - 1)),
                (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2) - keyBoxes.get(0).getBox().getPadding().getLeft() - defaultButtonInsets.getLeft() * 2);
    }

    /**
     * Getter for the last clicked on KeyBox
     *
     * @return KeyBox   the last clicked on KeyBox
     */
    public KeyBox getKeyBox() {
        return keyBox;
    }

    /**
     * Getter for the vBox the KeyBoxes are on
     *
     * @return VBox     the vBox with the KeyBoxes
     */
    public VBox getVBox() {
        return vBox;
    }

    /**
     * The KeyBox Class contains a vBox with one Label and one Button
     * also it implements a keyAction connected to it
     *
     */
    public class KeyBox {

        /**
         * The KeyAction this KeyBox handel's
         */
        private KeyAction keyAction;

        /**
         * The HBox the button and the label is on
         */
        private HBox hBox;

        /**
         * The Button
         * the Text is the KeyCode
         */
        private Button button;

        /**
         * The Label
         * the Text is the name of the KeyAction
         */
        private Label label;

        public KeyBox(KeyAction action, KeyCode code) {
            keyAction = action;

            label = new Label(action.getName(action));
            label.setStyle("-fx-border-width: 2px; -fx-border-color: #2e8b57");
            label.setPadding(defaultButtonInsets);

            button = new Button(code.getName());
            button.setPadding(defaultButtonInsets);
            button.setOnAction(event -> handelButtonPress());

            hBox = new HBox(10);
            hBox.setAlignment(Pos.CENTER);
            hBox.setMaxWidth(Double.MAX_VALUE);

            hBox.getChildren().addAll(label, button);
        }

        /**
         * This Method handel's the press on the Button
         */
        private void handelButtonPress() {
            if (getKeyBox() == null) {
                setKeyBox(this);
            }
        }

        /**
         * Getter for the keyAction this KeyBox handels
         *
         * @return KeyAction    The keyAction of this KeyBox
         */
        public KeyAction getKeyAction() {
            return keyAction;
        }

        /**
         * Getter for the HBox that contains both the Button and the Label
         *
         * @return HBox     the HBox of this KeyBox
         */
        public HBox getBox() {
            return hBox;
        }

        /**
         * Getter for the Button in this KeyBox
         *
         * @return Button   the Button
         */
        public Button getButton() {
            return button;
        }

        /**
         * Getter for the Label in this KeyBox
         *
         * @return Label    the Label
         */
        public Label getLabel() {
            return label;
        }
    }
}
