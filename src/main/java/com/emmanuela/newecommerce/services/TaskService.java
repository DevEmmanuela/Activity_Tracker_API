package com.emmanuela.newecommerce.services;

import com.emmanuela.newecommerce.enums.TaskStatus;
import com.emmanuela.newecommerce.request.TaskRequest;
import java.util.List;

public interface TaskService {
    String createTask(TaskRequest taskRequest);
    List<TaskRequest> findByTaskStatus(TaskStatus status);
    String updateTask(Long taskId, TaskRequest taskRequest);
    String updateByStatus(Long taskId, TaskRequest taskRequest);
    List<TaskRequest> findAllTask();
    String deleteTask(Long taskId);
}
