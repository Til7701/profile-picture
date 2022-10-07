package de.holube.io;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageSaver {

    private ImageSaver() {

    }

    @SuppressWarnings("UnusedReturnValue")
    public static boolean save(BufferedImage image, String path) {
        boolean success = false;

        try {
            File f = new File(path);
            success = ImageIO.write(image, "png", f);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return success;
    }

}
