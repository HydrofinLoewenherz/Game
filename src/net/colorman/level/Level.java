package net.colorman.level;

import javafx.scene.image.ImageView;

import java.util.List;

/**
 * Created by Paul on 12.06.2016.
 */
public abstract class Level {

    private final int[] backgroundSpan;
    private final List<ImageView> backgroundArray;

    public Level(int[] backgroundSpan) {
        this.backgroundSpan = backgroundSpan;
        loadResources();
    }

    private final void loadResources() {
    }

}
