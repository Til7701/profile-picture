package de.holube.base;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public abstract class SolidLineDrawer extends Drawer {

    protected final List<double[]> lines = new ArrayList<>();
    private final Color color;
    protected Stroke stroke = new BasicStroke(1);
    protected double scaleFactor = 1;

    protected SolidLineDrawer(Color color) {
        this.color = color;
    }

    @Override
    public void draw(BufferedImage image) {
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(color);
        graphics.setStroke(stroke);

        int[] tmp = new int[4];
        for (double[] line : lines) {
            if (line.length != 4)
                throw new IllegalArgumentException();

            tmp[0] = (int) (line[0] * scaleFactor * image.getWidth());
            tmp[1] = (int) (line[1] * scaleFactor * image.getHeight());
            tmp[2] = (int) (line[2] * scaleFactor * image.getWidth());
            tmp[3] = (int) (line[3] * scaleFactor * image.getHeight());
            graphics.drawLine(tmp[0], tmp[1], tmp[2], tmp[3]);
        }

        graphics.dispose();
    }

}
