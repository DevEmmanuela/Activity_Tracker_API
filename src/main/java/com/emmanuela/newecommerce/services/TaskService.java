package com.emmanuela.newecommerce.services;

import com.emmanuela.newecommerce.request.TaskRequest;

public interface TaskService {
    //String create(CreateTaskDto createTaskDto);
    //    List<TaskResponseDto> findByStatus(Status status);
    //
    //    String UpdateTaskByUser(Long id, UserTaskUpdateDto userTaskUpdateDto);
    //
    //    String UpdateByStatus(Long id, UserTaskStatusUpdateDto userTaskStatusUpdateDto);
    //
    //    List<AllTaskResponseDto> findAllTaskByUser();
    //
    //    String deleteTask(Long id);

    String createTask(TaskRequest taskRequest);
}
