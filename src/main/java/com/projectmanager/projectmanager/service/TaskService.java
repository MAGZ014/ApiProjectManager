package com.projectmanager.projectmanager.service;

import com.projectmanager.projectmanager.dto.TaskDTO;
import com.projectmanager.projectmanager.model.Task;
import com.projectmanager.projectmanager.model.User;
import com.projectmanager.projectmanager.respository.TaskRepository;
import com.projectmanager.projectmanager.respository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository){
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public List<Task> getAllTask(){
        return taskRepository.findAll();
    }

    public Task createTask(TaskDTO taskDTO) {
        User user = userRepository.findById(taskDTO.getUser_Id())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Task task = new Task();
        task.setDescription(taskDTO.getDescription());
        task.setAssignedAt(taskDTO.getAssignedAt() != null ? taskDTO.getAssignedAt(): LocalDateTime.now());
        task.setCompletionAt(taskDTO.getCompletionAt());
        task.setStatus(Task.Status.valueOf(taskDTO.getStatus()));
        task.setPriority(Task.Priority.valueOf(taskDTO.getPriority()));
        task.setUser(user);

        return taskRepository.save(task);
    }


    public Task updateTask(Long id, TaskDTO taskDTO){
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        User user = userRepository.findById(taskDTO.getUser_Id())
                .orElseThrow(() -> new RuntimeException("User not found"));

        task.setDescription(taskDTO.getDescription());
        task.setAssignedAt(taskDTO.getAssignedAt());
        task.setCompletionAt(taskDTO.getCompletionAt());
        task.setStatus(Task.Status.valueOf(taskDTO.getStatus()));
        task.setPriority(Task.Priority.valueOf(taskDTO.getPriority()));
        task.setUser(user);

        return taskRepository.save(task);
    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }
}
