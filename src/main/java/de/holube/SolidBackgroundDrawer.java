package de.holube;

import de.holube.base.Drawer;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SolidBackgroundDrawer extends Drawer {

    private final Color color;

    public SolidBackgroundDrawer(Color color) {
        this.color = color;
    }

    @Override
    public void draw(BufferedImage image) {
        Graphics graphics = image.createGraphics();
        graphics.setColor(color);
        graphics.fillRect(0, 0, image.getWidth() - 1, image.getHeight() - 1);
        graphics.dispose();
    }

}
