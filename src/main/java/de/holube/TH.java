package de.holube;

public class TH {

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
        for (Rectangle background : BACKGROUNDS) {
            sb.append(background.scale(scalingFactor).move(x, y).toSVG(CSS.TH_BACKGROUND))
                    .append("\n");
        }
        for (Line line : LINES_T) {
            sb.append(line.scale(scalingFactor).move(x, y).toSVG(CSS.TH_T))
                    .append("\n");
        }
        for (Line line : LINES_H) {
            sb.append(line.scale(scalingFactor).move(x, y).toSVG(CSS.TH_H))
                    .append("\n");
        }
        return sb.toString();
    }

}
