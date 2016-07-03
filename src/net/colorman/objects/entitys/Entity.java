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
    protected Vector vector;

    public Entity(Image defaultImage, Image[] imageList) {
        super(defaultImage, imageList);
    }

    public void move() {
        double tempX = getTranslateX();
        double tempY = getTranslateY();

        setTranslateX(tempX + vector.getLengthX());
        if (isIntersecting()) setTranslateX(tempX);

        setTranslateY(tempY + vector.getLengthY());
        while (isIntersecting()) {
            setTranslateY(tempY);
            vector.decreseY(2);
            setTranslateY(tempY + vector.getLengthY());
        }

        //test if in air
        tempY = getTranslateY();
        setTranslateY(tempY + 5);
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
