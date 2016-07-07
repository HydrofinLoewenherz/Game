package net.colorman.level;

import net.colorman.enums.PlatformSize;

/**
 * Created by Paul on 07.07.2016.
 */
public class Level_4 extends Level {

    public Level_4() {
        super(new int[] {0,1}, "Another Try");
    }

    @Override
    protected void loadObjects() {
        addPlatform(0,800, PlatformSize.LONG);
        addPlatform(200, 700, PlatformSize.NORMAL);
        addPlatform(200, 600, PlatformSize.SHORT);
    }
}
