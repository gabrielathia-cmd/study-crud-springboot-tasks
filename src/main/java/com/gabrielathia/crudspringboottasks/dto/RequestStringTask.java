package com.gabrielathia.crudspringboottasks.dto;

public class RequestStringTask {
    private long id;
    private String name;
    private String description;

    public RequestStringTask(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
