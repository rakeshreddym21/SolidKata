package com.codurance.training.tasks;

import java.util.ArrayList;
import java.util.List;

public class ProjectCommandsImplementation implements ProjectCommands {



    @Override
    public void viewProjects(List<Project> projects) {
        for(Project project: projects){
            for (Task task : project.getTaskList()) {
                System.out.println(task.toString());
            }
        }
    }

    @Override
    public void addProject(List<Project> projectList, String command) {
        projectList.add(new Project( command.split(" ", 2)[1]));

    }

    @Override
    public void addTaskToProject(List<Project> projectList, String command) {
        String[] subcommands = command.split(" ", 3);
        for(Project project:projectList)
        {
            if(project.getName().equals(subcommands[0])) {
                if (project.getTaskList() == null)
                    project.setTaskList(new ArrayList<>());
                project.getTaskList().add(new Task(subcommands[1],subcommands[2],false ));
            }

        }
    }
}
