package de.holube;

import java.util.ArrayList;
import java.util.List;

public class TH implements Covering {

    private static final Rectangle[] BACKGROUNDS = {
            new Rectangle(0, 0, 4, 1),
            new Rectangle(1, 1, 1, 3),
            new Rectangle(3, 1, 1, 3),
            new Rectangle(2, 2, 1, 1)
    };

    private static final Line[] LINES_T = {
            new Line(0, 0, 3, 0),
            new Line(0, 0, 0, 1),
            new Line(0, 1, 1, 1),
            new Line(1, 4, 1, 1),
            new Line(2, 4, 2, 1),
            new Line(1, 4, 2, 4),
            new Line(3, 1, 3, 0),
            new Line(3, 1, 2, 1)
    };

    private static final Line[] LINES_H = {
            new Line(4, 4, 4, 0),
            new Line(3, 0, 4, 0),
            new Line(3, 4, 4, 4),
            new Line(3, 4, 3, 3),
            new Line(3, 2, 3, 1),
            new Line(3, 2, 2, 2),
            new Line(3, 3, 2, 3),
    };

    private final int x;
    private final int y;
    private final double scalingFactor;

    public TH(int x, int y, double scalingFactor) {
        this.x = x;
        this.y = y;
        this.scalingFactor = scalingFactor;
    }

    public String toSVG() {
        StringBuilder sb = new StringBuilder();
        for (Rectangle background : getBackgrounds()) {
            sb.append(background.toSVG(CSS.TH_BACKGROUND))
                    .append("\n");
        }
        for (Line line : getLinesT()) {
            sb.append(line.toSVG(CSS.TH_T))
                    .append("\n");
        }
        for (Line line : getLinesH()) {
            sb.append(line.toSVG(CSS.TH_H))
                    .append("\n");
        }
        return sb.toString();
    }

    private List<Rectangle> getBackgrounds() {
        List<Rectangle> backgrounds = new ArrayList<>();
        for (Rectangle background : BACKGROUNDS) {
            backgrounds.add(background.scale(scalingFactor).move(x, y));
        }
        return backgrounds;
    }

    private List<Line> getLinesT() {
        List<Line> lines = new ArrayList<>();
        for (Line line : LINES_T) {
            lines.add(line.scale(scalingFactor).move(x, y));
        }
        return lines;
    }

    private List<Line> getLinesH() {
        List<Line> lines = new ArrayList<>();
        for (Line line : LINES_H) {
            lines.add(line.scale(scalingFactor).move(x, y));
        }
        return lines;
    }

    @Override
    public boolean isCovering(int x, int y) {
        List<Covering> coverings = new ArrayList<>();
        coverings.addAll(getBackgrounds());
        coverings.addAll(getLinesT());
        coverings.addAll(getLinesH());
        for (Covering covering : coverings) {
            if (covering.isCovering(x, y)) {
                return true;
            }
        }
        return false;
    }

}
