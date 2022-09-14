package com.codurance.training.tasks;

import java.util.List;

public class InstructionsImplementation implements Instructions{
    private  List<Project> projects;
    private  TaskCommands taskCommandsImpl ;
    private  ProjectCommands projectCommandsImpl ;

    public InstructionsImplementation(List<Project> projects) {
        this.projects = projects;
        taskCommandsImpl=new TaskCommandsImplementation();
        projectCommandsImpl=new ProjectCommandsImplementation();
    }





    @Override
    public void help() {
        System.out.println("> add project <project_name>");
        System.out.println("> add task <project_name> <task_id> <task_description>");
        System.out.println("> viewByProject");
        System.out.println("> viewTasksByDeadline");
        System.out.println("> viewByDate <date>");
        System.out.println("> deadline <task ID> <date>");
        System.out.println("> help");
        System.out.println("> quit");
    }

    @Override
    public void error(String command) {
        System.out.printf("Sorry,Given Command" +command+  "is not executable");
    }

    @Override
    public void viewTasksByDate(String command) {
      taskCommandsImpl.getTasksByDate(projects,command);
    }

    @Override
    public void viewTasksByDeadline() {
        taskCommandsImpl.getTasksByDeadLine(projects);

    }

    @Override
    public void today() {
        taskCommandsImpl.getTasksDueToday(projects);
    }

    @Override
    public void setDeadlineByTaskId(String command) {
        taskCommandsImpl.setDeadline(projects,command);
    }
    @Override
    public void viewByProjects() {
        projectCommandsImpl.viewProjects(projects);
    }
    @Override
    public void add(String command) {
        String[] subcommandRest = command.split(" ", 2);
        String subcommand = subcommandRest[0];
        if (subcommand.equals("project")) {
            projectCommandsImpl.addProject(projects,command);
        } else if (subcommand.equals("task")) {
            projectCommandsImpl.addTaskToProject(projects,subcommandRest[1]);
        }
    }
    @Override
    public void deleteTaskByTaskId(String id) {
        taskCommandsImpl.deleteTaskUsingId(projects, id);
    }
}
