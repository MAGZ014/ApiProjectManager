package com.projectmanager.projectmanager.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "assigned_at")
    private LocalDateTime assignedAt;

    @Column(name = "completion_at")
    private LocalDateTime completionAt;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        INICIADO, EN_PROCESO, FINALIZADO
    }
}
