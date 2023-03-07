package com.project.todoapp.persistence.repository;

import com.project.todoapp.persistence.entity.Task;
import com.project.todoapp.persistence.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository <Task, Long> {

    //with this springDataJpa knows that it has to connect to the database
    // and look up the statuses and filter them according to the obtained by parameter
    public List<Task> findAllByTaskStatus(TaskStatus status);
}
