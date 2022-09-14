package com.codurance.training.tasks;

import java.util.List;

public interface TaskCommands {

    void getTasksByDate(List<Project> projects, String command);
    void getTasksByDeadLine(List<Project> projects);
    void getTasksDueToday(List<Project> projects);
    void deleteTaskUsingId(List<Project> projects, String taskId);

    void setDeadline(List<Project> projects,String Command);
}
