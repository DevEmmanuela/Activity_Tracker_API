package com.emmanuela.newecommerce.controller;

import com.emmanuela.newecommerce.request.TaskRequest;
import com.emmanuela.newecommerce.services.serviceimpl.TaskServiceImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private final TaskServiceImpl taskService;

    @PostMapping("/create-task")
    public ResponseEntity<String> createTask(@RequestBody TaskRequest taskRequest){
        return new ResponseEntity<>(taskService.createTask(taskRequest), HttpStatus.OK);
    }
}
