package de.holube;

import java.awt.geom.Rectangle2D;

public class Rectangle extends Rectangle2D.Double {

    public Rectangle(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    public String toSVG(String className) {
        return STR."<rect class=\"\{className}\" x=\"\{(int) x}\" y=\"\{(int) y}\" width=\"\{(int) width}\" height=\"\{(int) height}\"/>";
    }

    public Rectangle scale(double factor) {
        return new Rectangle(x * factor, y * factor, width * factor, height * factor);
    }

    public Rectangle move(int x, int y) {
        return new Rectangle(this.x + x, this.y + y, width, height);
    }

}
