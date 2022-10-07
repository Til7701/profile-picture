package de.holube;

import de.holube.base.SolidLineDrawer;

import java.awt.*;
import java.util.Set;

public class BorderDrawer extends SolidLineDrawer {

    public BorderDrawer(int width, int ignoredHeight, Color color) {
        super(color);
        scaleFactor = 1.0 / 6.0;
        stroke = new BasicStroke(0.03F * width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);

        lines.addAll(Set.of(
                new double[]{0, 0, 0, 6},
                new double[]{0, 0, 6, 0},
                new double[]{0, 6, 6, 6},
                new double[]{6, 0, 6, 6}
        ));
    }
}
