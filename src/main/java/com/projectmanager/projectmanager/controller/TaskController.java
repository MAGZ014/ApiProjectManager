package com.projectmanager.projectmanager.controller;

import com.projectmanager.projectmanager.dto.TaskDTO;
import com.projectmanager.projectmanager.dto.TaskResponseDTO;
import com.projectmanager.projectmanager.model.Task;
import com.projectmanager.projectmanager.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private TaskService taskService;
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskResponseDTO> userList() {
        List<Task> tasks = taskService.getAllTask();
        return tasks.stream()
                .map(TaskResponseDTO::new)
                .toList();
    }

    @PostMapping
    public TaskResponseDTO createTask(@RequestBody TaskDTO taskDTO) {
        Task task = taskService.createTask(taskDTO);
        return new TaskResponseDTO(task);
    }

    @PutMapping("/{id}")
    public TaskResponseDTO updateUser(@PathVariable Long id, @RequestBody TaskDTO taskDTO) {
        Task task = taskService.updateTask(id, taskDTO);
        return new TaskResponseDTO(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
