package com.project.todoapp.persistence.repository;

import com.project.todoapp.persistence.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository <Task, Long> {

}
