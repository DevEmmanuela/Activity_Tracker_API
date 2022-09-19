package com.emmanuela.newecommerce.customexceptions;

public class TaskAlreadyExistException extends RuntimeException{
    public TaskAlreadyExistException(String message) {
        super(message);
    }
}
