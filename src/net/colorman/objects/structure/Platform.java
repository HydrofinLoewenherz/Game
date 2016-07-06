package net.colorman.objects.structure;

import javafx.scene.image.Image;
import net.colorman.enums.PlatformSize;
import net.colorman.objects.Object;

/**
 * Created by Paul on 13.06.2016.
 */

public class Platform extends Object {

    public Platform(double x, double y, PlatformSize size) {
        //super(Game.getInstance().getObjectHandler().getResourceLoader().getImage("platform.png"), null);
        super(new Image("file:src/net/colorman/resources/images/normalPlatform.png"), null);

        setImage(size);
        setLocation(x,y);
    }

    /**
     * This Method sets an Image to the Platform related to its type (short / normal / long / base)
     *
     * @param size  The SIze of the Platform
     */
    private void setImage(PlatformSize size) {
        switch (size) {
            case SHORT:
                setImage(new Image("file:src/net/colorman/resources/images/shortPlatform.png"));
                break;
            case NORMAL:
                setImage(new Image("file:src/net/colorman/resources/images/normalPlatform.png"));
                break;
            case LONG:
                setImage(new Image("file:src/net/colorman/resources/images/longPlatform.png"));
                break;
            case Base:
                setImage(new Image("file:src/net/colorman/resources/images/basePlatform.png"));
                break;
            default:
        }
    }

    /**
     * A Getter for the Width of the Platform
     *
     * @return Double   Width
     */
    public double getWidth() {
        return getImage().getWidth();
    }
}
