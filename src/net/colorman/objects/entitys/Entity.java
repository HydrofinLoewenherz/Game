package net.colorman.objects.entitys;

import javafx.scene.image.Image;
import net.colorman.Game;
import net.colorman.misc.Vector;
import net.colorman.objects.Object;
import net.colorman.objects.structure.Platform;

public class Entity extends Object {

    /**
     * A boolean to see if the Object is in mid air
     */
    protected boolean isInAir = false;

    /**
     * The Vector the Object is Moving width
     */
    protected Vector vector;

    public Entity(Image defaultImage, Image[] imageList) {
        super(defaultImage, imageList);
        vector = new Vector(0,-1,1);
    }

    /**
     * This Method moves the Object by an specific Vector
     *
     */
    public void move(Vector vector) {
        double tempX = getTranslateX();
        double tempY = getTranslateY();

        setTranslateX(tempX + vector.getLengthX());
        while (isIntersecting()) {
            setTranslateX(tempX);
            vector.decreaseX(2);
            setTranslateX(tempX + vector.getLengthX());
        }

        setTranslateY(tempY + vector.getLengthY());
        while (isIntersecting()) {
            setTranslateY(tempY);
            vector.decreaseY(2);
            setTranslateY(tempY + vector.getLengthY());
        }

        vector.decrease(5);
    }

    /**
     * This Method checks if the Object is intersecting a Platform
     *
     * @return Boolean  isIntersecting
     */
    public boolean isIntersecting() {
        for(Object object : Game.getInstance().getObjectHandler().getObjectsAct()) {
            if (object instanceof Platform) {
                if (object.getBoundsInParent().intersects(getBoundsInParent())) {
                    return true;
                }
            }
        }
        return false;
    }
}
