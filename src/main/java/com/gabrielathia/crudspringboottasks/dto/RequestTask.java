package com.gabrielathia.crudspringboottasks.dto;

public class RequestTask {
    private String taskName;
    private String taskDescription;

    public RequestTask(String taskName, String taskDescription) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }
}
