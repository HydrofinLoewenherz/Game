package net.colorman.objects.entitys;

import javafx.scene.image.Image;
import net.colorman.Game;
import net.colorman.misc.Vector;
import net.colorman.objects.Object;
import net.colorman.objects.structure.Platform;

/**
 * Created by Paul on 13.06.2016.
 */

public class Entity extends Object {

    protected boolean isInAir = false;

    public Entity(Image defaultImage, Image[] imageList) {
        super(defaultImage, imageList);
    }

    public void move(Vector vector) {
        double tempX = getTranslateX();
        double tempY = getTranslateY();

        setTranslateX(tempX + vector.getLengthX());
        if (isIntersecting()) {
            setTranslateX(tempX);
        }

        setTranslateY(tempY + 5);
        if (isIntersecting()) {
            setTranslateY(tempY);
        }

        //test if in air
        tempY = getTranslateY();
        setTranslateY(tempY + vector.getLengthY());
        isInAir = !isIntersecting();
        setTranslateY(tempY);
    }

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
