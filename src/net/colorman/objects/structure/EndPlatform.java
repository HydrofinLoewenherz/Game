package net.colorman.objects.structure;

import javafx.scene.image.Image;
import net.colorman.Game;
import net.colorman.objects.Object;

/**
 * Created by Paul on 03.07.2016.
 */
public class EndPlatform extends Object {

    public EndPlatform(double x, double y) {
        super(new Image("file:src/net/colorman/resources/images/normalPlatform.png"), null);

        setLocation(x,y);
    }

    @Override
    public void act() {
        if (this.getBoundsInParent().intersects(Game.getInstance().getObjectHandler().getPlayer().getBoundsInParent()))
            Game.getInstance().getRoundHandler().handelRoundWin();
    }
}
