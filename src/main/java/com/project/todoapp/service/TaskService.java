package com.project.todoapp.service;

import com.project.todoapp.exceptions.TodoExceptions;
import com.project.todoapp.mapper.TaskInDTOToTask;
import com.project.todoapp.persistence.entity.Task;
import com.project.todoapp.persistence.entity.TaskStatus;
import com.project.todoapp.persistence.repository.TaskRepository;
import com.project.todoapp.service.dto.TaskInDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.Table;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

    public List<Task> findAllByTaskStatus(TaskStatus status){
        return this.repository.findAllByTaskStatus(status);
    }
    @Transactional
    public void updateTaskFinished(Long id){
        Optional<Task> optionalTask = this.repository.findById(id);

        if(optionalTask.isEmpty()){
            throw new TodoExceptions("Task not found.", HttpStatus.NOT_FOUND);
        }

        this.repository.markTaskAsFinished(id);
    }


    public void deleteById(Long id){
        Optional<Task> optionalTask = this.repository.findById(id);

        if(optionalTask.isEmpty()){
            throw new TodoExceptions("Task not found.", HttpStatus.NOT_FOUND);
        }

        this.repository.deleteById(id);
    }


}
