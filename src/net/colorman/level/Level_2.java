package net.colorman.level;

import net.colorman.enums.PlatformSize;

/**
 * Created by Paul on 03.07.2016.
 */
public class Level_2 extends Level {

    public Level_2() {
        super(new int[] {0,9});
    }

    @Override
    protected void loadObjects() {
        addPlatform(0, 1000, PlatformSize.LONG);
    }
}
