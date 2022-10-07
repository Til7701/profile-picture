package de.holube;

import de.holube.base.Drawer;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class THBackground extends Drawer {

    private final Color background;
    private final List<Drawer> drawers = new ArrayList<>();

    public THBackground(Color background) {
        this.background = background;
    }

    @Override
    public void draw(BufferedImage image) {
        BufferedImage tmpBackground = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = tmpBackground.createGraphics();
        graphics.setColor(background);
        graphics.fillRect(0, 0, image.getWidth(), image.getHeight());
        for (Drawer drawer : drawers) {
            drawer.draw(tmpBackground);
        }
        graphics.dispose();

        overlay(image, tmpBackground);
    }

    private void overlay(BufferedImage base, BufferedImage addition) {
        int offset = base.getWidth() / 6;
        int interval = addition.getWidth() / 4;

        int[] newPixel = new int[interval * interval * 3];
        addition.getAlphaRaster().setPixels(0, interval, interval, interval * 3, newPixel);
        addition.getAlphaRaster().setPixels(interval * 2, interval, interval, interval, newPixel);
        addition.getAlphaRaster().setPixels(interval * 2, interval * 3, interval, interval, newPixel);

        double scaleFactor = 2.0 / 3.0;
        int w = addition.getWidth();
        int h = addition.getHeight();
        BufferedImage scaledAddition = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        AffineTransform at = new AffineTransform();
        at.scale(scaleFactor, scaleFactor);
        AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        scaledAddition = scaleOp.filter(addition, scaledAddition);

        int[] tmpA = new int[1];
        int[] tmp = new int[4];
        for (int x = 0; x < scaledAddition.getWidth(); x++) {
            for (int y = 0; y < scaledAddition.getHeight(); y++) {
                scaledAddition.getAlphaRaster().getPixel(x, y, tmpA);
                if (tmpA[0] != 0) {
                    scaledAddition.getRaster().getPixel(x, y, tmp);
                    base.getRaster().setPixel(x + offset, y + offset, tmp);
                }
            }
        }
    }

    @SuppressWarnings("unused")
    public List<Drawer> getDrawers() {
        return drawers;
    }

}
