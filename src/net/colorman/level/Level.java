package net.colorman.level;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import net.colorman.resources.ResourceLoader;

import java.io.IOException;
import java.util.List;

/**
 * Created by Paul on 12.06.2016.
 */
public abstract class Level {

    private final ResourceLoader resourceLoader;

    private final int[] backgroundSpan;
    private List<Image> backgroundArray;

    public Level(int[] backgroundSpan) {
        this.resourceLoader = new ResourceLoader();
        this.backgroundSpan = backgroundSpan;
        loadResources();
    }

    private final void loadResources() {
        try {
            backgroundArray = resourceLoader.getBackgroundImages(backgroundSpan[0], backgroundSpan[1]);
        } catch (IOException e) {
            e.printStackTrace(); // Error Handling muss hinzugefügt werden!
        }
    }

}
