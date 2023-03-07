package com.project.todoapp.controller;

import com.project.todoapp.persistence.entity.Task;
import com.project.todoapp.persistence.entity.TaskStatus;
import com.project.todoapp.service.TaskService;
import com.project.todoapp.service.dto.TaskInDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @PostMapping
    public Task createTask(@RequestBody TaskInDTO taskInDTO){
        return this.taskService.createTask(taskInDTO);
    }
    @GetMapping
    public List<Task> findAll(){
        return this.taskService.findAll();
    }
    @GetMapping("/status/{status}")
    public List<Task> findAllByStatus(@PathVariable("status")TaskStatus status){
        return this.taskService.findAllByTaskStatus(status);
    }
    @PatchMapping("/updateFinished/{id}")
    public ResponseEntity<Void> updateFinished(@PathVariable("id") Long id){
        this.taskService.updateTaskFinished(id);
        return ResponseEntity.noContent().build();
    }

}
