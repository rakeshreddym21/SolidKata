package com.codurance.training.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CommandFactoryImpl implements CommandFactory {
    private static final String QUIT = "quit";


    private final BufferedReader in;
    private final PrintWriter out;

    private final List<Project> projects = new ArrayList<>();
    Instructions instructions = new InstructionsImplementation(projects);

    public CommandFactoryImpl(BufferedReader in, PrintWriter out) {
        this.in = in;
        this.out = out;
    }

    @Override
    public void run() {
        while (true) {
            out.print("> ");
            out.flush();
            String command;
            try {
                command = in.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (command.equals(QUIT)) {
                break;
            }
            executeCommand(command);
        }
    }

    @Override
    public void executeCommand(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];
        switch (command) {
            case "add":
                instructions.add(commandRest[1]);
                break;
            case "delete":
                instructions.deleteTaskByTaskId(commandRest[1]);
                break;
            case "help":
                instructions.help();
                break;
            case "viewTasksByDeadline":
                instructions.viewTasksByDeadline();
                break;
            case "viewByProject":
                instructions.viewByProjects();
                break;
            case "deadline":
                instructions.setDeadlineByTaskId(commandRest[1]);
                break;
            case "today":
                instructions.today();
                break;
            case "viewTaskByDate":
                instructions.viewTasksByDate(commandRest[1]);
                break;
            default:
                instructions.error(command);
                break;
        }
    }
}