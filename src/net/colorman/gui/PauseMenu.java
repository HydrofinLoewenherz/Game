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

/**
 * Created by Paul on 26.06.2016.
 */
public class PauseMenu {

    private VBox vBox;
    private Button menuButton, continueButton;
    private final Insets defaultButtonInsets = new Insets(20, 150, 20, 150);
    private final double width = 500;
    private final double height = 700;

    public PauseMenu() {
        vBox = new VBox(20);

        continueButton = new Button("Continue");
        continueButton.setPadding(defaultButtonInsets);
        continueButton.setOnAction(event -> Game.getInstance().getMainHandler().handelPauseOff());
        menuButton = new Button("   Menu  ");
        menuButton.setPadding(defaultButtonInsets);
        menuButton.setOnAction(event -> {
            Game.getInstance().getWindow().setScene(Game.getInstance().getMainMenu().getScene());
            Game.getInstance().getMainHandler().handelPauseOff();
        });

        vBox.setPadding(new Insets(
                ((height / 2) - defaultButtonInsets.getTop() * vBox.getChildren().size()) - (vBox.getSpacing() * (vBox.getChildren().size() - 1)),
                (width / 2) - defaultButtonInsets.getRight(),
                ((height / 2) - defaultButtonInsets.getBottom() * vBox.getChildren().size()) - (vBox.getSpacing() * (vBox.getChildren().size() - 1)),
                (width / 2) - defaultButtonInsets.getLeft())
        );
        vBox.setAlignment(Pos.CENTER);
        vBox.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        vBox.setTranslateX((Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2) - (vBox.getPadding().getLeft() + menuButton.getPadding().getLeft()));

        vBox.getChildren().addAll(continueButton, menuButton);
    }

    public VBox get() {
        return vBox;
    }
}
