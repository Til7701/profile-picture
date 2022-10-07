package de.holube.base;

import java.awt.image.BufferedImage;

public abstract class PictureFactory {

    protected BufferedImage createBlankImage(int width, int height) {
        return new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    }

    public abstract BufferedImage create(int width, int height);

}
