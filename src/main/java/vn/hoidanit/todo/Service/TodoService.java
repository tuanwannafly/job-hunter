package vn.hoidanit.todo.Service;

import java.util.List;
import java.util.Optional;

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
    public List<Todo> handleGetTodo() {
        return this.todoRepository.findAll();
    }

    public Todo getTodoById(Long id ) {
        Optional<Todo> todoOptional = this.todoRepository.findById(id);
        return todoOptional.isPresent()? todoOptional.get() : null;
    }

    public void handleUpdateTodo(Long id, Todo iptodo) {
        Optional<Todo> todoOptional = this.todoRepository.findById(id);
        if(todoOptional.isPresent()) {
            Todo curTodo = todoOptional.get();
            curTodo.setIsCompleted(iptodo.isIsCompleted());
            curTodo.setUsername(iptodo.getUsername());
            this.todoRepository.save(curTodo);
        }
    }

    public void handleDeleteTodo(Long id )  {
        Optional<Todo> todoOptional = this.todoRepository.findById(id);
        if(todoOptional.isPresent()) {
            this.todoRepository.deleteById(id);
        }
    }

}
