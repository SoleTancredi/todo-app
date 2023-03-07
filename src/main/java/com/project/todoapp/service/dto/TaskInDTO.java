package com.project.todoapp.service.dto;

import lombok.Data;

import java.time.LocalDateTime;

//data transfer object allows moving data from one layer to another in a simple way,
// without the need to pass all entity data throughout the app.
@Data
public class TaskInDTO {
    private String title;
    private String description;
    private LocalDateTime eta;
}
