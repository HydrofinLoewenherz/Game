package net.colorman.level;

import net.colorman.enums.PlatformSize;
import net.colorman.objects.entitys.player.Player;

/**
 * Created by Paul on 26.06.2016.
 */
public class LevelOne extends Level {

    public LevelOne() {
        super(new int[] {0,9});
    }

    @Override
    protected void loadObjects() {
        new Player();
        addPlatform(200, 1000, PlatformSize.NORMAL);
        addPlatform(50, 500, PlatformSize.SHORT);
        addPlatform(200, 750, PlatformSize.NORMAL);
        addPlatform(100, 1000, PlatformSize.SHORT);
        addPlatform(150, 400, PlatformSize.NORMAL);
        addPlatform(500, 1000, PlatformSize.SHORT);
        addPlatform(0, 500, PlatformSize.LONG);
        addPlatform(200, 700, PlatformSize.NORMAL);
    }
}
