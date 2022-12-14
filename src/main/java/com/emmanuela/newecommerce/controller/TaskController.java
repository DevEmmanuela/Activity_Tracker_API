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

    @PutMapping("/update-task/{id}")
    public ResponseEntity<String> updateTask(@PathVariable("id") Long taskId, @RequestBody TaskRequest taskRequest){
        return new ResponseEntity<>(taskService.updateTask(taskId, taskRequest), HttpStatus.OK);
    }

    @PutMapping("/update-task-status/{id}")
    public ResponseEntity<String> updateTaskStatus(@PathVariable("id") Long taskId, @RequestBody TaskRequest taskRequest){
        return new ResponseEntity<>(taskService.updateByStatus(taskId, taskRequest), HttpStatus.OK);
    }

    @GetMapping("/all-task")
    public ResponseEntity <List<TaskRequest>> getAllTask(){
        return ResponseEntity.ok(taskService.findAllTask());
    }

    @DeleteMapping("/delete-task/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") Long taskId){
        return new ResponseEntity<>(taskService.deleteTask(taskId), HttpStatus.OK);
    }
}
