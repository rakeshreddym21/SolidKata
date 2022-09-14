package com.codurance.training.tasks;

import java.util.List;

public interface ProjectCommands {
    void viewProjects(List<Project> projects);
    void addProject(List<Project> projectList,String command);
    void addTaskToProject(List<Project> projectList,String command);
}
