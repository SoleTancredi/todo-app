package com.project.todoapp.service;

import com.project.todoapp.mapper.TaskInDTOToTask;
import com.project.todoapp.persistence.entity.Task;
import com.project.todoapp.persistence.repository.TaskRepository;
import com.project.todoapp.service.dto.TaskInDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository repository;
    private final TaskInDTOToTask mapper;

    public TaskService(TaskRepository repository, TaskInDTOToTask mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Task createTask(TaskInDTO taskInDTO){
        Task task = mapper.map(taskInDTO);
        return this.repository.save(task);
    }

    public List<Task> findAll(){
        return this.repository.findAll();
    }
}
