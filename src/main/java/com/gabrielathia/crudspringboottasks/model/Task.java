package com.gabrielathia.crudspringboottasks.model;

import lombok.Getter;
import jakarta.persistence.*;
import com.gabrielathia.crudspringboottasks.enums.Status;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private String creationDate;
    private String updateDate;
    private String completedDate;
    @Enumerated(EnumType.STRING)
    private Status status;

//Constructors

    public Task(long id, String name, String description, String creationDate,
    String updateDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.status = Status.PENDENTE;
        this.completedDate = null;
    }

    public Task() {
        this.completedDate = null;
    }

//Getters and Setters

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCompletedDate() {
        if (this.completedDate == null) {
            return null;
        }
        return this.completedDate;
    }

    public void setCompletedDate(String completedDate) {
        this.completedDate = completedDate;
    }
}
