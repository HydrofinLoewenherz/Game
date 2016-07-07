package net.colorman.level;

import net.colorman.enums.PlatformSize;

public class Level_2 extends Level {

    public Level_2() {
        super(new int[] {0,9}, "The Second");
    }

    @Override
    protected void loadObjects() {
        addPlatform(0, 1000, PlatformSize.LONG);
    }
}
