package com.codurance.training.tasks;

public interface CommandFactory {
    void run();
    void executeCommand(String command);
}
