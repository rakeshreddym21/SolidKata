package com.codurance.training.tasks;


import java.time.LocalDate;
import java.util.List;

public class TaskCommandsImplementation implements TaskCommands{

    @Override
    public void getTasksByDate(List<Project> projects, String command) {
        for(Project project: projects){
            for (Task task : project.getTaskList()) {
                if(task.getDeadline()!=null && task.getDeadline().isEqual(LocalDate.parse(command)))
                {
                System.out.printf(task.toString());}
            }
            System.out.println();
        }
    }

    @Override
    public void getTasksByDeadLine(List<Project> projects) {
        for(Project project: projects){
            for (Task task : project.getTaskList()) {
                if(task.getDeadline()!=null) {
                    System.out.println(task.toString());
                }
            }
        }
    }

    @Override
    public void getTasksDueToday(List<Project> projects) {
        for(Project project: projects){
            System.out.println(project.getName());
            for (Task task : project.getTaskList()) {
                if(task.getDeadline()!=null && task.getDeadline().isEqual(LocalDate.now())) {
                    System.out.printf(task.toString());
                }
            }
            System.out.println();
        }
    }

    @Override
    public void deleteTaskUsingId(List<Project> projects, String taskId) {
        Task task = null;
        for(Project project: projects){
            List<Task> projectTaskList = project.getTaskList();
            for(Task tempTask: projectTaskList) {
                if (tempTask.getId().equals(taskId)) {
                    projectTaskList.remove(tempTask);
                    break;
                }
            }
            project.setTaskList(projectTaskList);
        }
    }

    @Override
    public void setDeadline(List<Project> projects, String command) {
        String[] subcommandRest = command.split(" ", 2);
        String taskId = subcommandRest[0];
        for(Project project: projects){
            for(Task task: project.getTaskList()){
                if (task.getId().equals(taskId)) {
                    task.setDeadline(LocalDate.parse(subcommandRest[1]));                }
            }
        }
    }
}
