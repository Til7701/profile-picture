package de.holube;

import de.holube.base.SolidLineDrawer;

import java.awt.*;
import java.util.Random;

public class RandomLinesDrawer extends SolidLineDrawer {

    private final int GRID;

    public RandomLinesDrawer(int width, int ignoredHeight, Color color, long seed, int amountOfLines, int scale) {
        super(color);
        GRID = scale;
        scaleFactor = 1.0 / GRID;
        stroke = new BasicStroke((0.1F * width) / GRID, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);

        Random random = new Random(seed);

        for (int i = 0; i < amountOfLines; i++) {
            lines.add(drawLine(random));
        }
    }

    private double[] drawLine(Random random) {
        double[] result = new double[4];

        result[0] = random.nextInt(GRID);
        result[1] = random.nextInt(GRID);

        if (random.nextBoolean()) {
            result[2] = result[0];
            result[3] = result[1] + 1;
        } else {
            result[2] = result[0] + 1;
            result[3] = result[1];
        }

        return result;
    }

}
