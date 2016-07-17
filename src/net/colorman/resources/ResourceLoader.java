package net.colorman.resources;

import javafx.scene.image.Image;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * The resource loader class provides several resource files such as background graphics
 *
 * @see javafx.scene.image.Image
 */
public class ResourceLoader {

    /**
     * Package in which the resources are stored as default
     */
    private static final String RESOURCE_PATH = "/net/colorman/resources/";
    /**
     * Images subfolder
     *
     * @see #RESOURCE_PATH
     */
    private static final String IMAGE_FOLDER = "images/";

    /**
     * File name prefix of background images
     */
    private static final String BACKGROUND_IMAGE_PREFIX = "background";
    /**
     * File extension of background images
     */
    private static final String BACKGROUND_IMAGE_SUFFIX = ".png";

    /**
     * Method to load a single JavaFX Image from the resource package
     *
     * @param name  Filename
     * @return      JavaFX Image
     */
    public Image getImage(String name) {

        String imagePath = RESOURCE_PATH + IMAGE_FOLDER + name;
        URL imageURL;

        try {
            imageURL = getClass().getResource(imagePath).toURI().toURL();
        } catch (URISyntaxException | MalformedURLException e) {
            System.err.println("Warning: The requested Image (\"" + name + "\") could not be loaded.");
            return null;
        }

        return new Image(imageURL.toString());

    }

    /**
     * Returns all available background Images within a specified range as a List
     *
     * @param begin         Begin index
     * @param end           End index
     * @return              Returns a List of JavaFX Images
     */
    public List<Image> getBackgroundImages(int begin, int end) {

        List<javafx.scene.image.Image> list = new ArrayList<>();

        for (int index = begin; index < end; index++) {
            list.add(getImage(BACKGROUND_IMAGE_PREFIX + String.valueOf(index) + BACKGROUND_IMAGE_SUFFIX));
        }

        return list;

    }
}
