package com.projectmanager.projectmanager.dto;

import com.projectmanager.projectmanager.model.Task;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TaskResponseDTO {
    private Long id;
    private String description;
    private String status;
    private String priority;
    private LocalDateTime assignedAt;
    private LocalDateTime completionAt;
    private String userName;

    public TaskResponseDTO(Task task) {
        this.id = task.getId();
        this.description = task.getDescription();
        this.status = task.getStatus().name();
        this.priority = task.getPriority().name();
        this.assignedAt = task.getAssignedAt();
        this.completionAt = task.getCompletionAt();
        this.userName = task.getUser().getName() ;
    }
}