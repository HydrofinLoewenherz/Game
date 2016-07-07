package net.colorman.gui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import net.colorman.Game;
import net.colorman.level.Level;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LevelMenu {

    private final List<VBox> vBoxes;
    private HBox hBox;
    private final List<Level> levels = Game.getInstance().getRoundHandler().getLevels();

    /**
     * The Insets for all the buttons
     */
    private final Insets defaultButtonInserts = new Insets(10, 50, 10, 50);

    public LevelMenu() {
        vBoxes = new ArrayList<>();
        loadVBoxes();
        loadLevels();

        hBox = new HBox(30);
        //hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(getHBoxInsets());
        hBox.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        vBoxes.forEach(vBox -> hBox.getChildren().add(vBox));
    }

    private void loadVBoxes() {
        VBox vBox = new VBox(10);

        vBoxes.add(new VBox(10));
        vBoxes.add(new VBox(10));
        vBoxes.add(new VBox(10));
    }

    private void loadLevels() {
        int last = 0;

        for (Level level : levels) {
            Button levelButton = new Button(level.getName());
            levelButton.setOnAction(event -> handelButtonPress(level));
            levelButton.setMaxWidth(Double.MAX_VALUE);
            levelButton.setPadding(defaultButtonInserts);

            if (last < vBoxes.size()) {
                vBoxes.get(last).getChildren().add(levelButton);
                last++;
            }
            else {
                last = 1;
                vBoxes.get(0).getChildren().add(levelButton);
            }
        }
    }

    private void handelButtonPress(Level level) {
        Game.getInstance().getRoundHandler().handelRoundEnd();
        Game.getInstance().getRoundHandler().setupLevel(level);
    }

    /**
     * This Method calculates the Insets for the VBox
     *
     * @return Insets   calculated with the buttons and labels
     */
    private Insets getHBoxInsets() {
        return new Insets(
                (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2) - (vBoxes.size() * (vBoxes.get(0).getSpacing() + vBoxes.get(0).getHeight())),
                (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2),
                (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2) - (vBoxes.size() * (vBoxes.get(0).getSpacing() + vBoxes.get(0).getHeight())),
                (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2) - (vBoxes.size() * (defaultButtonInserts.getLeft() + hBox.getSpacing())));
    }

    public void remove() {
        Game.getInstance().getMainMenu().getMainGroup().getChildren().remove(hBox);
    }

    public HBox gethBox() {
        return hBox;
    }
}
