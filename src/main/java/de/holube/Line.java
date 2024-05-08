package de.holube;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class Line extends Line2D.Double {

    public Line(double x1, double y1, double x2, double y2) {
        super(x1, y1, x2, y2);
    }

    public Line(Point2D p1, Point2D p2) {
        super(p1, p2);
    }

    public String toSVG(String className) {
        return STR."<line class=\"\{className}\" x1=\"\{(int) x1}\" y1=\"\{(int) y1}\" x2=\"\{(int) x2}\" y2=\"\{(int) y2}\"/>";
    }

    public Line scale(double factor) {
        return new Line(x1 * factor, y1 * factor, x2 * factor, y2 * factor);
    }

    public Line move(int x, int y) {
        return new Line(x1 + x, y1 + y, x2 + x, y2 + y);
    }

    public boolean isHorizontal() {
        return y1 == y2 && x1 != x2;
    }

    public boolean isVertical() {
        return x1 == x2 && y1 != y2;
    }

    public boolean partiallyOverlapsLine(Line other) {
        final double EPSILON = 0.0001;
        return (
                       (this.isHorizontal() && other.isHorizontal()) &&
                       (Math.abs(this.y1 - other.y1) < EPSILON) &&
                       (Math.abs(this.x2 - other.x1) < EPSILON)
               ) ||
               (
                       (this.isVertical() && other.isVertical()) &&
                       (Math.abs(this.x1 - other.x1) < EPSILON) &&
                       (Math.abs(this.y2 - other.y1) < EPSILON)
               );
    }

}
