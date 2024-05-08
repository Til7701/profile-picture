package de.holube;

public class ProfilePictureFactory {

    private static final int width = 600;
    private static final int height = 600;

    public String create() {
        final TH th = new TH(100, 100, 100);
        final Maze maze2 = new Maze(42, 25, CSS.MAZE_2, width, height, 0.4);
        final Maze maze1 = new Maze(42, 50, CSS.MAZE_1, width, height, 0.7);

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
