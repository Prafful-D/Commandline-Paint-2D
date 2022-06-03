package com.pd.paint.paint.commands;

/**
 * @author PraffulD
 */
public interface Command<T> {

    String serviceCommand();

    int executeCommand(String[] args);
}
