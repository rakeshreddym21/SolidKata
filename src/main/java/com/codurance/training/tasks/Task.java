package com.codurance.training.tasks;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public final class Task {
    private final String id;
    private final String description;
    private boolean done;

    private LocalDate deadline;

    public Task(String id, String description, boolean done) {
        this.id = id;
        this.description = description;
        this.done = done;
    }
}
