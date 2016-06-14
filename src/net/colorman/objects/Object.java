package net.colorman.objects;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import net.colorman.Game;

/**
 * Created by Paul on 13.06.2016.
 */

public class Object extends ImageView {

    private Image defaultImage;
    private Image[] imageList;

    public Object(Image defaultImage, Image[] imageList) {
        super(defaultImage);
        this.defaultImage = defaultImage;
        this.imageList = imageList;

        add();
    }

    private void add() {
        try {
            Platform.runLater(() -> Game.getInstance().getGameScene().getMainGroup().getChildren().add(this));
            Game.getInstance().getObjectHandler().addToTemp(this);
        } catch (Exception e) {
            Game.getInstance().getExceptionHandler().addException("Object " + this, e.toString());
        }
    }

    private void remove() {
        try {
            Platform.runLater(() -> Game.getInstance().getGameScene().getMainGroup().getChildren().remove(this));
            Game.getInstance().getObjectHandler().removeFromTemp(this);
        } catch (Exception e) {
            Game.getInstance().getExceptionHandler().addException("Object " + this, e.toString());
        }
    }

    public void setLocation(double x, double y) {
        setTranslateX(x);
        setTranslateY(y);
    }
}
