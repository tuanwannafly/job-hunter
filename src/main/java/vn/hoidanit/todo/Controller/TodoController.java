package vn.hoidanit.todo.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vn.hoidanit.todo.Entity.Todo;
import vn.hoidanit.todo.Service.TodoService;

@RestController
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/todos")
    public ResponseEntity<Todo> createTodo(@RequestBody Todo req) {
        Todo newTodo = this.todoService.handelCreateTodo(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTodo);
    }

     @GetMapping("/todos/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
        Todo todoData = this.todoService.getTodoById(id);
        return ResponseEntity.ok().body(todoData);
    }
    
    @GetMapping("/todos")
    public ResponseEntity<List<Todo>> getTodos() {
        List<Todo> todos = this.todoService.handleGetTodo();
        return ResponseEntity.ok().body(todos);
    }

    @PutMapping("/todos/{id}")
    public ResponseEntity<String> updateTodo(@PathVariable Long id, @RequestBody Todo req) {
        this.todoService.handleUpdateTodo(id, req);
        return ResponseEntity.ok().body("update success");
    }

    // @GetMapping("/update-todo")
    // public ResponseEntity<List<Todo>> getTodos() {
    //     List<Todo> todos = this.todoService.handleGetTodo();
    //     return ResponseEntity.ok().body(todos);
    // }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable Long id) {
        this.todoService.handleDeleteTodo(id);
        return ResponseEntity.ok().body("delete success");
    }

}
