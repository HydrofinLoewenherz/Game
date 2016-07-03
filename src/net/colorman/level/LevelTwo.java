package net.colorman.level;

import net.colorman.enums.PlatformSize;
import net.colorman.objects.entitys.player.Player;

/**
 * Created by Paul on 03.07.2016.
 */
public class LevelTwo extends Level {

    public LevelTwo() {
        super(new int[] {0,9});
    }

    @Override
    protected void loadObjects() {
        new Player();
        addPlatform(0, 1000, PlatformSize.Base);
    }
}
