package de.holube;

import de.holube.base.PictureFactory;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ProfilePictureFactory extends PictureFactory {

    @Override
    public BufferedImage create(int width, int height) {
        BufferedImage image = createBlankImage(width, height);

        Color background = new Color(35, 40, 45);

        new SolidBackgroundDrawer(background).draw(image);
        new RandomLinesDrawer(width, height, new Color(150, 150, 150), 13, 200, 24).draw(image);
        new RandomLinesDrawer(width, height, new Color(200, 200, 200), 42, 200, 12).draw(image);
        new THBackground(background).draw(image);
        new THDrawer(width, height, Color.WHITE).draw(image);
        new BorderDrawer(width, height, Color.WHITE).draw(image);

        return image;
    }

}
