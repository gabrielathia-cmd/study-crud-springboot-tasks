package com.gabrielathia.crudspringboottasks.controller;
import com.gabrielathia.crudspringboottasks.model.Task;
import com.gabrielathia.crudspringboottasks.service.TaskService;
import com.gabrielathia.crudspringboottasks.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TasksController {

    private TaskService service;

    @Autowired
    public TasksController(TaskService taskService) {
        this.service = taskService;
    }

    @GetMapping
    public String helloTask() {
        return "Tasks area";
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseTask> createTask(@RequestBody RequestTask task) {
        ResponseTask responseTask = service.createTask(task);
        return ResponseEntity.ok(responseTask);
    }

    @GetMapping("/list-tasks")
    public ResponseEntity<List<Task>> updateTask() {
        List<Task> tasks = service.listTasks();
        if (tasks == null) {return null;}
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{idPath}")
    public ResponseEntity<ResponseTask> updateTask(@PathVariable String idPath) {
        long id = Long.parseLong(idPath);
        ResponseTask response = service.getTaskById(id);
        if (response == null) {return ResponseEntity.notFound().build();}
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{idPath}")
    public ResponseEntity<ResponseTask> updateTask(@PathVariable String idPath, @RequestBody RequestTask task) {
        long id = Long.parseLong(idPath);
        ResponseTask response = service.updateTaskbyId(id, task);
        if (response == null) {return ResponseEntity.notFound().build();}
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{idPath}/conclude")
    public ResponseEntity<ResponseTask> concludeTask(@PathVariable String idPath) {
        long id = Long.parseLong(idPath);
        ResponseTask response = service.concludeTask(id);
        if (response == null) {return ResponseEntity.notFound().build();}
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{idPath}/cancel")
    public ResponseEntity<ResponseTask> cancelTask(@PathVariable String idPath) {
        long id = Long.parseLong(idPath);
        ResponseTask response = service.cancelTask(id);
        if (response == null) {return ResponseEntity.notFound().build();}
        return ResponseEntity.ok(response);
    }

    @GetMapping("/status={statusPath}")
    public ResponseEntity<List<Task>> getTasksByStatus(@PathVariable String statusPath) {
        List<Task> tasks = service.listByStatus(statusPath);
        if (tasks == null) {return ResponseEntity.notFound().build();}
        return ResponseEntity.ok(tasks);
    }

    @DeleteMapping("/{idPath}")
    public boolean deleteTask(@PathVariable String idPath) {
        long id = Long.parseLong(idPath);
        return service.deleteTaskbyId(id);
    }
}
