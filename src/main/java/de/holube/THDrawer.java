package de.holube;

import de.holube.base.SolidLineDrawer;

import java.awt.*;
import java.util.Set;

public class THDrawer extends SolidLineDrawer {

    public THDrawer(int width, int ignoredHeight, Color color) {
        super(color);
        scaleFactor = 1.0 / 6.0;
        stroke = new BasicStroke(0.03F * width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);

        lines.addAll(Set.of(
                new double[]{1, 1, 1, 2},
                new double[]{1, 1, 5, 1},
                new double[]{1, 2, 2, 2},
                new double[]{2, 2, 2, 5},
                new double[]{2, 5, 3, 5},
                new double[]{3, 2, 3, 5},
                new double[]{3, 2, 4, 2},
                new double[]{3, 3, 4, 3},
                new double[]{4, 1, 4, 3},
                new double[]{4, 4, 3, 4},
                new double[]{4, 5, 4, 4},
                new double[]{5, 1, 5, 5},
                new double[]{5, 5, 4, 5}
        ));
    }

}
