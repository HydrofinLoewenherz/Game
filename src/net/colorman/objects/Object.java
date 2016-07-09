package net.colorman.objects;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import net.colorman.Game;
import net.colorman.misc.Vector;

public class Object extends ImageView {

    /**
     * The deafult Image of the Object
     */
    private Image defaultImage;

    /**
     * A Image Array for animations
     */
    private Image[] imageList;

    /**
     * A Gravity Vector for gravity
     */
    public final Vector gravity = new Vector(0,1,15);

    public Object(Image defaultImage, Image[] imageList) {
        super(defaultImage);
        this.defaultImage = defaultImage;
        this.imageList = imageList;

        add();
    }

    /**
     * This Method adds the Object into the Game
     *
     */
    private void add() {
        try {
            Platform.runLater(() -> Game.getInstance().getGameScene().getMainGroup().getChildren().add(this));
            Game.getInstance().getObjectHandler().addToTemp(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This Method removes the Object from the Game
     *
     */
    public void remove() {
        try {
            Platform.runLater(() -> Game.getInstance().getGameScene().getMainGroup().getChildren().remove(this));
            Game.getInstance().getObjectHandler().getObjectsToRemove().add(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //---------

    /**
     * The Act-Method, triggered by the ActThread
     *
     * @see net.colorman.threads.ActThread
     *
     */
    public void act() {}

    /**
     * This Method teleports the Object to a x and y coordinate
     *
     * @param x
     * @param y
     */
    public void setLocation(double x, double y) {
        setTranslateX(x);
        setTranslateY(y);
    }

    /**
     * This Method is triggered when the Player is to far to the right
     * The Object slides to the left
     *
     * @param speed
     */
    public void slide(double speed) {
        setTranslateX(getTranslateX() - speed);
    }
}
