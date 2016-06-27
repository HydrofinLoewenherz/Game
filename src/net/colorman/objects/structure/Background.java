package net.colorman.objects.structure;

import javafx.scene.image.Image;
import net.colorman.objects.Object;

/**
 * Created by Paul on 26.06.2016.
 */
public class Background extends Object {

    public Background(double x, Image defaultImage, Image[] imageList) {
        super(defaultImage, imageList);
        setLocation(x, 0);
        toBack();
    }

    public Background(Background background, Image defaultImage, Image[] imageList) {
        super(defaultImage, imageList);
        setLocation(background.getTranslateX() + background.getImage().getWidth(), 0);
    }
}
