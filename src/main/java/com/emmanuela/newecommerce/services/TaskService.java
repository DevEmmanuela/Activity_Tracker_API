package com.emmanuela.newecommerce.services;

import com.emmanuela.newecommerce.enums.TaskStatus;
import com.emmanuela.newecommerce.request.TaskRequest;

import java.util.List;

public interface TaskService {
    //
    //    String UpdateTaskByUser(Long id, UserTaskUpdateDto userTaskUpdateDto);
    //
    //    String UpdateByStatus(Long id, UserTaskStatusUpdateDto userTaskStatusUpdateDto);
    //
    //    List<AllTaskResponseDto> findAllTaskByUser();
    //
    //    String deleteTask(Long id);

    String createTask(TaskRequest taskRequest);

    List<TaskRequest> findByTaskStatus(TaskStatus status);
}
