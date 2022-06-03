package com.pd.paint.paint.utils;

/**
 * @author PraffulD
 */
public enum CommandsEnum {

    CREATE_CANVAS("C"), DRAW_LINE("L"), QUIT("Q");

    private String command;

    CommandsEnum(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
