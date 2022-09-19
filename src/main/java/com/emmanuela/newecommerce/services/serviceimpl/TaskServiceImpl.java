package com.emmanuela.newecommerce.services.serviceimpl;

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
        Task task = new Task();
        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        task.setStatus(TaskStatus.PENDING);
        task.setUser1(users);
        task.setCreatedAt(LocalDateTime.now());

        taskRepository.save(task);
        return "Task created successfully";
    }
}
