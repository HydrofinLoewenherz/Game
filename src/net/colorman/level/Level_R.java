package net.colorman.level;

import net.colorman.enums.PlatformSize;

import java.util.Random;

public class Level_R extends Level {

    public Level_R() {
        super(new int[] {0,1});
    }

    @Override
    protected void loadObjects() {
        addPlatform(0,800, PlatformSize.NORMAL);

        Random rnd = new Random();

        int count = rnd.nextInt(20);
        for (int i = 0; i < count; i++) {
            addPlatform(rnd.nextInt(700), rnd.nextInt(800) + 200, PlatformSize.SHORT);
        }
    }
}
