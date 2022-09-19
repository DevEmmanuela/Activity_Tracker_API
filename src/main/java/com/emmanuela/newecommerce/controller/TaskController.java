package com.emmanuela.newecommerce.controller;

import com.emmanuela.newecommerce.enums.TaskStatus;
import com.emmanuela.newecommerce.request.TaskRequest;
import com.emmanuela.newecommerce.services.serviceimpl.TaskServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private final TaskServiceImpl taskService;

    @PostMapping("/create-task")
    public ResponseEntity<String> createTask(@RequestBody TaskRequest taskRequest){
        return new ResponseEntity<>(taskService.createTask(taskRequest), HttpStatus.OK);
    }
    @GetMapping("/task-by-status")
    public ResponseEntity<List<TaskRequest>> getTaskByStatus(@RequestParam("status")  TaskStatus status){
        return new ResponseEntity<>(taskService.findByTaskStatus(status), HttpStatus.OK);
    }
}
