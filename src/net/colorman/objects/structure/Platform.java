package net.colorman.objects.structure;

import javafx.scene.image.Image;
import net.colorman.objects.Object;

/**
 * Created by Paul on 13.06.2016.
 */

public class Platform extends Object {

    public Platform(double x, double y, int size) {
        //super(Game.getInstance().getObjectHandler().getResourceLoader().getImage("platform.png"), null);
        super(new Image("file:src/net/colorman/resources/images/platform.png"), null);

        setLocation(x,y);
    }
}