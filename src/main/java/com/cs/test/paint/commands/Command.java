package com.cs.test.paint.commands;

/**
 * @author PraffulD
 */
public interface Command<T> {

    String serviceCommand();

    int executeCommand(String[] args);
}
