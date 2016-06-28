package net.colorman.level;

import net.colorman.enums.PlatformSize;
import net.colorman.objects.entitys.player.Player;
import net.colorman.objects.structure.Platform;

/**
 * Created by Paul on 26.06.2016.
 */
public class LevelOne extends Level {

    public LevelOne() {
        super(new int[] {0,3});
    }

    @Override
    protected void loadObjects() {
        new Player();
        new Platform(200, 1000, PlatformSize.GROUND);

    }
}
