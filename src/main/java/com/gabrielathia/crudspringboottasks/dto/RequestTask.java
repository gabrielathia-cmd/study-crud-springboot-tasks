package com.gabrielathia.crudspringboottasks.dto;

public class RequestTask {

//Class Atributes

    private String taskName;
    private String taskDescription;

//Constructor

    public RequestTask(String taskName, String taskDescription) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
    }

//Getters

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }
}
