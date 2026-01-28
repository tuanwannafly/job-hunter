package vn.hoidanit.todo.Service;

import org.springframework.stereotype.Service;

import vn.hoidanit.todo.Entity.Todo;
import vn.hoidanit.todo.Repository.TodoRepository;

@Service
public class TodoService {
    private final TodoRepository todoRepository;
    
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo handelCreateTodo(Todo todo) {
        Todo newtodo = this.todoRepository.save(todo);
        return newtodo;
    }
}
