package com.projectmanager.projectmanager.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDTO {
    private String description;
    private LocalDateTime assignedAt;
    private LocalDateTime completionAt;
    private String status;
    private String priority;
    private Long user_Id;
}