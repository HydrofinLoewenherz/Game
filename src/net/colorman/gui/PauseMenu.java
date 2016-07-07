package net.colorman.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import net.colorman.Game;

import java.awt.*;

public class PauseMenu {

    /**
     * The VBox the Buttons are placed on
     */
    private VBox vBox;

    /**
     * The Insets for all of the Buttons
     */
    private final Insets defaultButtonInsets = new Insets(20, 150, 20, 150);

    /**
     * The Width of the Menu
     */
    private final double width = 500;

    /**
     * The Height of the Menu
     */
    private final double height = 700;

    public PauseMenu() {
        vBox = new VBox(20);

        Button continueButton = new Button("Continue");
        continueButton.setMaxWidth(Double.MAX_VALUE);
        continueButton.setPadding(defaultButtonInsets);
        continueButton.setOnAction(event -> handelContinueButtonPress());

        Button reloadButton = new Button("Reload");
        reloadButton.setMaxWidth(Double.MAX_VALUE);
        reloadButton.setPadding(defaultButtonInsets);
        reloadButton.setOnAction(event -> handelReloadButtonPress());

        Button menuButton = new Button("Menu");
        menuButton.setMaxWidth(Double.MAX_VALUE);
        menuButton.setPadding(defaultButtonInsets);
        menuButton.setOnAction(event -> handelMenuButtonPress());

        vBox.setPadding(getVBoxInsets());
        vBox.setAlignment(Pos.CENTER);
        vBox.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        vBox.setTranslateX((Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2) - (vBox.getPadding().getLeft() + menuButton.getPadding().getLeft()));

        vBox.getChildren().addAll(continueButton, reloadButton, menuButton);
    }

    /**
     * This Method handel's the press on the ContinueButton
     *
     */
    private void handelContinueButtonPress() {
        Game.getInstance().getMainHandler().handelPauseOff();
    }

    /**
     * This Method handel's the press on the ReloadButton
     *
     */
    private void handelReloadButtonPress() {
        Game.getInstance().getRoundHandler().handelRoundEnd();
        Game.getInstance().getRoundHandler().setupLevel(Game.getInstance().getRoundHandler().getPlayingLevel());
        Game.getInstance().getMainHandler().handelPauseOff();
    }

    /**
     * This Method handel's the press on teh MenuButton
     *
     */
    private void handelMenuButtonPress() {
        Game.getInstance().getWindow().setScene(Game.getInstance().getMainMenu().getScene());
        Game.getInstance().getMainHandler().handelPauseOff();
    }

    /**
     * This Method is a Getter for the calculated VBox Insets
     *
     * @return Insets
     */
    public Insets getVBoxInsets() {
        return new Insets(
                ((height / 2) - defaultButtonInsets.getTop() * vBox.getChildren().size()) - (vBox.getSpacing() * (vBox.getChildren().size() - 1)),
                (width / 2) - defaultButtonInsets.getRight(),
                ((height / 2) - defaultButtonInsets.getBottom() * vBox.getChildren().size()) - (vBox.getSpacing() * (vBox.getChildren().size() - 1)),
                (width / 2) - defaultButtonInsets.getLeft());
    }

    public VBox get() {
        return vBox;
    }
}
