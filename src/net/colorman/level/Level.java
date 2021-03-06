package net.colorman.level;

import javafx.scene.image.Image;
import net.colorman.enums.PlatformSize;
import net.colorman.objects.entitys.player.Player;
import net.colorman.objects.structure.Background;
import net.colorman.objects.structure.EndPlatform;
import net.colorman.objects.structure.Platform;
import net.colorman.resources.ResourceLoader;

import java.util.List;

public abstract class Level {

    /**
     * Import of the resourceLoader
     */
    private final ResourceLoader resourceLoader;

    /**
     * temp Value of the last placed Platform to set the next one behind that one
     */
    private Platform temp = null;

    /**
     * The backgroundSpan for this level
     */
    private final int[] backgroundSpan;

    /**
     * A List width Images created out of the backgroundSpan
     */
    private List<Image> backgroundArray;

    /**
     * The Name of the Level
     */
    private final String name;

    Level(int[] backgroundSpan, String name) {
        this.name = name;
        this.resourceLoader = new ResourceLoader();
        this.backgroundSpan = backgroundSpan;
    }

    public final void setup() {loadResources();
        temp = null;
        loadBackgrounds();
        new Player();
        loadObjects();

        addEndPlatform(100, 750);
    }

    /**
     * This Method loads the Backgrounds and saves them to the backgroundArray
     *
     * @see #backgroundArray
     *
     */
    private void loadResources() {
        backgroundArray = resourceLoader.getBackgroundImages(backgroundSpan[0], backgroundSpan[1]);
    }

    /**
     * This Method loads the Backgrounds on to the Scene
     *
     */
    private void loadBackgrounds() {
        Background temp, last;
        last = null;

        for (Image image : backgroundArray) {
            if (last != null) temp = new Background(last, image, null);
            else temp = new Background(0, image, null);
            last = temp;
        }
    }

    /**
     * This Method loads the Platforms and other Objects if needed
     *
     */
    void loadObjects() {}

    /**
     * This Method adds a Platform to the scene
     *
     * @param gap       The Gap between this Platform and the last set
     * @param height    The y-Coordinate the Platform will be set on
     * @param size      The size of the Platform (short / normal / long / base)
     */
    void addPlatform(double gap, double height, PlatformSize size) {
        if (temp == null) {
            temp = new Platform(gap, height, size);
        }
        else {
            temp = new Platform(temp.getTranslateX() + temp.getWidth() + gap, height, size);
        }
    }

    /**
     * This Method adds a EndPlatform, a Platform that will end the Round when touched
     *
     * @param gap       The Gap between this Platform and the last set
     * @param height    The y-Coordinate the Platform will be set on
     */
    private void addEndPlatform(double gap, double height) {
        if (temp == null) {
            new EndPlatform(gap, height);
        }
        else {
            new EndPlatform(temp.getTranslateX() + temp.getWidth() + gap, height);
        }
    }

    /**
     * A Getter for the LevelName
     *
     * @return String   Name of the level
     */
    public String getName() {
        return name;
    }
}
