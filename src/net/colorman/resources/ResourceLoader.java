package net.colorman.resources;

import javafx.embed.swing.SwingFXUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
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
    private static final String IMAGES_FOLDER = "images/";

    /**
     * File name prefix of background images
     */
    private static final String BACKGROUND_IMAGE_PREFIX = "background";
    /**
     * File extension of background images
     */
    private static final String BACKGROUND_IMAGE_POSTFIX = ".png";

    /**
     * This method is used to convert AWT images into JavaFX images.
     *
     * @param awtImage  Image object to convert
     * @return          JavaFX Image
     */
    private javafx.scene.image.Image convertAWTImageToFX(java.awt.Image awtImage) {

        BufferedImage bufferedImage = new BufferedImage(
                awtImage.getHeight(null),
                awtImage.getWidth(null),
                BufferedImage.TYPE_INT_ARGB);

        Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.drawImage(awtImage, 0, 0, null);
        graphics2D.dispose();

        return SwingFXUtils.toFXImage(bufferedImage, null);

    }

    /**
     * Method to load a single JavaFX Image from the resource package
     *
     * @param name  Filename
     * @return      JavaFX Image
     */
    public javafx.scene.image.Image getImage(String name) {

        String imagePath = RESOURCE_PATH + IMAGES_FOLDER + name;
        java.awt.Image awtImage = new ImageIcon(getClass().getResource(imagePath)).getImage();
        return convertAWTImageToFX(awtImage);

    }

    /**
     * Returns all available background Images within a specified range as a List
     *
     * @param begin         Begin index
     * @param end           End index
     * @return              List of JavaFX Images
     * @throws IOException  Throws IOException if any files could not be provided
     */
    public List<javafx.scene.image.Image> getBackgroundImages(int begin, int end) throws IOException {

        List<javafx.scene.image.Image> backgroundImages = new ArrayList<>();

        for (int index = begin; index < end; index++) {

            String currentImagePath = (
                    RESOURCE_PATH +
                    IMAGES_FOLDER +
                    BACKGROUND_IMAGE_PREFIX +
                    String.valueOf(index) +
                    BACKGROUND_IMAGE_POSTFIX
            );

            java.awt.Image awtImage = new ImageIcon(getClass().getResource(currentImagePath)).getImage();
            backgroundImages.add(convertAWTImageToFX(awtImage));

        }

        return backgroundImages;

    }
}
