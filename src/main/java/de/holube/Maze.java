package de.holube;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Maze {

    private final int lineLength;
    private final String cssClass;
    private final int width;
    private final int height;
    private final double probability;

    private final List<Line> lines = new ArrayList<>();
    private final Random random;

    public Maze(long seed, int lineLength, String cssClass, int width, int height, double probability) {
        this.lineLength = lineLength;
        this.cssClass = cssClass;
        this.width = width;
        this.height = height;
        this.probability = probability;
        this.random = new Random(seed);
        createLines();
        optimizeLines();
    }

    private void createLines() {
        for (int x = 0; x < width; x += lineLength) {
            for (int y = 0; y < height; y += lineLength) { // loop over all possible starting points
                createLine(x, y);
            }
        }
    }

    private void createLine(int x, int y) {
        if (random.nextDouble() < probability) { // chance to draw a line
            if (random.nextBoolean()) { // horizontal or vertical
                if (y == 0) return; // don't draw lines at the border
                lines.add(new Line(x, y, (double) x + lineLength, y));
            } else {
                if (x == 0) return; // don't draw lines at the border
                lines.add(new Line(x, y, x, (double) y + lineLength));
            }
        }
    }

    private void optimizeLines() {
        List<Line> linesCopy = new ArrayList<>(lines);
        int previousSize;

        do {
            previousSize = linesCopy.size();
            findPairAndMergeIfPossible(linesCopy);
        } while (linesCopy.size() < previousSize);

        System.out.println(STR."Reduced lines from \{lines.size()} to \{linesCopy.size()}");
        lines.clear();
        lines.addAll(linesCopy);
    }

    private void findPairAndMergeIfPossible(List<Line> linesCopy) {
        for (int i = 0; i < linesCopy.size(); i++) {
            Line line = linesCopy.get(i);
            for (int j = i + 1; j < linesCopy.size(); j++) {
                Line other = linesCopy.get(j);
                if (line == other) continue;
                Optional<Line> merged = mergeLinesIfPossible(line, other);
                if (merged.isPresent()) {
                    linesCopy.remove(line);
                    linesCopy.remove(other);
                    linesCopy.add(merged.get());
                    return;
                }
            }
        }
    }

    private Optional<Line> mergeLinesIfPossible(Line line1, Line line2) {
        if (line1.partiallyOverlapsLine(line2)) {
            return Optional.of(new Line(line1.getP1(), line2.getP2()));
        }
        return Optional.empty();
    }

    public String toSVG() {
        StringBuilder sb = new StringBuilder();
        for (Line line : lines) {
            sb.append(line.toSVG(cssClass))
                    .append("\n");
        }
        return sb.toString();
    }

}
