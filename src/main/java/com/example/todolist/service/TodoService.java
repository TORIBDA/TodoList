package com.example.todolist.service;

import com.example.todolist.entity.Todo;
import com.example.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodo() {
        return todoRepository.findAll();
    }

    public Todo addTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo updateTodo(Integer id, Todo updatedTodoInfo) {
        Todo updatedTodo = updateTodoInformation(findTodoById(id), updatedTodoInfo);
        return todoRepository.save(updatedTodo);
    }

    private Todo updateTodoInformation(Todo todo, Todo updatedTodo) {
        todo.setDone(updatedTodo.getDone());
        return todo;
    }

    private Todo findTodoById(Integer id) {
        return todoRepository.findById(id).orElse(null);
    }

    public Todo deleteTodo(Integer id) {
        Todo todoToDelete = findTodoById(id);
        todoRepository.deleteById(id);
        return todoToDelete;
    }
}
