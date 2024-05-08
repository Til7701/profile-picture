package de.holube;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LineTest {

    @Test
    void horizontalLine() {
        Line line = new Line(0, 0, 10, 0);
        assertTrue(line.isHorizontal());
        Line line2 = new Line(10, 0, 20, 0);
        assertTrue(line2.isHorizontal());
    }

    @Test
    void verticalLine() {
        Line line = new Line(0, 0, 0, 10);
        assertTrue(line.isVertical());
    }

    @Test
    void partiallyOverlapsLineTest() {
        Line line1 = new Line(0, 0, 10, 0);
        Line line2 = new Line(10, 0, 20, 0);
        assertTrue(line1.partiallyOverlapsLine(line2));
    }

}
