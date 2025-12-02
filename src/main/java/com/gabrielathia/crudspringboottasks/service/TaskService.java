package com.gabrielathia.crudspringboottasks.service;


import com.gabrielathia.crudspringboottasks.model.Task;
import com.gabrielathia.crudspringboottasks.dto.*;
import com.gabrielathia.crudspringboottasks.repository.TarefaRepository;
import com.gabrielathia.crudspringboottasks.enums.Status;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TaskService {
    private final TarefaRepository repository;

//Constructor

    public TaskService(TarefaRepository repository) {
        this.repository = repository;
    }

//Data-Base Methods

    public Task createTaskRepository(Task task) {
        repository.save(task);
        return task;
    }

    public List<Task> listTasksRepository() {
        return repository.findAll();
    }

    public Task getTaskbyIdRepository(long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Task> getTaskbyStatusRepository(String status) {
        return repository.findByStatus(status);
    }

    public void deleteTaskRepository(long id) {
        repository.deleteById(id);
    }

//Callable Methods

    public ResponseTask createTask(RequestTask requestTask) {
        Task newTask = new Task();
        newTask.setName(requestTask.getTaskName());
        newTask.setDescription(requestTask.getTaskDescription());
        LocalDate localDate = LocalDate.now();
        String formatedDate = formatDate(localDate);
        newTask.setCreationDate(formatedDate);
        newTask.setUpdateDate(formatedDate);

        Task save = createTaskRepository(newTask);

        return new ResponseTask(save.getId(), save.getName(), save.getDescription(),
        save.getCreationDate(), save.getUpdateDate());
    }

    public List<Task> listTasks() {
        return repository.findAll();
    }

    public ResponseTask getTaskById(long id) {
        Task requestedTask = getTaskbyIdRepository(id);
        if (requestedTask == null) {return null;}
        return new ResponseTask(requestedTask.getId(), requestedTask.getName(), requestedTask.getDescription(),  requestedTask.getStatus(),
        requestedTask.getCreationDate(), requestedTask.getUpdateDate(), requestedTask.getCompletedDate());
    }

    public ResponseTask updateTaskbyId(long id, RequestTask requestTask) {
        Task taskToChange = getTaskbyIdRepository(id);
        if (taskToChange == null) {return null;}
        taskToChange.setName(requestTask.getTaskName());
        taskToChange.setDescription(requestTask.getTaskDescription());
        LocalDate localDate = LocalDate.now();
        String formatedDate = formatDate(localDate);
        taskToChange.setUpdateDate(formatedDate);
        Task finalTask = repository.save(taskToChange);
        return new ResponseTask(finalTask.getId(), finalTask.getName(), finalTask.getDescription(), finalTask.getStatus(),
        finalTask.getCreationDate(), finalTask.getUpdateDate(), finalTask.getCompletedDate());
    }

    public ResponseTask concludeTask(long id) {
        Task taskToChange = getTaskbyIdRepository(id);
        if (taskToChange == null) {return null;}
        taskToChange.setStatus(Status.CONCLUIDA);
        LocalDate localDate = LocalDate.now();
        String formatedDate = formatDate(localDate);
        taskToChange.setCompletedDate(formatedDate);
        Task finalTask = createTaskRepository(taskToChange);
        return new ResponseTask(finalTask.getId(), finalTask.getName(), finalTask.getDescription(), finalTask.getStatus(),
        finalTask.getCreationDate(), finalTask.getUpdateDate(), finalTask.getCompletedDate());
    }

    public ResponseTask cancelTask(long id) {
        Task taskToChange = getTaskbyIdRepository(id);
        if (taskToChange == null) {return null;}
        taskToChange.setStatus(Status.CANCELADA);
        Task finalTask = createTaskRepository(taskToChange);
        return new ResponseTask(finalTask.getId(), finalTask.getName(), finalTask.getDescription(), finalTask.getStatus(),
        finalTask.getCreationDate(), finalTask.getUpdateDate(), finalTask.getCompletedDate());
    }

    public List<Task> listByStatus(String status) {
        return repository.findByStatus(status);
    }

    public boolean deleteTaskbyId(long id) {
        Task taskToDelete = getTaskbyIdRepository(id);
        if (taskToDelete == null) {
            return false;
        }
        else {
            repository.delete(taskToDelete);
            return true;
        }
    }
//Auxiliary Methods

    private String formatDate(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
}