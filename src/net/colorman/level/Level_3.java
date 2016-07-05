package net.colorman.level;

import net.colorman.enums.PlatformSize;

/**
 * Created by Paul on 05.07.2016.
 */
public class Level_3 extends Level{

    public Level_3() {
        super(new int[] {0,1});
    }

    @Override
    protected void loadObjects() {
        addPlatform(0, 500, PlatformSize.SHORT);
        addPlatform(1000, 1000, PlatformSize.NORMAL);
    }
}
