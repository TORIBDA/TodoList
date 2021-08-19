package com.example.todolist.controller;

import com.example.todolist.entity.Todo;
import com.example.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public List<Todo> getAllTodo() {
        return todoService.getAllTodo();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Todo addTodo(@RequestBody Todo todo) {
        return todoService.addTodo(todo);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Todo updateTodo(@PathVariable Integer id, @RequestBody Todo updatedTodoInfo) {
        return todoService.updateTodo(id, updatedTodoInfo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Todo deleteTodo(@PathVariable Integer id) {
        return todoService.deleteTodo(id);
    }
}
