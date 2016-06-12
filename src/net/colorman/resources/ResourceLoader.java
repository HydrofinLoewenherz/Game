package net.colorman.resources;

import javafx.embed.swing.SwingFXUtils;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

public class ResourceLoader {

    private static final String RESOURCE_PATH = "/net/colorman/resources/";

    private static final String IMAGES_FOLDER = "images/";
    private static final String IMAGES_RESOURCE_PATH = RESOURCE_PATH + IMAGES_FOLDER;

    /*
    Background file name pattern:
    "background[INDEX].png"
    Example: "background0.png", "background1.png", ..., "background42.png", etc.
    */
    private static final String BACKGROUND_IMAGE_PREFIX = "background";
    private static final String BACKGROUND_IMAGE_POSTFIX = ".png";

    /*
    Helper method to convert AWT into JavaFX Images
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

    public javafx.scene.image.Image getImage(String name) {

        String imagePath = IMAGES_RESOURCE_PATH + name;
        java.awt.Image awtImage = new ImageIcon(getClass().getResource(imagePath)).getImage();
        return convertAWTImageToFX(awtImage);

    }

    public List<javafx.scene.image.Image> getBackgroundImages(int begin, int end) throws IOException {

        List<javafx.scene.image.Image> backgroundImages = new ArrayList<>();

        for (int index = begin; index < end; index++) {

            String currentImagePath = IMAGES_RESOURCE_PATH + BACKGROUND_IMAGE_PREFIX + String.valueOf(index) + BACKGROUND_IMAGE_POSTFIX;

            java.awt.Image awtImage = new ImageIcon(getClass().getResource(currentImagePath)).getImage();
            backgroundImages.add(convertAWTImageToFX(awtImage));

        }

        return backgroundImages;

    }
}
