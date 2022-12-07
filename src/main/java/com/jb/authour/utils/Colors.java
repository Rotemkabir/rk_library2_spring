package com.jb.authour.utils;

public enum Colors {
    RESET("\033[0m"),

    BLACK("\033[30m"),   // BLACK
    RED("\033[31m"),     // RED
    GREEN("\033[32m"),   // GREEN
    YELLOW("\033[33m"),  // YELLOW
    BLUE("\033[34m"),    // BLUE
    PURPLE("\033[35m"),  // PURPLE
    CYAN("\033[36m"),    // CYAN
    WHITE("\033[37m"),   // WHITE

    // Bold
    BLACK_BOLD("\033[1;30m"),  // BLACK
    RED_BOLD("\033[1;31m"),    // RED
    GREEN_BOLD("\033[1;32m"),  // GREEN
    YELLOW_BOLD("\033[1;33m"), // YELLOW
    BLUE_BOLD("\033[1;34m"),   // BLUE
    PURPLE_BOLD("\033[1;35m"), // PURPLE
    CYAN_BOLD("\033[1;36m"),   // CYAN
    WHITE_BOLD("\033[1;37m"),  // WHITE

    // Underline
    BLACK_UNDERLINED("\033[4;30m"),  // BLACK
    RED_UNDERLINED("\033[4;31m"),    // RED
    GREEN_UNDERLINED("\033[4;32m"),  // GREEN
    YELLOW_UNDERLINED("\033[4;33m"), // YELLOW
    BLUE_UNDERLINED("\033[4;34m"),   // BLUE
    PURPLE_UNDERLINED("\033[4;35m"), // PURPLE
    CYAN_UNDERLINED("\033[4;36m"),   // CYAN
    WHITE_UNDERLINED("\033[4;37m"),  // WHITE

    // Background
    BLACK_BACKGROUND("\033[40m"),  // BLACK
    RED_BACKGROUND("\033[41m"),    // RED
    GREEN_BACKGROUND("\033[42m"),  // GREEN
    YELLOW_BACKGROUND("\033[43m"), // YELLOW
    BLUE_BACKGROUND("\033[44m"),   // BLUE
    PURPLE_BACKGROUND("\033[45m"), // PURPLE
    CYAN_BACKGROUND("\033[46m"),   // CYAN
    WHITE_BACKGROUND("\033[47m"),  // WHITE

    // High Intensity
    BLACK_BRIGHT("\033[90m"),  // BLACK
    RED_BRIGHT("\033[91m"),    // RED
    GREEN_BRIGHT("\033[92m"),  // GREEN
    YELLOW_BRIGHT("\033[93m"), // YELLOW
    BLUE_BRIGHT("\033[94m"),   // BLUE
    PURPLE_BRIGHT("\033[95m"), // PURPLE
    CYAN_BRIGHT("\033[96m"),   // CYAN
    WHITE_BRIGHT("\033[97m"),  // WHITE

    // Bold High Intensity
    BLACK_BOLD_BRIGHT("\033[1;90m"), // BLACK
    RED_BOLD_BRIGHT("\033[1;91m"),   // RED
    GREEN_BOLD_BRIGHT("\033[1;92m"), // GREEN
    YELLOW_BOLD_BRIGHT("\033[1;93m"),// YELLOW
    BLUE_BOLD_BRIGHT("\033[1;94m"),  // BLUE
    PURPLE_BOLD_BRIGHT("\033[1;95m"),// PURPLE
    CYAN_BOLD_BRIGHT("\033[1;96m"),  // CYAN
    WHITE_BOLD_BRIGHT("\033[1;97m"), // WHITE

    // High Intensity backgrounds
    BLACK_BACKGROUND_BRIGHT("\033[100m"), // BLACK
    RED_BACKGROUND_BRIGHT("\033[101m"),   // RED
    GREEN_BACKGROUND_BRIGHT("\033[102m"), // GREEN
    YELLOW_BACKGROUND_BRIGHT("\033[103m"),// YELLOW
    BLUE_BACKGROUND_BRIGHT("\033[104m"),  // BLUE
    PURPLE_BACKGROUND_BRIGHT("\033[105m"),// PURPLE
    CYAN_BACKGROUND_BRIGHT("\033[106m"),  // CYAN
    WHITE_BACKGROUND_BRIGHT("\033[107m"); // WHITE


    private String ansiCode;

    public String getAnsiCode() {
        return ansiCode;
    }

    Colors(String ansiCode) {
        this.ansiCode = ansiCode;
    }

    @Override
    public String toString() {
        return getAnsiCode();
    }

}
