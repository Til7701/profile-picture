package de.holube;

import java.util.ArrayList;
import java.util.List;

public class ProfilePictureFactory {

    private static final int width = 600;
    private static final int height = 600;

    public String create() {
        final List<Covering> coverings = new ArrayList<>();
        final TH th = new TH(100, 100, 100);
        coverings.add(th);
        final Maze maze2 = new Maze(42, 25, CSS.MAZE_2, width, height, 0.4, coverings);
        coverings.add(maze2);
        final Maze maze1 = new Maze(42, 50, CSS.MAZE_1, width, height, 0.7, coverings);

        return STR."""
        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 \{width} \{height}">
        <defs>
        <style type="text/css"><![CDATA[
        \{new CSS()}]]></style>
        </defs>
        \{maze2.toSVG()}
        \{maze1.toSVG()}
        \{th.toSVG()}
        </svg>
        """;
    }

}
