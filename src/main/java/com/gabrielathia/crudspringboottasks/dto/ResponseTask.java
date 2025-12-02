package com.gabrielathia.crudspringboottasks.dto;

import com.gabrielathia.crudspringboottasks.enums.Status;

public class ResponseTask {
    private final long id;
    private String name;
    private String description;
    private final String creationDate;
    private String updateDate;
    private String completedDate;
    private Status status;

//Constructors

    public ResponseTask(long id, String name, String description, Status status,  String creationDate,
    String updateDate, String completedDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.completedDate = completedDate;
    }

    public ResponseTask(long id, String name, String description, String creationDate,
    String updateDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.status = Status.PENDENTE;
        this.completedDate = null;
    }

//Getters

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return this.status;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public String getCompletedDate() {
        return this.completedDate;
    }
}
