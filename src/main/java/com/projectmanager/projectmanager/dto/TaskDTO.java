package com.projectmanager.projectmanager.dto;

import java.time.LocalDateTime;
import jakarta.validation.constraints.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDTO {

    @NotBlank(message = "La descripción no puede estar vacía")
    @Size(min = 5, max = 255, message = "La descripción debe tener entre 5 y 255 caracteres")
    private String description;

    private LocalDateTime assignedAt;
    private LocalDateTime completionAt;

    @NotBlank(message = "El estado es obligatorio")
    @Pattern(regexp = "INICIADO|EN_PROCESO|FINALIZADO", message = "El estado debe ser INICIADO, EN_PROCESO o FINALIZADO")
    private String status;

    @NotBlank(message = "La prioridad es obligatoria")
    @Pattern(regexp = "BAJA|MEDIA|ALTA", message = "La prioridad debe ser BAJA, MEDIA o ALTA")
    private String priority;

    @NotNull(message = "El ID de usuario es obligatorio")
    private Long user_Id;
}