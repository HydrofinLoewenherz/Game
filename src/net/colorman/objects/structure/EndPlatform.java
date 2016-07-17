package net.colorman.objects.structure;

import javafx.scene.image.Image;
import net.colorman.Game;
import net.colorman.objects.Object;

public class EndPlatform extends Object {

    public EndPlatform(double x, double y) {
        super(new Image("file:src/net/colorman/resources/images/normalPlatform.png"), null);

        setLocation(x,y);
    }

    @Override
    public void act() {
        if (this.getBoundsInParent().intersects(Game.getInstance().getPlayer().getBoundsInParent()))
            Game.getInstance().getRoundHandler().handelRoundWin();
    }
}
