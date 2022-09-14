package com.codurance.training.tasks;

public interface Instructions {
    void add(String command);
    void deleteTaskByTaskId(String id);
    void help();
    void error(String command);
    void viewTasksByDate(String command);
    void viewTasksByDeadline();
    void today();
    void setDeadlineByTaskId(String command);
    void viewByProjects();
}
