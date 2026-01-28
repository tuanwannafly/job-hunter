package vn.hoidanit.todo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.hoidanit.todo.Entity.Todo;
import vn.hoidanit.todo.Service.TodoService;

@RestController
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/create-todo")
    public String create() {
        Todo myTodo = new Todo("hoidanit", true);
        Todo newtodo = this.todoService.handelCreateTodo(myTodo);
        return "create todo with id = " + newtodo.getId();
    }
}
