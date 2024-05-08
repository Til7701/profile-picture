package de.holube;

public class CSS {

    public static final String BACKGROUND = "background";
    public static final String TH_T = "t";
    public static final String TH_H = "h";
    public static final String TH_BACKGROUND = "th-background";
    public static final String MAZE_1 = "maze1";
    public static final String MAZE_2 = "maze2";
    public static final String MAZE_3 = "maze3";

    private static final String BACKGROUND_FILL = "#222222";
    private static final String MAIN_STROKE = "white";
    private static final String MAZE1_STROKE = "#EEEEEE";
    private static final String MAZE2_STROKE = "#666666";
    private static final String MAZE3_STROKE = "#444444";

    public String toString() {
        return STR."""
        .\{BACKGROUND} {
            fill: \{BACKGROUND_FILL};
        }
        .\{TH_BACKGROUND} {
            fill: \{BACKGROUND_FILL};
        }
        .\{TH_T}, .\{TH_H} {
            stroke: \{MAIN_STROKE};
            stroke-linecap: round;
        }
        .\{TH_T} {
            stroke-width: 20;
        }
        .\{TH_H} {
            stroke-width: 10;
        }
        .\{MAZE_1} {
            stroke: \{MAZE1_STROKE};
            stroke-width: 3;
        }
        .\{MAZE_2} {
            stroke: \{MAZE2_STROKE};
            stroke-width: 2;
        }
        .\{MAZE_3} {
            stroke: \{MAZE3_STROKE};
            stroke-width: 1;
        }
        """;
    }

}
