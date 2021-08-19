package com.example.todolist.exception;

public class TodoNotFoundException extends RuntimeException{
    @Override
    public String getMessage() {
        return "The Todo could not be found. Please check the ID to be deleted";
    }
}
