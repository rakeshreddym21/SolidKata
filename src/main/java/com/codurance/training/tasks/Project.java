package com.codurance.training.tasks;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    public String name;
    private List<Task> taskList;

    public Project(String projectName) {
        this.name=projectName;
    }
}
