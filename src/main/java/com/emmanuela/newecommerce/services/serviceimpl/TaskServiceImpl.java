package com.emmanuela.newecommerce.services.serviceimpl;

import com.emmanuela.newecommerce.customexceptions.TaskAlreadyExistException;
import com.emmanuela.newecommerce.customexceptions.TaskNotFoundException;
import com.emmanuela.newecommerce.customexceptions.UserNotFoundException;
import com.emmanuela.newecommerce.entities.Task;
import com.emmanuela.newecommerce.entities.Users;
import com.emmanuela.newecommerce.enums.TaskStatus;
import com.emmanuela.newecommerce.repository.TaskRepository;
import com.emmanuela.newecommerce.repository.UsersRepository;
import com.emmanuela.newecommerce.request.TaskRequest;
import com.emmanuela.newecommerce.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final UsersRepository usersRepository;
    private final TaskRepository taskRepository;

    @Override
    public String createTask(TaskRequest taskRequest) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Users users = usersRepository.findUsersByEmail(user.getUsername());
        if(users == null){
            throw new UserNotFoundException("user not found");
        }

        Optional<Task> existingTask = Optional.ofNullable(taskRepository.findTaskByTitle(taskRequest.getTitle()));

        if(existingTask.isPresent()){
            throw new TaskAlreadyExistException("This task title already exist");
        }

        Task task = new Task();
        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        task.setStatus(TaskStatus.PENDING);
        task.setUser1(users);
        task.setCreatedAt(LocalDateTime.now());

        taskRepository.save(task);
        return "Task created successfully";
    }

    @Override
    public List<TaskRequest> findByTaskStatus(TaskStatus status) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Users users = usersRepository.findUsersByEmail(user.getUsername());
        if(users == null){
            throw new UserNotFoundException("user not found");
        }

        List<Task> usersTask = taskRepository.findTaskByStatus(status);
        if(usersTask == null){
            throw new TaskNotFoundException("Task not found");
        }

        List<TaskRequest> tasks = new ArrayList<>();

        for(Task eachTask : usersTask){
            TaskRequest taskRequest = new TaskRequest();
            taskRequest.setStatus(eachTask.getStatus());
            taskRequest.setDescription(eachTask.getDescription());
            taskRequest.setTitle(eachTask.getTitle());
            taskRequest.setCreatedAt(eachTask.getCreatedAt());
            taskRequest.setUpdatedAt(eachTask.getUpdatedAt());
            taskRequest.setCompletedAt(eachTask.getCompletedAt());
            taskRequest.setId(eachTask.getId());

            tasks.add(taskRequest);
        }
        return tasks;
    }

    @Override
    public String updateTask(Long taskId, TaskRequest taskRequest) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Users users = usersRepository.findUsersByEmail(user.getUsername());
        if(users == null){
            throw new UserNotFoundException("user not found");
        }

        Task task = taskRepository.findTaskById(taskId);
        if(task == null){
            throw new TaskNotFoundException("Task Not Found");
        }

        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        task.setUpdatedAt(taskRequest.getUpdatedAt());
        task.setUpdatedAt(LocalDateTime.now());
        taskRepository.save(task);
        return "Task Updated";
    }
}
