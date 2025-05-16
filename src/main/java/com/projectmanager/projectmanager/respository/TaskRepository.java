package com.projectmanager.projectmanager.respository;

import com.projectmanager.projectmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long>{
}
