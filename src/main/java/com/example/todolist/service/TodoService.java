package com.example.todolist.service;

import com.example.todolist.entity.Todo;
import com.example.todolist.exception.TodoNotFoundException;
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

    public Todo deleteTodo(Integer id) {
        Todo todoToDelete = findTodoById(id);
        todoRepository.deleteById(id);
        return todoToDelete;
    }

    private Todo updateTodoInformation(Todo todo, Todo updatedTodo) {
        if(!todo.getDone().equals(updatedTodo.getDone())) {
            todo.setDone(updatedTodo.getDone());
        }
        if(updatedTodo.getText()!=null && !todo.getText().equals(updatedTodo.getText())) {
            todo.setText(updatedTodo.getText());
        }
        return todo;
    }

    private Todo findTodoById(Integer id) {
        return todoRepository.findById(id).orElseThrow(TodoNotFoundException::new);
    }
}
